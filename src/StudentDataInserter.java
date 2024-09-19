import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDataInserter {
    private static final String URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "";  // Replace with your password

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Emily Turner", "452 Cedar St", "555-7101"));
        students.add(new Student("Michael Brown", "34 Oak Ave", "555-7102"));
        // Add more students as needed
        students.add(new Student("Richard Walker", "325 Sunset Blvd", "555-7116"));
        students.add(new Student("Patricia King", "213 Highland Ave", "555-7117"));

        for (Student student : students) {
            insertStudent(student);
        }
    }

    public static void insertStudent(Student student) {
        String sql = "INSERT INTO students (name, streetAddress, phoneNumber) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getStreetAddress());
            pstmt.setString(3, student.getPhoneNumber());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Data inserted successfully for: " + student.getName());
            } else {
                System.out.println("Data insertion failed for: " + student.getName());
            }
        } catch (SQLException e) {
            System.out.println("Error occurred during data insertion for: " + student.getName() + ": " + e.getMessage());
        }
    }
}
