import java.sql.*;
import java.util.Scanner;

public class Updatebook {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/bookmanagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Hello@123";

    public static void updateBooks() {
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter the Book ID to update: ");
            int bookId = sc.nextInt();
            sc.nextLine();

            System.out.println("Select the column to update:");
            System.out.println("1. Title");
            System.out.println("2. Author");
            System.out.println("3. ISBN");
            System.out.println("4. Publisher");
            System.out.println("5. Publication Date");
            System.out.println("6. Pages");
            System.out.println("7. Price");
            System.out.println("8. Quantity");
            System.out.println("9. Language");
            System.out.println("10. Edition");
            System.out.println("11. Weight");
            System.out.println("12. Cover Image File Name");

            System.out.print("Enter your choice (1-12): ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            String columnName = switch (choice) {
                case 1 -> "title";
                case 2 -> "author";
                case 3 -> "isbn";
                case 4 -> "publisher";
                case 5 -> "publication_date";
                case 6 -> "pages";
                case 7 -> "price";
                case 8 -> "quantity";
                case 9 -> "language";
                case 10 -> "edition";
                case 11 -> "weight";
                case 12 -> "cover_image";
                default -> null;
            };

            if (columnName == null) {
                System.out.println("Invalid column choice. Please try again.");
                return;
            }

            System.out.print("Enter the new value: ");
            String newValue;
            if (choice == 3 || choice == 6 || choice == 7 || choice == 8 || choice == 10 || choice == 11) {
                // Numeric fields
                newValue = sc.nextLine();
                if (!newValue.matches("\\d+(\\.\\d+)?")) { // Ensure numeric input
                    System.out.println("Invalid numeric value. Update aborted.");
                    return;
                }
            } else {
                // Text fields
                newValue = sc.nextLine();
            }

            String query = "UPDATE books SET " + columnName + " = ? WHERE book_id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                if (choice == 3 || choice == 6 || choice == 7 || choice == 8 || choice == 10 || choice == 11) {

                    pstmt.setInt(1, Integer.parseInt(newValue));
                } else {
                    pstmt.setString(1, newValue);
                }
                pstmt.setInt(2, bookId);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Book record updated successfully!");
                } else {
                    System.out.println("No book found with the given ID.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error updating data in Books table: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        updateBooks();
    }
}
