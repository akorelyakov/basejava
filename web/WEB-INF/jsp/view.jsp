<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Просмотр резюме</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <jsp:useBean id="resume" type="com.github.akorelyakov.webapp.model.Resume" scope="request"/>
    <h1>${resume.fullName}</h1>
    <h2>Контактная информация</h2>
    <ul>
        <c:forEach items="${resume.contacts}" var="contact">
            <li>${contact.key}: ${contact.value}</li>
        </c:forEach>
    </ul>
    <c:forEach items="${resume.sections}" var="section">
        <h2>${section.key.title}</h2>
        <c:set var="sectionType" value="${section.key}"/>
        <c:choose>
            <c:when test="${section.key == 'PERSONAL' or section.key == 'OBJECTIVE'}">
                ${section.value}
            </c:when>
            <c:when test="${section.key == 'ACHIEVEMENT' or section.key == 'QUALIFICATION'}">
                <c:forEach items="${section.value.items}" var="listItem">
                    <li>${listItem}</li>
                </c:forEach>
            </c:when>
            <c:when test="${section.key == 'EXPERIENCE' or section.key == 'EDUCATION'}">
                <c:forEach items="${section.value.organizations}" var="organization">
                    <h3><a href="${organization.homePage.url}">${organization.homePage.name}</a></h3>
                    <c:forEach items="${organization.positions}" var="position">
                        <p><strong>${position.startDate} - ${position.endDate}</strong></p>
                        <h4>${position.title}</h4>
                        <p>${position.description}</p>
                    </c:forEach>
                </c:forEach>
            </c:when>
        </c:choose>
    </c:forEach>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
