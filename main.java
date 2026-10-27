import java.util.Scanner;

public class main {

    public static double calculateAverage(int[] marks) {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return (double) total / marks.length;
  }

    public static String getGrade(double average) {
        if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Validation for Student Name: Keep asking until user provides a non-blank name
        String name = "";
        while (true) {
            System.out.print("Enter student name: ");
            name = sc.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Error: Student name cannot be blank. Please try again.");
            } else {
                break;
            }
        }

        // Validation for Number of Subjects: Keep asking until user enters an integer > 0
        int n = 0;
        while (true) {
            System.out.print("Enter number of subjects: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Error: Number of subjects must be greater than 0. Please try again.");
                } else {
                    break;
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid integer.");
                sc.next(); // Clear invalid input
            }
        }

        int[] marks = new int[n];

        // Validation for Subject Marks: Keep asking for each mark until it's between 0 and 100
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                if (sc.hasNextInt()) {
                    int mark = sc.nextInt();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Error: Marks must be between 0 and 100. Please try again.");
                    } else {
                        marks[i] = mark;
                        break;
                    }
                } else {
                    System.out.println("Error: Invalid input. Please enter a valid integer for marks.");
                    sc.next(); // Clear invalid input
                }
            }
ateAverage(marks);

        System.out.println("\nStudent: " + name);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + getGrade(average));

        sc.close();
    }
}
