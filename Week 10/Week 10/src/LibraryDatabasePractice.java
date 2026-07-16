import java.sql.*;
import java.util.Scanner;

public class LibraryDatabasePractice {

    // =========================
    // DATABASE CONFIGURATION
    // TODO: set these values for your database server
    // =========================
    private static final String SERVER_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB = "library_management_practice";
    private static final String DB_URL = SERVER_URL + DB;
    private static final String USER = "root";
    private static final String PASSWORD = "Googlechrome12";

    private static final Scanner in = new Scanner(System.in);

    // =========================
    // CONNECTION HELPERS
    // =========================
    static Connection getConnection(boolean server) throws SQLException {
        // TODO: return a connection to the server or the practice database
        return DriverManager.getConnection(
                server ? SERVER_URL : DB_URL,
                USER,
                PASSWORD
        );

    }

    // EXECUTOR
    static void execUpdate(String sql, String msg, boolean server) {
        // TODO: execute a SQL update statement safely
        try (Connection c = getConnection(server); PreparedStatement ps = c.preparedStatement(sql)) {

            ps.executeUpdate();
            System.out.println(msg);

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    // =========================
    // UTILITY METHODS
    // =========================
    static void pause() {
        // TODO: wait for the user to press Enter
        System.out.println("\nPress Enter to continue..");
        in.nextLine();
    }

    static boolean confirm(String warning) {
        // TODO: ask the user to confirm a destructive action
        System.out.println(warning);
        System.out.println("YOU'LL BE UNABLE TO REVERT IF YOU CONTINUE");
        System.out.println("            TYPE YES TO CONFIRM");
        return in.nextLine().equalsIgnoreCase("YES");
    }

    static int readInt() {
        // TODO: read an integer from the console and handle bad input
        while (true) { 
            try {
                System.out.print("Choice: ");
                return Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid number!");
            }
        }
    }

    // =========================
    // DATABASE / TABLE SETUP
    // =========================
    static void createDatabase() {
        // TODO: create the practice database if it does not exist
        execUpdate("CREATE DATABASE IF NOT EXISTS" + DB, 
                "Database Ready.", true);
        pause();
    }

    static void createBooksTable() {
        // TODO: create the books table with columns:
        // book_id, title, author, price, publication_year
    }

    static void createMembersTable() {
        // TODO: create the members table with columns:
        // member_id, member_name, email
    }

    static void createLoansTable() {
        // TODO: create the loans table with columns:
        // loan_id, loan_date, book_id, member_id, return_date
        // TODO: add foreign keys to books and members
    }

    // =========================
    // ALTER TABLE PRACTICE
    // =========================
    static void addGenreColumn() {
        // TODO: alter the books table to add a genre column
    }

    static void renamePublicationYear() {
        // TODO: rename the publication_year column to published_year
    }

    static void modifyPriceColumn() {
        // TODO: modify the books.price column precision or scale
    }

    // =========================
    // INSERT / UPDATE / DELETE OPERATIONS
    // =========================
    static void addBook() {
        // TODO: prompt the user and insert a book into the books table
    }

    static void addMember() {
        // TODO: prompt the user and insert a member into the members table
    }

    static void issueLoan() {
        // TODO: prompt the user for loan details and insert into loans
    }

    static void updateBookPrice() {
        // TODO: prompt for a book ID and new price, then update the record
    }

    static void deleteMember() {
        // TODO: prompt for a member ID and delete the record safely
    }

    // =========================
    // SELECT / VIEW OPERATIONS
    // =========================
    static void viewBooks() {
        // TODO: select and display all books
    }

    static void viewMembers() {
        // TODO: select and display all members
    }

    static void viewLoans() {
        // TODO: select and display all loans with book and member details
    }

    // =========================
    // DROP / TRUNCATE OPERATIONS
    // =========================
    static void truncateBooksTable() {
        // TODO: truncate the books table after confirming the action
    }

    static void dropBooksTable() {
        // TODO: drop the books table after confirming the action
    }

    static void dropMembersTable() {
        // TODO: drop the members table after confirming the action
    }

    static void dropLoansTable() {
        // TODO: drop the loans table after confirming the action
    }

    static void dropDatabase() {
        // TODO: drop the entire practice database after confirming the action
    }

    // =========================
    // MAIN MENU
    // =========================
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Library Database Practice ===");
            System.out.println("1. Create database");
            System.out.println("2. Create books table");
            System.out.println("3. Create members table");
            System.out.println("4. Create loans table");
            System.out.println("5. Add a book");
            System.out.println("6. Add a member");
            System.out.println("7. Issue a loan");
            System.out.println("8. View books");
            System.out.println("9. View members");
            System.out.println("10. View loans");
            System.out.println("11. Update book price");
            System.out.println("12. Delete a member");
            System.out.println("13. Add genre column");
            System.out.println("14. Rename publication_year");
            System.out.println("15. Modify price column");
            System.out.println("16. Truncate books table");
            System.out.println("17. Drop books table");
            System.out.println("18. Drop members table");
            System.out.println("19. Drop loans table");
            System.out.println("20. Drop database");
            System.out.println("0. Exit");

            int choice = readInt();

            switch (choice) {
                case 1 -> createDatabase();
                case 2 -> createBooksTable();
                case 3 -> createMembersTable();
                case 4 -> createLoansTable();
                case 5 -> addBook();
                case 6 -> addMember();
                case 7 -> issueLoan();
                case 8 -> viewBooks();
                case 9 -> viewMembers();
                case 10 -> viewLoans();
                case 11 -> updateBookPrice();
                case 12 -> deleteMember();
                case 13 -> addGenreColumn();
                case 14 -> renamePublicationYear();
                case 15 -> modifyPriceColumn();
                case 16 -> truncateBooksTable();
                case 17 -> dropBooksTable();
                case 18 -> dropMembersTable();
                case 19 -> dropLoansTable();
                case 20 -> dropDatabase();
                case 0 -> {
                    System.out.println("Goodbye.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
