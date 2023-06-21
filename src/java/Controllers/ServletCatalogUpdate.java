/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Controllers.CatalogController;
import Models.CatalogModel;
import java.io.IOException;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andre
 */
@WebServlet(name = "ServletCatalogUpdate", urlPatterns = {"/ServletCatalogUpdate"})
public class ServletCatalogUpdate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CatalogController catalogc = new CatalogController();

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        int price = Integer.parseInt(request.getParameter("price"));
        String desc = request.getParameter("desc");
        // Obtenha o usuário existente do banco de dados com base no ID
        CatalogModel catalog = catalogc.getCatalogById(id);
        // Atualize os detalhes do usuário
        catalog.setProductName(nome);
        catalog.setProductPrice(price);
        catalog.setProductDescription(desc);
        
        // Chame o método no UserController para salvar as alterações no banco de dados
        catalogc.updateCatalog(catalog);
        // Redirecione para uma página de sucesso ou exiba uma mensagem de sucesso
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
