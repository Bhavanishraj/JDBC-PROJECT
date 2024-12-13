import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Deletebook {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "Hello@123";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/bookmanagement";
    
    
    public static void deleteBookById() {
        try (Scanner sc = new Scanner(System.in); 
             Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            System.out.print("Enter the Book ID to delete: ");
            int bookId = sc.nextInt();
            String query = "DELETE FROM books WHERE book_id = ?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, bookId);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Book with ID " + bookId + " deleted successfully.");
                } else {
                    System.out.println("No book found with ID " + bookId + ". Nothing was deleted.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during deletion: " + e.getMessage());
        }
    }

    // Delete Genre by ID
    public static void deleteGenreById() {
        try (Scanner sc = new Scanner(System.in); 
             Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            System.out.print("Enter the Genre ID to delete: ");
            int genreId = sc.nextInt();
            String query = "DELETE FROM genres WHERE genre_id = ?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, genreId);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Genre with ID " + genreId + " deleted successfully.");
                } else {
                    System.out.println("No genre found with ID " + genreId + ". Nothing was deleted.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during deletion: " + e.getMessage());
        }
    }

    // Delete Author by ID
    public static void deleteAuthorById() {
        try (Scanner sc = new Scanner(System.in); 
             Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            System.out.print("Enter the Author ID to delete: ");
            int authorId = sc.nextInt();
            String query = "DELETE FROM authors WHERE author_id = ?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, authorId);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Author with ID " + authorId + " deleted successfully.");
                } else {
                    System.out.println("No author found with ID " + authorId + ". Nothing was deleted.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during deletion: " + e.getMessage());
        }
    }

    // Delete Publisher by ID
    public static void deletePublisherById() {
        try (Scanner sc = new Scanner(System.in); 
             Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            System.out.print("Enter the Publisher ID to delete: ");
            int publisherId = sc.nextInt();
            String query = "DELETE FROM publishers WHERE publisher_id = ?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, publisherId);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Publisher with ID " + publisherId + " deleted successfully.");
                } else {
                    System.out.println("No publisher found with ID " + publisherId + ". Nothing was deleted.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during deletion: " + e.getMessage());
        }
    }

    // Delete Review by ID
    public static void deleteReviewById() {
        try (Scanner sc = new Scanner(System.in); 
             Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            
            System.out.print("Enter the Review ID to delete: ");
            int reviewId = sc.nextInt();
            String query = "DELETE FROM reviews WHERE review_id = ?";
            
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, reviewId);
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    System.out.println("Review with ID " + reviewId + " deleted successfully.");
                } else {
                    System.out.println("No review found with ID " + reviewId + ". Nothing was deleted.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during deletion: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test a delete function
        deleteBookById();
    }
}
