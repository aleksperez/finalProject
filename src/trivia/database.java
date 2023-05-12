package trivia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class database {
    static ObservableList<player> list;
    static String url = "jdbc:mysql://localhost:3306/Trivia";
    static String uname = "root";
    static String password= "";

    public static void addPlayer(String name, int points) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection(url, uname, password);
            PreparedStatement pStat = null;
            pStat = conn.prepareStatement("INSERT INTO `players`(player_name,points) VALUES(?,?)");
            pStat.setString(1, name);
            pStat.setInt(2, points);
            pStat.executeUpdate();
        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }

    public static ObservableList<player> findAllPlayers() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection conn = DriverManager.getConnection(url, uname, password);
            list = FXCollections.observableArrayList();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM players");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new player(rs.getString("player_name"), rs.getInt("points")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
