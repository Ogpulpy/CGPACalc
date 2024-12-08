import java.util.Scanner;

public class CGPACalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of courses: ");
        int numberOfCourses = scanner.nextInt();

        double totalGradePoints = 0.0;
        int totalCreditUnits = 0;

        for (int i = 1; i <= numberOfCourses; i++) {
            System.out.println("Enter credit units for course " + i + ": ");
            int creditUnits = scanner.nextInt();
            while (creditUnits <= 0) {
                System.out.println("Invalid input. Credit units must be greater than 0. Please re-enter:");
                creditUnits = scanner.nextInt();
            }

            System.out.println("Enter marks (0-100) for course " + i + ": ");
            int marks = scanner.nextInt();
            while (marks < 0 || marks > 100) {
                System.out.println("Invalid input. Marks must be between 0 and 100. Please re-enter:");
                marks = scanner.nextInt();
            }

            double gradePoint = getGradePoint(marks);
            totalGradePoints += gradePoint * creditUnits;
            totalCreditUnits += creditUnits;
        }

        double cgpa = totalGradePoints / totalCreditUnits;
        System.out.printf("Your CGPA is: %.2f%n", cgpa);
        scanner.close();
    }

    public static double getGradePoint(int marks) {
        if (marks >= 70) return 5.0;
        else if (marks >= 60) return 4.0;
        else if (marks >= 50) return 3.0;
        else if (marks >= 45) return 2.0;
        else if (marks >= 40) return 1.0;
        else return 0.0;
    }
}
