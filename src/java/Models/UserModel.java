/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Pasta aonde está o Modelo
package Models;
/**
 * @author andre
 */
public class UserModel {
 //Atributos
 private int userId;
 private String userName;
 private String userEmail;
 //Contructor vazio
 public UserModel() {
 }
 //Contructor com parametros
 public UserModel(int id, String uN, String uE) {
 userId = id;
 userName = uN;
 userEmail = uE;
 }
 //Gets e Sets
 /**
 * @return the userId
 */
 public int getUserId() {
 return userId;
 }
 /**
 * @param userId the userId to set
 */
 public void setUserId(int userId) {
 this.userId = userId;
 }
 /**
 * @return the userName
 */
 public String getUserName() {
 return userName;
 }
 /**
 * @param userName the userName to set
 */
 public void setUserName(String userName) {
 this.userName = userName;
 }
 /**
 * @return the userEmail
 */
 public String getUserEmail() {
 return userEmail;
 }
 /**
 * @param userEmail the userEmail to set
 */
 public void setUserEmail(String userEmail) {
 this.userEmail = userEmail;
 }
}
