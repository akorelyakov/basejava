package com.github.akorelyakov.webapp.storage.serializer;

import com.github.akorelyakov.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {

    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("ddMMyyyy");

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry :
                    contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            Map<SectionType, AbstractSection> sections = resume.getSections();
            dos.writeInt(sections.size());
            for (Map.Entry<SectionType, AbstractSection> entry : sections.entrySet()) {
                writeSection(dos, entry);
            }
        }
    }

    private void writeSection(DataOutputStream dos, Map.Entry<SectionType, AbstractSection> entry) throws IOException {
        AbstractSection section = entry.getValue();
        SectionType type = entry.getKey();
        dos.writeUTF(type.name());
        switch (type) {
            case OBJECTIVE:
            case PERSONAL:
                dos.writeUTF(((TextSection) section).getContent());
                break;
            case ACHIEVEMENT:
            case QUALIFICATION:
                List<String> list = ((ListSection) section).getItems();
                dos.writeInt(list.size());
                for (String item : list) {
                    dos.writeUTF(item);
                }
                break;
            case EXPERIENCE:
            case EDUCATION:
                List<Organization> organizations = ((OrganizationSection) section).getOrganizations();
                dos.writeInt(organizations.size());
                for (Organization organization : organizations) {
                    Link homePage = organization.getHomePage();
                    dos.writeUTF(homePage.getName());
                    dos.writeUTF(homePage.getUrl() == null ? "" : homePage.getUrl());
                    List<Organization.Position> positions = organization.getPositions();
                    dos.writeInt(positions.size());
                    for (Organization.Position position : positions) {
                        writeLocalDate(dos, position.getStartDate());
                        writeLocalDate(dos, position.getEndDate());
                        //dos.writeUTF(position.getStartDate().format(FORMATTER));
                        //dos.writeUTF(position.getEndDate().format(FORMATTER));
                        dos.writeUTF(position.getTitle());
                        dos.writeUTF(position.getDescription() == null ? "" : position.getDescription());
                    }
                }
                break;
        }
    }

    private void writeLocalDate(DataOutputStream dos, LocalDate date) throws IOException {
        dos.writeInt(date.getYear());
        dos.writeInt(date.getMonthValue());
    }

    private LocalDate readLocalDate(int year, int month) {
        return LocalDate.of(year, month, 1);
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int contactsSize = dis.readInt();
            for (int i = 0; i < contactsSize; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }
            int sectionsSize = dis.readInt();
            for (int i = 0; i < sectionsSize; i++) {
                String sectionName = dis.readUTF();
                SectionType sectionType = SectionType.valueOf(sectionName);
                resume.addSection(sectionType, readSection(dis, sectionType));
            }
            return resume;
        }
    }

    private AbstractSection readSection(DataInputStream dis, SectionType sectionType) throws IOException {
        switch (sectionType) {
            case OBJECTIVE:
            case PERSONAL:
                return new TextSection(dis.readUTF());
            case ACHIEVEMENT:
            case QUALIFICATION:
                int listSize = dis.readInt();
                List<String> list = new ArrayList<>();
                for (int i = 0; i < listSize; i++) {
                    list.add(dis.readUTF());
                }
                return new ListSection(list);
            case EXPERIENCE:
            case EDUCATION:
                List<Organization> organizations = new ArrayList<>();
                int size = dis.readInt();
                for (int i = 0; i < size; i++) {
                    String name = dis.readUTF();
                    String url = dis.readUTF();
                    url = (url.isEmpty() ? null : url);
                    List<Organization.Position> positions = new ArrayList<>();
                    int stagesSize = dis.readInt();
                    for (int j = 0; j < stagesSize; j++) {
                        LocalDate startDate = readLocalDate(dis.readInt(), dis.readInt());
                        LocalDate endDate = readLocalDate(dis.readInt(), dis.readInt());
                        String title = dis.readUTF();
                        String description = dis.readUTF();
                        positions.add(new Organization.Position(startDate, endDate, title, (description.isEmpty() ?
                                null : description)));
                    }
                    organizations.add(new Organization(new Link(name, url), positions));
                }
                return new OrganizationSection(organizations);
        }
        return null;
    }
}