package util;

import pagesUrls.PagesUrls;

import java.sql.*;

public class DbUtil {
    // переменные для подключения к тестовой БД
    private static final String url = "jdbc:postgresql://" + PagesUrls.base + ":5432/XXX";
    private static final String user = "XXX";
    private static final String password = "XXX";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     * @throws java.sql.SQLException
     */
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // получение текста последнего отзыва на офер
    public static String getLastCommentText() {
        String SQL = "SELECT text " +
                "FROM public.microfinance_review " +
                "ORDER BY id DESC " +
                "LIMIT 1";
        String selectedField = "";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                //Retrieve by column name
                selectedField = rs.getString("text");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return selectedField;
    }
}