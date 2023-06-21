//Pasta dos controllers
package Controllers;

/**
 *
 * @author andre
 */
//Pacotes necessarios para usar o banco e outras funções
import Models.UserModel;
import java.util.List;
import Connections.ConnectionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {
//Função para mostrar todos os Usuarios cadastrados no banco

    public static List<UserModel> getAllUsers() {
        //Criar a conexão
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Uma interface utilizada pra guardar dados vindos de um banco de dados.
        ResultSet rS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "select * from Users";
        //Lista para guardar os usuarios do banco
        List userList = new ArrayList();
        try {
            //Pegar conexao com o banco
            con = connection.connection();
            pS = con.prepareStatement(sql);
            rS = pS.executeQuery();
            //para percorrer o resultset
            while (rS.next()) {
                //Atributos do banco, rS.getInt("id_user"), pega o resultado do banco e transforma em inteiro;
                //O que está dentro do get.Int("NOME DO ATRIBUTO NO BANCO") Tem que ser igual o nome que está no banco de dados.
                int id = rS.getInt("id_user");
                String name = rS.getString("name_user");
                String email = rS.getString("email_user");
                //Criando um novo usuario a partir dos valores no banco
                UserModel user = new UserModel(id, name, email);
                //Adicionando na nossa lista de usuarios
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return userList;
    }

    public static UserModel getUserById(int id) {
        UserModel user = null;
        //Criar a conexão
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Uma interface utilizada pra guardar dados vindos de um banco de dados.
        ResultSet rS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "SELECT * FROM Users WHERE id_user=" + id;
        //Lista para guardar os usuarios do banco
        try {
            //Pegar conexao com o banco
            con = connection.connection();
            pS = con.prepareStatement(sql);
            rS = pS.executeQuery();
            //para percorrer o resultset
            while (rS.next()) {
                //Atributos do banco, rS.getInt("id_user"), pega o resultado do banco e transforma em inteiro;
                //O que está dentro do get.Int("NOME DO ATRIBUTO NO BANCO") Tem que ser igual o nome que está no banco de dados.
                String name = rS.getString("name_user");
                String email = rS.getString("email_user");
                //Criando um novo usuario a partir dos valores no banco
                user = new UserModel(id, name, email);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return user;
    }

    public static int updateUser(UserModel user) {
        int status = 0;
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "UPDATE Users SET name_user =?, email_user=? WHERE id_user=?";
        try {
            //Pegar conexao com o banco
            con = connection.connection();
            pS = con.prepareStatement(sql);
            //para alterar o nome o 1 é o primeiro "?", o 2 é o segundo "?" e o 3 é o terceiro "?"
            pS.setString(1, user.getUserName());
            pS.setString(2, user.getUserEmail());
            pS.setInt(3, user.getUserId());
            status = pS.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return status;
    }

    public static int createUser(UserModel user) {
        int status = 0;
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "INSERT INTO Users (name_user,email_user) VALUES (?,?)";
        try {
            //Pegar conexao com o banco
            con = connection.connection();
            pS = con.prepareStatement(sql);
            //para alterar o nome
            pS.setString(1, user.getUserName());
            pS.setString(2, user.getUserEmail());
            status = pS.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return status;
    }

    public static int deleteUser(int id) {
        int status = 0;
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "DELETE FROM Users WHERE id_user=" + id;
        try {
            //Pegar conexao com o banco
            con = connection.connection();
            pS = con.prepareStatement(sql);
            //para alterar o nome
            status = pS.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return status;
    }
}
