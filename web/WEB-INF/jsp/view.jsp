<%@ page import="com.github.akorelyakov.webapp.model.Resume" %>
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
    <!--Здесь нужно просто прописать код, чтобы красиво выводить резюме -->
    <h2>Контактная информация</h2>
    <ul>
        <jsp:useBean id="contactList" type="com.github.akorelyakov.webapp.model.ContactType" scope="request"/>
        <c:forEach items="${resume.getContacts}" var="contact">
            <jsp:useBean id="resume" type="com.github.akorelyakov.webapp.model.Resume"/>
            <li></li>
                    ${resume.fullName}
        </c:forEach>
    </ul>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
