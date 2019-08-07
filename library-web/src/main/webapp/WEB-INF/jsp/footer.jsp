<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

</section>
<c:choose>
    <c:when test="${not empty slogan}">
        <footer>
                ${slogan}
        </footer>
    </c:when>
    <c:otherwise>
        <footer>
            Define slogan please!
        </footer>
    </c:otherwise>

</c:choose>
</body>
</html>
