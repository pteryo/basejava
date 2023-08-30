<%@ page import="com.learnjava.Config" %>
<%@ page import="com.learnjava.model.*" %>
<%@ page import="com.learnjava.util.DateUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:useBean id="resume" type="com.learnjava.model.Resume" scope="request"/>
    <title>Резюме ${resume.fullName}</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <form method="post" action="resume" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <dl>
            <dt>Имя:</dt>
            <dd>
                <input type="text" required name="fullName" size=50 value="${resume.fullName}"></dd>
        </dl>
        <h3>Контакты:</h3>
        <c:forEach var="type" items="<%=ContactType.values()%>">
            <dl>
                <dt>${type.title}</dt>
                <dd><input type="text" name="${type.name()}" size=30 value="${resume.getContact(type)}"></dd>
            </dl>
        </c:forEach>

        <hr>
        <table cellpadding="2">
            <c:forEach var="sectionEntry" items="${resume.sections}">
            <jsp:useBean id="sectionEntry"
                         type="java.util.Map.Entry<com.learnjava.model.SectionType, com.learnjava.model.Section>"/>
            <c:set var="type" value="${sectionEntry.key}"/>
            <c:if test="(ListSection) sectionEntry.getValue() == null"><<
            <continue>>></c:if>
                <h2><a>${type.title}</a></h2>
                <c:choose>
                <c:when test="${type=='OBJECTIVE'}">
                <input type='text' name='${type}' size=75 value='<%=sectionEntry.getValue().toString()%>'>
                </c:when>
                <c:when test="${type=='PERSONAL'}">
                <textarea name='${type}' cols=75 rows=5><%=sectionEntry.getValue().toString()%></textarea>
                </c:when>
                <c:when test="${type=='QUALIFICATIONS' || type=='ACHIEVEMENT'}">
                <textarea name='${type}' cols=75
                          rows=5><%=String.join("\n", ((ListSection) sectionEntry.getValue()).getItems())%></textarea>
                </c:when>
                <c:when test="${type=='EXPERIENCE' || type=='EDUCATION'}">
                <c:forEach var="org" items="<%=((OrganizationSection) sectionEntry.getValue()).getOrganizations()%>"
                           varStatus="counter">
                <dl>
                    <dt>Название учереждения:</dt>
                    <dd><input type="text" name='${type}' size=100 value="${org.homePage.name}"></dd>
                </dl>
                <dl>
                    <dt>Сайт учереждения:</dt>
                    <dd><input type="text" name='${type}url' size=100 value="${org.homePage.url}"></dd>

                </dl>
                <br>
                <div style="margin-left: 30px">
                    <c:forEach var="pos" items="${org.periods}">
                        <jsp:useBean id="pos" type="com.learnjava.model.Period"/>
                        <dl>
                            <dt>Начальная дата:</dt>
                            <dd>
                                <input type="text" name="${type}${counter.index}startDate" size=10
                                       value="<%=DateUtil.format(pos.getStartDate())%>" placeholder="MM/yyyy">
                            </dd>
                        </dl>
                        <dl>
                            <dt>Конечная дата:</dt>
                            <dd>
                                <input type="text" name="${type}${counter.index}endDate" size=10
                                       value="<%=DateUtil.format(pos.getEndDate())%>" placeholder="MM/yyyy">
                        </dl>
                        <dl>
                            <dt>Должность:</dt>
                            <dd><input type="text" name='${type}${counter.index}title' size=75 value="${pos.title}">
                        </dl>
                        <dl>
                            <dt>Описание:</dt>
                            <dd><textarea name="${type}${counter.index}description" rows=5
                                          cols=75>${pos.description}</textarea></dd>
                        </dl>
                    </c:forEach>
                </div>
                </c:forEach>
                </c:when>

                </c:choose>
                </c:forEach>
        </table>
        <hr>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Отменить</button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>