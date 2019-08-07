<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Counter</title>
</head>
<body>
// ustalanie stanu counta, sesji, nie jest wyswietlana
<%
    int count = 0;

/*    if (session.getAttribute("count") != null) {
        count = (int)session.getAttribute("count");
    }
    session.setAttribute("count", ++count);*/
%>

<%--
    This site has been visited <%=count%> times.
--%>
    This site has been visited <%=session.getAttribute("count")%> times.

</body>
</html>
