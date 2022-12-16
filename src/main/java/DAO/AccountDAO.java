/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class AccountDAO {

    static AccountDAO instance;
    Account account = new Account();

    static Connection con = null;
    static PreparedStatement statement = null;

    private static void openConnection() {
        // TODO add your handling code here:
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
        } catch (SQLException e) {
        }
    }

    private static void closeConnection() {
        //B3. Dong ket noi
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClassesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClassesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        statement = null;
        con = null;
    }

    public AccountDAO() {
    }

    public static AccountDAO getInstance() {
        if (instance == null) {
            instance = new AccountDAO();
        }
        return instance;
    }

    public static void setInstance(AccountDAO instance) {
        AccountDAO.instance = instance;
    }

    public Boolean Login(String username, String password) {
        openConnection();
        String sql = "SELECT * FROM account WHERE username =? AND password = ?";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                account.setId(resultSet.getInt(1));
                account.setUsername(resultSet.getString(2));
                account.setPassword(resultSet.getString(3));
                account.setName(resultSet.getString(4));
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        closeConnection();

        return false;

    }

    public Account GetAccount() {
        return account;
    }

    public boolean listAccount() {
        List<Account> listData = new ArrayList<>();
        openConnection();
        String sql = "SELECT id, username, password, name FROM account";

        try {
            statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Account account = new Account(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                listData.add(account);
            }
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        closeConnection();
        return false;

    }

    public boolean Add(String name, String username, String password) {
        openConnection();
        String sql = "INSERT INTO account(username,password,name) VALUES(?,?,?)";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, name);
            int i = statement.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        closeConnection();
        return false;
    }

    public boolean Update(int id, String name, String password) {
        openConnection();
        String sql = "UPDATE account SET password=?, name=? WHERE ID =?";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(2, password);
            statement.setString(3, name);
            statement.setInt(3, id);
            int i = statement.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        closeConnection();
        return false;
    }

    public Boolean Delete(int id) {
        openConnection();
        String sql = "DELETE FROM account WHERE ID = ?";
        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            int i = statement.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        closeConnection();
        return false;
    }

    public Boolean changePass(int id, String password) {
        openConnection();
        String sql = "UPDATE account SET password=? WHERE ID = ?";
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, password);
            statement.setInt(2, id);
            int i = statement.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        closeConnection();
        return false;
    }
}
