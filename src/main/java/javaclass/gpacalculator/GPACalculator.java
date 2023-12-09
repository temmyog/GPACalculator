package javaclass.gpacalculator;

/**
 *
 * @author MY PC
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPACalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please Enter your name: ");
        String studentName = scanner.nextLine();

        System.out.println(studentName + ", welcome to Your Favorite GPA Calculator.");

        GPALogic gpaLogic = new GPALogic();
        boolean inputAnotherCourse = true;

        List<String> courseCodesList = new ArrayList<>();
        List<Integer> courseUnitsList = new ArrayList<>();
        List<Integer> scoresList = new ArrayList<>();

        while (inputAnotherCourse) {
            System.out.print("Enter the Course Code: ");
            String courseCode = scanner.next();

            System.out.print("Enter the Course Unit: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter an integer for course unit: ");
                scanner.next();  // Consume the invalid input
            }
            int courseUnit = scanner.nextInt();

            System.out.print("Enter your score : ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number for the score: ");
                scanner.next();  // Consume the invalid input
            }
            int score = scanner.nextInt();

            while (score < 0 || score > 100) {
                System.out.print("Invalid score. Please enter a score between 0 and 100: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Invalid input. Please enter a number for the score: ");
                    scanner.next();  // Consume the invalid input
                }
                score = scanner.nextInt();
            }

            gpaLogic.calculateQualityPoints(courseUnit, score);

            System.out.print("Do you want to input results for another course? (true/false): ");
            inputAnotherCourse = scanner.nextBoolean();

            courseCodesList.add(courseCode);
            courseUnitsList.add(courseUnit);
            scoresList.add(score);
        }

        double gpa = gpaLogic.calculateGPA();

        

        TabularResults tabularResults = new TabularResults(
                courseCodesList.toArray(new String[0]),
                courseUnitsList.stream().mapToInt(Integer::intValue).toArray(),
                scoresList.stream().mapToInt(Integer::intValue).toArray(),
                gpaLogic.getGradeUnits()
        );
        tabularResults.generateTable();
        
        System.out.println(studentName + ", your GPA is: " + gpa);
        
        
        System.out.println("Thank you for using Your Favorite GPA Calculator, " + studentName + "!");
    }
}

