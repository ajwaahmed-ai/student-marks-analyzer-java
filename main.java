import java.util.Scanner;

public class main {

    // Preserved method: Calculates average marks from array of marks
    public static double calculateAverage(int[] marks) {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return (double) total / marks.length;
    }

    // Preserved method: Assigns a letter grade based on calculated average
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

        // Input Validation 1: Ensure student name is not blank or whitespace-only
        String name = "";
        while (true) {
            System.out.print("Enter student name: ");
            name = sc.nextLine();
            if (!name.trim().isEmpty()) {
                break;
            }
            System.out.println("Error: Student name cannot be blank. Please enter a valid name.");
        }

        // Input Validation 2: Ensure number of subjects is greater than zero
        int n = 0;
        while (true) {
            System.out.print("Enter number of subjects: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) {
                    break;
                } else {
                    System.out.println("Error: Number of subjects must be greater than 0.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid number of subjects.");
                sc.next(); // Consume non-integer token to avoid infinite loop
            }
        }

        int[] marks = new int[n];

        // Input Validation 3: Ensure each subject mark is within range 0 to 100
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                if (sc.hasNextInt()) {
                    int mark = sc.nextInt();
                    if (mark >= 0 && mark <= 100) {
                        marks[i] = mark;
                        break;
                    } else {
                        System.out.println("Error: Marks must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Error: Invalid input. Please enter a valid integer for marks.");
                    sc.next(); // Consume non-integer token to avoid infinite loop
                }
            }
        }

        double average = calculateAverage(marks);

        System.out.println("\nStudent: " + name);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + getGrade(average));

        sc.close();
    }
}
