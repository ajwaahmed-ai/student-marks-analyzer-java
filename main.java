
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

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject "
                    + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        double average = calculateAverage(marks);

        System.out.println("\nStudent: " + name);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + getGrade(average));

        sc.close();
    }
}