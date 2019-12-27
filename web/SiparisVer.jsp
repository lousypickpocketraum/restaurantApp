<%--
  Created by IntelliJ IDEA.
  User: yasar
  Date: 26.12.2019
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>
<table border="1" width="200">
    <tr>
        <th>Id</th>
        <th>Yemek adı</th>
        <th>Yemek ücreti</th>
    </tr>
    <c:forEach var="item" items="${items}">
        <tr>
            <td><c:out value="${item.id}" /></td>
            <td><c:out value="${item.yemekAdi}" /></td>
            <td><c:out value="${item.yemekUcreti}" />₺</td>
            <td>
                <form id="form3" action="siparisVer" method="post">
                    <input type="hidden" name="id" value="${item.id}" />
                    <input type="submit" name="gonder" value="+" />
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
