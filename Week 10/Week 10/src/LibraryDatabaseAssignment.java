
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class LibraryDatabaseAssignment {

    // =========================
    // DATABASE CONFIGURATION
    // =========================
    private static final String SERVER_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB = "library_management_assignment";
    private static final String DB_URL = SERVER_URL + DB;
    private static final String USER = "root";
    private static final String PASSWORD = "Googlechrome12";

    private static final Scanner in = new Scanner(System.in);

    // =========================
    // CONNECTION MODEL
    // =========================
    static Connection getConnection(boolean server) throws SQLException {
        return DriverManager.getConnection(
                server ? SERVER_URL : DB_URL,
                USER,
                PASSWORD
        );
    }

    // =========================
    // EXECUTOR 
    // =========================
    static void execUpdate(String sql, String msg, boolean server) {
        try (Connection c = getConnection(server); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.executeUpdate();
            System.out.println(msg);

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }

    // =========================
    // HELPER METHODS
    // =========================
    static void pause() {
        System.out.print("\nPress Enter to continue...");
        in.nextLine();
    }

    static boolean confirm(String msg) {
        System.out.println(msg);
        System.out.print("Type YES to confirm: ");
        return in.nextLine().equalsIgnoreCase("YES");
    }

    static int readInt() {
        while (true) {
            try {
                System.out.print("Choice: ");
                return Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid number.");
            }
        }
    }

    // =========================
    // DATABASE OPERATIONS
    // =========================
    static void createDatabase() {
        execUpdate("CREATE DATABASE IF NOT EXISTS " + DB,
                "Database ready.", true);
        pause();
    }

    // =========================
    // TABLES
    // =========================
    static void createBooksTable() {
        String sql = """
        CREATE TABLE IF NOT EXISTS books(
            book_id CHAR(8) PRIMARY KEY,
            title VARCHAR(60),
            author VARCHAR(40),
            price DECIMAL(8,2),
            published_year INT
        )
        """;

        execUpdate(sql, "Books table created.", false);
        pause();
    }

    static void createMembersTable() {
        String sql = """
        CREATE TABLE IF NOT EXISTS members(
            member_id CHAR(8) PRIMARY KEY,
            member_name VARCHAR(50),
            email VARCHAR(60)
        )
        """;

        execUpdate(sql, "Members table created.", false);
        pause();
    }

    // =========================
    // PART A: LOANS TABLE
    // =========================
    static void createLoansTable() {

        String sql = """
        CREATE TABLE IF NOT EXISTS loans(
            loan_id CHAR(8) PRIMARY KEY,
            loan_date DATE,
            book_id CHAR(8),
            member_id CHAR(8),
            return_date DATE,
            FOREIGN KEY (book_id) REFERENCES books(book_id),
            FOREIGN KEY (member_id) REFERENCES members(member_id)
        )
                """;

        execUpdate(sql, "Loan's table created.", false);
        pause();
    }

    static void dropLoansTable() {
        
        if (!confirm("Drop the loans table permanently?")) {
            System.out.println("Cancelled.");
            pause();
            return;
        }

        execUpdate("DROP TABLE IF EXISTS loans", "Loans dropped.", false);
        pause();
    }

    // =========================
    // PART B: INSERT OPERATIONS
    // =========================
    static void addBook() {

        String id;
        String title;
        String author;
        double price;
        int published_year;

        System.out.println("Book ID: ");
        id = in.nextLine();
        System.out.println("Book title: ");
        title = in.nextLine();
        System.out.println("Author's name: ");
        author = in.nextLine();
        System.out.println("Enter book price: ");
        price = in.nextDouble();
        System.out.println("Book's published year: ");
        published_year = in.nextInt();

        String sql = """
                INSERT INTO books
            (book_id,
            title,
            author,
            price,
            published_year)
            VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection c = getConnection(false); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setDouble(4, price);
            ps.setInt(5, published_year);
            int rows = ps.executeUpdate();

            System.out.println(rows + " book added.");

        } catch (SQLException e) {
            System.out.println("WRONG");
        }
    }

    static void addMember() {

        String id;
        String name;
        String email;

        System.out.println("Enter your ID: ");
        id = in.nextLine();
        System.out.println("Enter your name: ");
        name = in.nextLine();
        System.out.println("Enter your email: ");
        email = in.nextLine();

        String sql = """
            (member_id,
            member_name,
            email)
            VALUES (?, ?, ?)
                """;

        try (Connection c = getConnection(false); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            int rows = ps.executeUpdate();

            System.out.println(rows + " member inserted.");

        } catch (SQLException e) {
            System.out.println("WRONG");
        }
    }

    static void issueBook() {

        LocalDate loanDate;

        try {
            System.out.print("Loan Date (YYYY-MM-DD): ");
            loanDate = LocalDate.parse(in.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date. Please use YYYY-MM-DD.");
            return;
        }
    }

    // =========================
    // PART C: SELECT OPERATIONS
    // =========================
    static void viewBooks() {
    }

    static void viewMembers() {
    }

    static void viewLoans() {
        String sql = """
        SELECT l.loan_id, b.title, m.member_name, l.loan_date, l.return_date
        FROM loans l
        JOIN books b ON l.book_id = b.book_id
        JOIN members m ON l.member_id = m.member_id
        """;
    }

    // =========================
    // MAIN MENU
    // =========================
    public static void main(String[] args) {

        int ch;

        do {
            System.out.println("""
=========================
 LIBRARY SYSTEM
=========================
1 Create Database
2 Create Books Table
3 Create Members Table
4 Create Loans Table
5 Drop Loans Table
6 Add Book
7 Add Member
8 Issue Book
9 View Books
10 View Members
11 View Loans
0 Exit
""");

            ch = readInt();

            switch (ch) {
                case 1 ->
                    createDatabase();
                case 2 ->
                    createBooksTable();
                case 3 ->
                    createMembersTable();
                case 4 ->
                    createLoansTable();
                case 5 ->
                    dropLoansTable();
                case 6 ->
                    addBook();
                case 7 ->
                    addMember();
                case 8 ->
                    issueBook();
                case 9 ->
                    viewBooks();
                case 10 ->
                    viewMembers();
                case 11 ->
                    viewLoans();
                case 0 ->
                    System.out.println("Goodbye");
                default ->
                    System.out.println("Invalid choice");
            }

        } while (ch != 0);
    }
}
