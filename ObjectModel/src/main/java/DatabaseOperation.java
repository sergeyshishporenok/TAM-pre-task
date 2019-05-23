import java.sql.SQLException;

public class DatabaseOperation implements ReadWrite {
    public static void main(String [] args) throws SQLException {
        DatabaseOperation cls = new DatabaseOperation();
        //create table
        cls.createDBIngredientTable();
        //add record
        cls.addNewRecordInDBTable();
        //get info from table
        cls.getDataFromDBTable();

    }
}
