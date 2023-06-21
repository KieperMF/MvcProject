/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Controllers.CatalogController;
import Models.CatalogModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andre
 */
@WebServlet(name = "ServletCatalogCreate", urlPatterns = {"/ServletCatalogCreate"})
public class ServletCatalogCreate extends HttpServlet {

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
        
        String nome = request.getParameter("nome");
        int price = Integer.parseInt(request.getParameter("price"));
        String desc = request.getParameter("desc");
        
        // Crie um objeto UserModel com os dados recebidos
        CatalogModel catalog = new CatalogModel();
        catalog.setProductName(nome);
        catalog.setProductPrice(price);
        catalog.setProductDescription(desc);
        // Chame o método no UserController para salvar o usuário no banco de dados
        CatalogController.CreateCatalog(catalog);
        // Redirecione para uma página de sucesso ou exiba uma mensagem de sucesso
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
