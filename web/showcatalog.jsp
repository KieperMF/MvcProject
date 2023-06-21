<%-- 
    Document   : showcatalog.jsp
    Created on : 6 de jun. de 2023, 09:04:57
    Author     : mferreira
--%>

<%@page import="java.util.List"%>
<%@page import="Models.CatalogModel"%>
<%@page import="Controllers.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <h1>Produtos</h1>
        <%
            List<CatalogModel> catalogs = CatalogController.getAllcatalog();
            request.setAttribute("catalogs", catalogs);
        %>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
            </tr>
            <c:forEach items="${catalogs}" var="Catalog">
                <tr>
                    <td>${Catalog.getCatalogId()} </td>
                    <td>${Catalog.getProductName()} </td>
                    <td>${Catalog.getProductPrice()} </td>
                    <td>${Catalog.getProductDescription()}</td>
                    
                    <td class="acoes">
                        <a class="edit" href="editcatalog.jsp?id=${Catalog.getCatalogId()} ">EDIT</a>
                        <a class="delete" href="deletecatalog.jsp?id=${Catalog.getCatalogId()} ">DELETE</a>

                    </td>
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
