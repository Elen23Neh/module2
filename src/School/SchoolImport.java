package School;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SchoolImport {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver");
        createTable();
        //importFromCsvToSql();

        //Scanner scanner = new Scanner(System.in);
        //while (true) {
        //    System.out.println("Chose class name:");
        //    String res = scanner.nextLine();

        //}

    }

    public static void importFromCsvToSql() throws IOException {
        BufferedReader bReader = new BufferedReader(new FileReader("../School.csv"));
        String[] values;
        while ((values = readCsv(bReader)) != null) {
            insertValues(values);
        }
    }

    public static ClassInfo getClassInfo(String className) {
        String sql = String.format("SELECT * FROM School WHERE Name='%s'", className);
        //todo: execute sql

        return new ClassInfo();
    }

    public static void createTable() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://127.0.0.1:3306/schooldb";
        Connection con = DriverManager.getConnection(url, "root", "Sql235");
        Statement st = con.createStatement();
        String sql = "CREATE TABLE School(Name text, Count number, Teacher text)";
        st.executeUpdate(sql);
    }

    public static void insertValues(String[] values) {
        String sqlValue = String.join(",", values);
        String sql = String.format("INSERT INTO School(Name,Count,Teacher) VALUES(%s)", sqlValue);
        //todo: execute sql
    }

    public static String[] readCsv(BufferedReader file) throws IOException {
        String values = file.readLine();
        if (values == null)
            return null;

        return values.split(";");
    }
}

class ClassInfo {
    public String name;
    public int count;
    public String teacher;
}
