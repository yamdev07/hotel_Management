/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.EntitiesManagers;

import static Models.EntitiesManagers.Manager.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author KOMLA-EBRI
 */
public class Manager {

    protected static Statement statement;
    public static Connection connection;
    protected static ResultSet resultSet;
    protected static PreparedStatement preparedStatement;

    public static void connect() {

        String url = "jdbc:mysql://localhost:3306/finalhotel";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DRIVER OK ");

            connection = (Connection) DriverManager.getConnection(url, user, password);

            System.out.println("la connection est effective");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }
    



public static void closeQuery() {
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

    }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
  
    }
    }
}














