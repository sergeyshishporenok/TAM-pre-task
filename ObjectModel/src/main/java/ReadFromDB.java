import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface ReadFromDB {
    default Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "password");


        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    default void createDBIngredientTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE DB_INGREDIENTS("
                + "INGREDIENT_ID INT NOT NULL, "
                + "INGREDIENT_NAME VARCHAR(20) NOT NULL, "
                + "WEIGHT INT NOT NULL, "
                + "PRIMARY KEY (INGREDIENT_ID) "
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"DB_INGREDIENTS\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    default void addNewRecordInDBTable() {
        Connection dbConnection = null;
        Statement statement = null;

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();


            String insertTableSQL = "INSERT INTO DB_INGREDIENTS"
                    + "(INGREDIENT_ID, INGREDIENT_NAME, WEIGHT) " + "VALUES"
                    + "(2,'cucumber','30')";
            statement.execute(insertTableSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    default Map<Integer, Integer> getDataFromDBTable() {

        Connection dbConnection = null;
        Statement statement = null;
        String selectTableSQL = "SELECT INGREDIENT_ID, WEIGHT from DB_INGREDIENTS";
        Map<Integer, Integer> keysFromDB =  new HashMap<>();

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                int ingredient_id = Integer.parseInt(rs.getString("INGREDIENT_ID"));
                int weight = Integer.parseInt(rs.getString("WEIGHT"));

                System.out.println("Ingredient_ID : " + ingredient_id);
                System.out.println("weight : " + weight);

                keysFromDB.put(ingredient_id, weight);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return keysFromDB;
    }
}
