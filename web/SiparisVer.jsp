<%--
  Created by IntelliJ IDEA.
  User: yasar
  Date: 28.12.2019
  Time: 02:09
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
        <th>Yemek adı</th>
        <th>Yemek ücreti</th>
    </tr>
<c:forEach var="item2" items="${items}">
    <tr>
        <td><c:out value="${item2.siparisYemekAdi}" /></td>
        <td><c:out value="${item2.siparisYemekUcreti}" />₺</td>
        <td>
            <form id="form4" action="siparisEkle" method="post">
                <input type="hidden" name="siparisYemek" value="${item2.siparisYemekAdi}" />
                <input type="hidden" name="siparisYemekUcreti" value="${item2.siparisYemekUcreti}" />
                <input type="text" name="siparisAdet" value="1" style="width: 80%;" />
                <input type="submit" name="gonder" value="+" />
            </form>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>
