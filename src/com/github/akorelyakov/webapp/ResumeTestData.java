package com.github.akorelyakov.webapp;

import com.github.akorelyakov.webapp.model.*;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import static com.github.akorelyakov.webapp.model.ContactType.*;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume testResume = fillResumeTestData();
        System.out.println(testResume.toString());
    }

    public static Resume fillResumeTestData() {
        Resume gKislinResume = new Resume("Григорий Кислин");
        gKislinResume.addContact(PHONE, "+7(921) 855-0482");
        gKislinResume.addContact(SKYPE, "grigory.kislin");
        gKislinResume.addContact(MAIL, "mailto:gkislin@yandex.ru");
        gKislinResume.addContact(LINKEDIN, "https://www.linkedin.com/in/gkislin");
        gKislinResume.addContact(GITHUB, "https://github.com/gkislin");
        gKislinResume.addContact(STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        gKislinResume.addContact(HOME_PAGE, "http://gkislin.ru/");

        gKislinResume.addSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного " +
                "обучения по Java Web и Enterprise технологиям\n"));
        gKislinResume.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, " +
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
        gKislinResume.addSection(SectionType.ACHIEVEMENT, new ListSection(achievementList));

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
        gKislinResume.addSection(SectionType.QUALIFICATION, new ListSection(qualificationList));

/*        List<Organization> experienceList = new ArrayList<>();
        experienceList.add(new Organization(
                new Link("Java Online Projects", "http://javaops.ru/")
                , "Автор проекта.", YearMonth.of(2013, 10), null
                , "Создание, организация и " +
                "проведение Java онлайн " +
                "проектов и стажировок."));
        experienceList.add(new Organization(
                new Link("Wrike", "https://www.wrike.com/"), "Старший разработчик (backend)"
                , YearMonth.of(2013, 10), YearMonth.of(2013, 10), "Проектирование и разработка " +
                "онлайн платформы управления" +
                " проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));
        experienceList.add(new Organization(
                new Link("RIT Center", null), "Java архитектор"
                , YearMonth.of(2012, 4), YearMonth.of(2014, 10)
                , "Организация процесса разработки системы ERP для разных окружений: релизная политика, " +
                "версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы " +
                "(pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных " +
                "сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). " +
                "Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin " +
                "development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, " +
                "Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"));
        experienceList.add(new Organization(
                new Link("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/")
                , "Ведущий программист", YearMonth.of(2010, 12), YearMonth.of(2012, 4)
                , "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, " +
                "SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. " +
                "Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. " +
                "JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."));
        experienceList.add(new Organization(
                new Link("Yota", "https://www.yota.ru/"), "Ведущий специалист"
                , YearMonth.of(2008, 6), YearMonth.of(2010, 12)
                , "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" " +
                "(GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                "Реализация администрирования, статистики и мониторинга фреймворка. " +
                "Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"));
        experienceList.add(new Organization(
                new Link("Enkata", "http://enkata.com/"), "Разработчик ПО"
                , YearMonth.of(2007, 3), YearMonth.of(2008, 6)
                , "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, " +
                "Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."));
        experienceList.add(new Organization(
                new Link("Siemens AG", "https://www.siemens.com/ru/ru/home.html")
                , "Разработчик ПО"
                , YearMonth.of(2005, 1), YearMonth.of(2007, 2)
                , "Разработка информационной модели, проектирование интерфейсов, " +
                "реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)" +
                "."));
        experienceList.add(new Organization(
                new Link("Alcatel", "http://www.alcatel.ru/"), "Инженер по аппаратному и программному тестированию"
                , YearMonth.of(1997, 9), YearMonth.of(2005, 1)
                , "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));
        gKislinResume.addSection(SectionType.EXPERIENCE, new OrganizationSection(experienceList));

        List<Organization> educationList = new ArrayList<>();
        educationList.add(new Organization(new Link("Coursera", "https://www.coursera" +
                ".org/course/progfun"), "Functional Programming Principles in Scala by Martin " +
                "Odersky", YearMonth.of(2013, 3), YearMonth.of(2013, 5)
                , null));
        educationList.add(new Organization(new Link("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366")
                , "Курс: Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML."
                , YearMonth.of(2011, 3), YearMonth.of(2011, 4), null));
        educationList.add(new Organization(new Link("Siemens AG", "http://www.siemens.ru/")
                , "3 месяца обучения мобильным IN сетям (Берлин)"
                , YearMonth.of(2005, 1), YearMonth.of(2005, 4), null));
        educationList.add(new Organization(new Link("Alcatel", "http://www.alcatel.ru/")
                , "6 месяцев обучения цифровым телефонным сетям (Москва)"
                , YearMonth.of(1997, 9), YearMonth.of(1998, 3), null));
        educationList.add(new Organization(new Link("Санкт-Петербургский национальный исследовательский " +
                "университет информационных технологий, механики и оптики", "http://www.ifmo.ru/")
                , "Аспирантура (программист С, С++)"
                , YearMonth.of(1993, 9), YearMonth.of(1996, 7), null));
        educationList.add(new Organization(new Link("Санкт-Петербургский национальный исследовательский " +
                "университет информационных технологий, механики и оптики", "http://www.ifmo.ru/")
                , "Инженер (программист Fortran, C)"
                , YearMonth.of(1987, 9), YearMonth.of(1993, 7), null));
        educationList.add(new Organization(new Link("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/")
                , "Закончил с отличием"
                , YearMonth.of(1984, 9), YearMonth.of(1987, 6), null));
        gKislinResume.addSection(SectionType.EDUCATION, new OrganizationSection(educationList));*/
        return gKislinResume;
    }
}