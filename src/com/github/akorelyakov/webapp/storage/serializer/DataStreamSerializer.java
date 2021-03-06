package com.github.akorelyakov.webapp.storage.serializer;

import com.github.akorelyakov.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class DataStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            writeCollection(dos, contacts.entrySet(), entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });
            Map<SectionType, AbstractSection> sections = resume.getSections();
            writeCollection(dos, sections.entrySet(), entry -> writeSection(dos, entry));
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
                writeCollection(dos, list, dos::writeUTF);
                break;
            case EXPERIENCE:
            case EDUCATION:
                List<Organization> organizations = ((OrganizationSection) section).getOrganizations();
                writeCollection(dos, organizations, organization -> {
                    Link homePage = organization.getHomePage();
                    dos.writeUTF(homePage.getName());
                    dos.writeUTF(homePage.getUrl() == null ? "" : homePage.getUrl());
                    List<Organization.Position> positions = organization.getPositions();
                    writeCollection(dos, positions, position -> {
                        writeLocalDate(dos, position.getStartDate());
                        writeLocalDate(dos, position.getEndDate());
                        dos.writeUTF(position.getTitle());
                        dos.writeUTF(position.getDescription() == null ? "" : position.getDescription());
                    });
                });
                break;
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            readCollection(dis, () -> resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF()));
            readCollection(dis, () -> {
                String sectionName = dis.readUTF();
                SectionType sectionType = SectionType.valueOf(sectionName);
                resume.addSection(sectionType, readSection(dis, sectionType));
            });
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
                List<String> list = new ArrayList<>();
                readCollection(dis, () -> list.add(dis.readUTF()));
                return new ListSection(list);
            case EXPERIENCE:
            case EDUCATION:
                List<Organization> organizations = new ArrayList<>();
                readCollection(dis, () -> {
                    String name = dis.readUTF();
                    String url = dis.readUTF();
                    url = (url.isEmpty() ? null : url);
                    List<Organization.Position> positions = new ArrayList<>();
                    readCollection(dis, () -> {
                        LocalDate startDate = readLocalDate(dis.readInt(), dis.readInt());
                        LocalDate endDate = readLocalDate(dis.readInt(), dis.readInt());
                        String title = dis.readUTF();
                        String description = dis.readUTF();
                        positions.add(new Organization.Position(startDate, endDate, title, (description.isEmpty() ?
                                null : description)));
                    });
                    organizations.add(new Organization(new Link(name, url), positions));
                });
                return new OrganizationSection(organizations);
        }
        return null;
    }

    private <T> void writeCollection(DataOutputStream dos, Collection<T> collection, CollectionWriter<T> action) throws IOException {
        dos.writeInt(collection.size());
        for (T t : collection) {
            action.accept(t);
        }
    }

    @FunctionalInterface
    public interface CollectionWriter<T> {
        void accept(T t) throws IOException;
    }

    private void readCollection(DataInputStream dis, CollectionReader action) throws IOException {
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
            action.accept();
        }
    }

    @FunctionalInterface
    public interface CollectionReader {
        void accept() throws IOException;
    }

    private void writeLocalDate(DataOutputStream dos, LocalDate date) throws IOException {
        dos.writeInt(date.getYear());
        dos.writeInt(date.getMonthValue());
    }

    private LocalDate readLocalDate(int year, int month) {
        return LocalDate.of(year, month, 1);
    }
}