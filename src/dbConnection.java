import java.sql.*;
import java.util.Scanner;

public class dbConnection {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String yemekAdiEkle;
        int yemekUcretiEkle;

        // Enter username and press Enter
        System.out.println("yemek adi giriniz:");
        yemekAdiEkle = myObj.nextLine();
        System.out.println("yemek ücretini giriniz:");
        yemekUcretiEkle = myObj.nextInt();

        try {
            String host = "jdbc:mysql://localhost:3306/restraurant?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            String userName = "root";
            String userPass = "1234";
            Connection con = DriverManager.getConnection(host, userName, userPass);
            Statement stat = con.createStatement();
            String add = "INSERT INTO menu(yemekadi , yemekucreti)"
                    + "VALUES (" + "'" + yemekAdiEkle + "'" +"," + yemekUcretiEkle + ")";
            try{
                stat.executeUpdate(add);
                System.out.println("veriler eklendi");
            }catch (Exception e){
                System.out.println(e);
            }

            String sql = "select * from menu";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                int id_col = rs.getInt("id");
                String yemek_adi = rs.getString("yemekadi");
                String yemek_ucreti = rs.getString("yemekucreti");

                String p = id_col + " " + yemek_adi + " " + yemek_ucreti + "₺ " ;
                System.out.println(p);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }
}
