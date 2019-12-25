<%--
  Created by IntelliJ IDEA.
  User: yasar
  Date: 18.12.2019
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

</head>
<body>
<form id="form1" action="dbAdd" method="post">
    <table>
        <table width="200" border="1">
            <tr>
                <th><label>Yemek Adı </label></th>
                <th><input type="text" name="yemekAdi" /></th>
            </tr>
            <tr>
                <th> <label>Yemek Ücreti</label></th>
                <th><input type="text" name="yemekUcreti" /></th>
            </tr>
            <tr>
                <th><input type="submit" name="gonder" value="Menüye Ekle"/></th>
            </tr>
        </table>
</form>
<form id="form2" action="dbUpdate" method="post">
    <table>
        <table width="200" border="1">
            <tr>
                <th><label>Güncellemek istediğiniz menü idsini giriniz</label></th>
                <th><input type="text" name="id" /></th>
            </tr>
            <tr>
                <th><label>Yeni Yemek Adı </label></th>
                <th><input type="text" name="yeniYemekAdi" /></th>
            </tr>
            <tr>
                <th> <label>Yeni Yemek Ücreti</label></th>
                <th><input type="text" name="yeniYemekUcreti" /></th>
            </tr>
            <tr>
                <th><input type="submit" name="gonder" value="Güncelle"/></th>
            </tr>
        </table>
</form>
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
	                    <form id="form3" action="dbDelete" method="post">
	                    	<input type="hidden" name="id" value="${item.id}" />
	                    	<input type="submit" name="gonder" value="Sil" />
	                    </form>
                    </td>
                </tr>
  </c:forEach>
</table>
</body>
</html>