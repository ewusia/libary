<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="book.add" var="BooksListTitle"/>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="${BooksListTitle}"/>
</jsp:include>

<form:form method="post" action="add" modelAttribute="bookForm">
<table>

    <tr>
        <td>
            Title: <form:input path="title"/>
            <br>
            <form:errors path="title"/>
        </td>
    </tr>
    <tr>
        <td>
            Author: <form:input path="author"/>
        </td>
    </tr>
    <tr>
        <td>
            Price: <form:input type="number" path="price"/>
            <br>
            <form:errors path="price"/>
        </td>
    </tr>
    <tr>
        <td>
            Cover: <form:input path="cover"/>
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Save"/>
        </td>
    </tr>

</table>
</form:form>
<jsp:include page="footer.jsp"/>