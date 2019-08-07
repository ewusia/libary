<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="book.add.error" var="BooksListTitle"/>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="${BooksListTitle}"/>
</jsp:include>


<table>

    <tr>
        <td>
            ${errorMessage}
        </td>
    </tr>

</table>
