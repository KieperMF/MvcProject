//Pasta dos controllers
package Controllers;

/**
 *
 * @author andre
 */
//Pacotes necessarios para usar o banco e outras funções
import Models.CatalogModel;
import java.util.List;
import Connections.ConnectionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CatalogController {
//Função para mostrar todos os Usuarios cadastrados no banco

    public static List<CatalogModel> getAllcatalog() {
        //Criar a conexão
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Uma interface utilizada pra guardar dados vindos de um banco de dados.
        ResultSet rS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "select * from Catalog";
        //Lista para guardar os usuarios do banco
        List catalogList = new ArrayList();
        try {
            //Pegar conexao com o banco
            con = connection.connection();
            pS = con.prepareStatement(sql);
            rS = pS.executeQuery();
            //para percorrer o resultset
            while (rS.next()) {
                //Atributos do banco, rS.getInt("id_user"), pega o resultado do banco e transforma em inteiro;
                //O que está dentro do get.Int("NOME DO ATRIBUTO NO BANCO") Tem que ser igual o nome que está no banco de dados.
                int id = rS.getInt("id_product");
                
                String name = rS.getString("name_product");
                
                int price = rS.getInt("price_product");

                String desc = rS.getString("description_product");
                //Criando um novo usuario a partir dos valores no banco
                CatalogModel catalog = new CatalogModel(id, name, price, desc);
                //Adicionando na nossa lista de usuarios
                catalogList.add(catalog);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return catalogList;
    }

    public static CatalogModel getCatalogById(int id) {
        CatalogModel catalog = null;
        //Criar a conexão
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Uma interface utilizada pra guardar dados vindos de um banco de dados.
        ResultSet rS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "SELECT * FROM Catalog WHERE id_product=" + id;
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
                String name = rS.getString("name_product");
                
                int price = rS.getInt("price_product");

                String desc = rS.getString("description_product");
                //Criando um novo usuario a partir dos valores no banco
                catalog = new CatalogModel(id,name, price, desc);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return catalog;
    }

    public static int updateCatalog(CatalogModel catalog) {
        int status = 0;
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "UPDATE Catalog SET name_product =?, price_product=? ,description_product=? WHERE id_product=?";
        try {
            //Pegar conexao com o banco
            con = connection.connection();
            pS = con.prepareStatement(sql);
            //para alterar o nome o 1 é o primeiro "?", o 2 é o segundo "?" e o 3 é o terceiro "?"
            pS.setString(1, catalog.getProductName());
            pS.setInt(2, catalog.getProductPrice());
            pS.setString(3, catalog.getProductDescription());
            pS.setInt(4, catalog.getCatalogId());
            status = pS.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return status;
    }

    public static int CreateCatalog(CatalogModel catalog) {
        int status = 0;
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "INSERT INTO Catalog (name_product, price_product ,description_product) VALUES (?,?,?)";
        try {
            //Pegar conexao com o banco
            con = connection.connection();
            pS = con.prepareStatement(sql);
            //para alterar o nome
            pS.setString(1, catalog.getProductName());
            pS.setInt(2, catalog.getProductPrice());
            pS.setString(3, catalog.getProductDescription());
            status = pS.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            connection.TurnOffConnection(con);
        }
        //Retorna a lista com todos os usuarios do banco
        return status;
    }

    public static int deleteCatalog(int id) {
        int status = 0;
        Connection con = null;
        ConnectionSQL connection = new ConnectionSQL();
        //Uma forma de você fazer uma inserção no banco mais segura, onde você prepara os parametros para serem inseridos.
        PreparedStatement pS;
        //Comando sql para selecionar todos os usuarios do banco
        String sql = "DELETE FROM Catalog WHERE id_product=" + id;
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
