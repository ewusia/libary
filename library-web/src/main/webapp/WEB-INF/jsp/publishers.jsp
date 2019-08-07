<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="publishers.list" var="publishersListTitle"/>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="${publishersListTitle}"/>
</jsp:include>

    <table>
        <tr>
            <th><spring:message code="publisher.name"/></th>
            <th><spring:message code="publisher.logo"/></th>
        </tr>
            <c:forEach items="${publishers}" var="p">
        <tr>
        <td><a href="./books?publisherId=${p.id}">${p.name}</a></td>
            <td><img src="${p.logoImage}"></td>

            </c:forEach>

        </tr>
    </table>

<jsp:include page="footer.jsp"/>