import java.sql.*;
import java.util.Scanner;
public class Insertbook {
   public static void insert() throws Exception {
	   String url = "jdbc:mysql://127.0.0.1:3306/bookmanagement";
	   String username ="root";
	   String password = "Hello@123";
	   String query = "insert into books values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	   Scanner scanner = new Scanner(System.in);
	   System.out.println("Enter book details:");
       System.out.print("Enter Book ID: ");
       int bookId = scanner.nextInt();
       scanner.nextLine();
       System.out.print("Enter Book Title: ");
       String bookTitle = scanner.nextLine();
       System.out.print("Enter Author: ");
       String author = scanner.nextLine();
       System.out.print("Enter ISBN: ");
       int isbn = scanner.nextInt();
       scanner.nextLine();
       System.out.print("Enter Publisher: ");
       String publisher = scanner.nextLine();
       System.out.print("Enter Publication Date (yyyy-mm-dd): ");
       String publicationDate = scanner.nextLine();
       System.out.print("Enter Number of Pages: ");
       int pages = scanner.nextInt();
       System.out.print("Enter Price: ");
       int price = scanner.nextInt();
       System.out.print("Enter Quantity: ");
       int quantity = scanner.nextInt();
       scanner.nextLine();
       System.out.print("Enter Language: ");
       String language = scanner.nextLine();
       System.out.print("Enter Edition: ");
       int edition = scanner.nextInt();
       System.out.print("Enter Weight: ");
       int weight = scanner.nextInt();
       scanner.nextLine();
       System.out.print("Enter Cover Image File Name: ");
       String coverImage = scanner.nextLine();

       Connection con = DriverManager.getConnection(url, username, password);
       PreparedStatement pst = con.prepareStatement(query);
           pst.setInt(1, bookId);
           pst.setString(2, bookTitle);
           pst.setString(3, author);
           pst.setInt(4, isbn);
           pst.setString(5, publisher);
           pst.setString(6, publicationDate);
           pst.setInt(7, pages);
           pst.setInt(8, price);
           pst.setInt(9, quantity);
           pst.setString(10, language);
           pst.setInt(11, edition);
           pst.setInt(12, weight);
           pst.setString(13, coverImage);

           pst.executeUpdate();
           con.close();

           System.out.println("Book inserted successfully!");
           scanner.close();
   }
	   
  
	
	public static void main(String[] args)throws Exception {
		insert();
	}
}