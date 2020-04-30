package com.github.akorelyakov.webapp;

import com.github.akorelyakov.webapp.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static com.github.akorelyakov.webapp.model.ContactType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume testResume = fillResumeTestData();
        System.out.println(testResume.toString());
    }

    public static Resume fillResumeTestData() {
        Resume testResume = new Resume("Григорий Кислин");
        testResume.addContact(PHONE, "+7(921) 855-0482");
        testResume.addContact(SKYPE, "grigory.kislin");
        testResume.addContact(MAIL, "mailto:gkislin@yandex.ru");
        testResume.addContact(LINKEDIN, "https://www.linkedin.com/in/gkislin");
        testResume.addContact(GITHUB, "https://github.com/gkislin");
        testResume.addContact(STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        testResume.addContact(HOME_PAGE, "http://gkislin.ru/");
        testResume.addSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного " +
                "обучения по Java Web и Enterprise технологиям\n"));
        testResume.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, " +
                "креативность, инициативность. Пурист кода и архитектуры."));
        List<String> achievementList = new ArrayList<>();
        achievementList.add("С 2013 года: разработка проектов \"Разработка Web приложения\"" +
                ",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). " +
                "Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". " +
                "Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievementList.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievementList.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. " +
                "Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: " +
                "Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, " +
                "интеграция CIFS/SMB java сервера.");
        achievementList.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, " +
                "Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievementList.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов " +
                "(SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии " +
                "через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга " +
                "системы по JMX (Jython/ Django).");
        achievementList.add("Реализация протоколов по приему платежей всех основных платежных системы России " +
                "(Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        testResume.addSection(SectionType.ACHIEVEMENT, new ListSection(achievementList));
        List<String> qualificationList = new ArrayList<>();
        qualificationList.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualificationList.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualificationList.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        qualificationList.add("MySQL, SQLite, MS SQL, HSQLDB");
        qualificationList.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        qualificationList.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        qualificationList.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, " +
                "Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, " +
                "ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualificationList.add("Python: Django");
        qualificationList.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualificationList.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualificationList.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, " +
                "StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, " +
                "BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        qualificationList.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        qualificationList.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, " +
                "Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        qualificationList.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, " +
                "архитектурных шаблонов, UML, функционального программирования");
        qualificationList.add("Родной русский, английский \"upper intermediate\"");
        testResume.addSection(SectionType.QUALIFICATION, new ListSection(qualificationList));
        List<Organization> experienceList = new ArrayList<>();
        experienceList.add(
                new Organization("Java Online Projects", "http://javaops.ru/",
                        new Organization.Stage(LocalDate.of(2013, 10, 1),
                                LocalDate.of(2020, 4
                                        , 1),
                                "Автор проекта.",
                                "Создание, организация и проведение Java онлайн проектов и стажировок.")));
        experienceList.add(new Organization("Wrike", "https://www.wrike.com/"
                , new Organization.Stage(LocalDate.of(2014, 10, 1)
                , LocalDate.of(2016, 1, 1)
                , "Старший разработчик (backend)"
                , "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.")));
        experienceList.add(new Organization(
                "Wrike", "https://www.wrike.com/"
                , new Organization.Stage(LocalDate.of(2014, 10, 1)
                , LocalDate.of(2016, 1, 1)
                , "Старший разработчик (backend)"
                , "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.")));
        experienceList.add(new Organization(
                "RIT Center", null
                , new Organization.Stage(LocalDate.of(2012, 4, 1)
                , LocalDate.of(2014, 10, 1)
                , "Java архитектор"
                , "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python")));
        experienceList.add(new Organization(
                "Luxoft (Deutsche Bank)", "http://www.luxoft.ru/"
                , new Organization.Stage(LocalDate.of(2010, 12, 1)
                , LocalDate.of(2012, 4, 1)
                , "Ведущий программист"
                , "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.")));
        experienceList.add(new Organization(
                "Yota", "https://www.yota.ru/"
                , new Organization.Stage(LocalDate.of(2008, 6, 1)
                , LocalDate.of(2010, 1, 1)
                , "Ведущий специалист"
                , "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)")));
        experienceList.add(new Organization(
                "Enkata", "http://enkata.com/"
                , new Organization.Stage(LocalDate.of(2007, 3, 1)
                , LocalDate.of(2008, 6, 1)
                , "Разработчик ПО"
                , "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).")));
        experienceList.add(new Organization(
                "Siemens AG", "https://www.siemens.com/ru/ru/home.html"
                , new Organization.Stage(LocalDate.of(2005, 1, 1)
                , LocalDate.of(2007, 2, 1)
                , "Разработчик ПО"
                , "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).")));
        experienceList.add(new Organization(
                "Alcatel", "http://www.alcatel.ru/"
                , new Organization.Stage(LocalDate.of(1997, 9, 1)
                , LocalDate.of(2005, 1, 1)
                , "Инженер по аппаратному и программному тестированию"
                , "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).")));
        testResume.addSection(SectionType.EXPERIENCE, new OrganizationSection(experienceList));
        List<Organization> educationList = new ArrayList<>();
        educationList.add(new Organization("Coursera", "https://www.coursera.org/course/progfun"
                , new Organization.Stage(LocalDate.of(2013, 3, 1)
                , LocalDate.of(2013, 5, 1)
                , "Functional Programming Principles in Scala by Martin Odersky", null)));
        educationList.add(new Organization("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366"
                , new Organization.Stage(LocalDate.of(2011, 3, 1)
                , LocalDate.of(2011, 4, 1)
                , "Курс: Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML" +
                ".", null)));
        educationList.add(new Organization("Siemens AG", "http://www.siemens.ru/"
                , new Organization.Stage(LocalDate.of(2005, 1, 1)
                , LocalDate.of(2005, 4, 1)
                , "3 месяца обучения мобильным IN сетям (Берлин)", null)));
        educationList.add(new Organization("Alcatel", "http://www.alcatel.ru/"
                , new Organization.Stage(LocalDate.of(1997, 4, 1)
                , LocalDate.of(1998, 3, 1)
                , "6 месяцев обучения цифровым телефонным сетям (Москва)", null)));
        educationList.add(new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/"
                , new Organization.Stage(1993, Month.SEPTEMBER, 1996, Month.JULY, "Аспирантура (программист С, С++)", null)
                , new Organization.Stage(1987, Month.SEPTEMBER, 1993, Month.JULY, "Инженер (программист Fortran, C)", null)));
        educationList.add(new Organization("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/"
                , new Organization.Stage(LocalDate.of(1984, 9, 1)
                , LocalDate.of(1987, 6, 1)
                , "Закончил с отличием\n", null)));
        testResume.addSection(SectionType.EDUCATION, new OrganizationSection(educationList));
        return testResume;
    }
}