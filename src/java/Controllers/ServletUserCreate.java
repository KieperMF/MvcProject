/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.UserModel;
import Controllers.UserController;
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
@WebServlet(name = "ServletUserCreate", urlPatterns = {"/ServletUserCreate"})
public class ServletUserCreate extends HttpServlet {

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
        UserController userc = new UserController();
        String nome = request.getParameter("nome");
        String email = request.getParameter("Email");
        // Crie um objeto UserModel com os dados recebidos
        UserModel user = new UserModel();
        user.setUserName(nome);
        user.setUserEmail(email);
        // Chame o método no UserController para salvar o usuário no banco de dados
        UserController.createUser(user);
        // Redirecione para uma página de sucesso ou exiba uma mensagem de sucesso
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
