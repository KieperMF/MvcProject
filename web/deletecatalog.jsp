<%-- 
    Document   : deletecatalog
    Created on : 19 de jun. de 2023, 07:44:13
    Author     : mferreira
--%>

<%@page import="Models.CatalogModel"%>
<%@page import="Controllers.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deletar produto</title>
    </head>
    <body>
        <h1>Delete Products</h1>

        <%
            String id = request.getParameter("id");
            CatalogModel catalog = CatalogController.getCatalogById(Integer.parseInt(id));
        %>
        <form action="ServletCatalogDelete" method="get">
        <input type="hidden" name="id" value="<%=catalog.getCatalogId()%>"/>
                <table>
                    <tr>
                        <td><input type="submit"  value="Confirmar Delete Product?"/></input></td>                
                    </tr>
                </table>
        </form>
    </body>
</html>
