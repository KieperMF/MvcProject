<%-- 
    Document   : editcatalog
    Created on : 14 de jun. de 2023, 09:50:38
    Author     : mferreira
--%>

<%@page import="Models.CatalogModel"%>
<%@page import="Controllers.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product</title>
    </head>
    <body>
        <h1>Edit Product</h1>

        <%
            String id = request.getParameter("id");
            CatalogModel catalog = CatalogController.getCatalogById(Integer.parseInt(id));
        %>
        <form action="ServletCatalogUpdate" method="post">
            <input type="hidden" name="id" value="<%=catalog.getCatalogId()%>"/>
            <table>
                <tr>
                    <td>Nome do Produto: </td>
                    <td><input type="text" name="nome" value="<%=catalog.getProductName()%>"/>
                    <td>Preço Produto: </td>
                    <td><input type="number" name="price" value="<%=catalog.getProductPrice()%>"/>
                    <td>Descricao: </td>
                    <td><input type="text" name="desc" value="<%=catalog.getProductDescription()%>"/>         
                </tr>
                <tr>
                    <td><input type="submit"  value="Edit Product"/></input></td>
                </tr>
            </table>
        </form>
    </body>
</html>