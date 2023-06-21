<%-- 
    Document   : createcatalog.jsp
    Created on : 6 de jun. de 2023, 09:02:03
    Author     : mferreira
--%>

<%@page import="Models.CatalogModel"%>
<%@page import="Controllers.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; 
              charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Adicionar Produto</h1>
        <form action="ServletCatalogCreate" method="post">
            <table>
                <tr>
                    <td>Nome: </td>
                    <td><input type="text" name="nome"/>
                </tr>
                <tr>
                    <td>Valor </td>
                    <td><input type="number" name="price"/>
                </tr>
                <tr>
                    <td>Descricao </td>
                    <td><input type="text" name="desc"/>
                </tr>
                <tr>
                    <td><input type="submit" value="ADD Catalog"/></input></td>
                </tr>
            </table>
        </form>
    </body>
</html>
