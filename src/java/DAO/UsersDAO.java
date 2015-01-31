/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.SQLException;
import java.util.List;

import toothfairy1.Models.Users;

/**
 *
 * @author valya
 */
public interface UsersDAO {   
    public void addUser(Users user) throws SQLException;   //добавить студента
    public void updateUser(Users user) throws SQLException;//обновить студента
    public Users getUserById(Long id) throws SQLException;    //получить стедента по id
    public List getAllUsers() throws SQLException;              //получить всех студентов
    public void deleteUser(Users user) throws SQLException;//удалить студента
} 

