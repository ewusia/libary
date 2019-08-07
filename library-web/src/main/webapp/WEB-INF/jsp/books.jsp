<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="books.list" var="BooksListTitle"/>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="${BooksListTitle}"/>
</jsp:include>

<table>
    <tr>
        <th><spring:message code="book.title"/></th>
        <th><spring:message code="book.author"/></th>
        <th><spring:message code="book.price"/></th>
        <th><spring:message code="book.cover"/></th>
        <th><spring:message code="book.details"/></th>
    </tr>

        <c:forEach items="${books}" var="b">
    <tr>
        <td>${b.title}</td>
        <td>${b.author}</td>
        <td>${b.price}</td>
        <td><img src="${b.cover}"/></td>
        <td>
            <c:if test="${not empty b.view}">
            <a href="${b.view}">details</a></td>
        </c:if>
        </c:forEach>
    </tr>

    <tr>
        <td colspan="5">
            <a href="<c:url value="/books/add?publisherId=${publisherId}"/>">+</a>
        </td>
    </tr>

</table>