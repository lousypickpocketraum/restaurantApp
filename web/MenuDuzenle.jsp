<%--
  Created by IntelliJ IDEA.
  User: yasar
  Date: 25.12.2019
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form2" action="dbAdd" method="post">
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
                <th><input type="submit" name="gonder" value="Menüye Ekle" style="float:right"/></th>
            </tr>
        </table>
</form>
</body>
</html>