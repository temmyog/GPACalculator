/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaclass.gpacalculator;
import  javaclass.gpacalculator.TabularResults;
/**
 *
 * @author MY PC
 */
public class TabularResults {
    private String[] courseCodes;
    private int[] courseUnits;
    private char[] grades;
    private int[] gradeUnits;

    public TabularResults(String[] courseCodes, int[] courseUnits, int[] scores, int[] gradeUnits) {
        this.courseCodes = courseCodes;
        this.courseUnits = courseUnits;
        this.grades = determineGrades(scores);
        this.gradeUnits = gradeUnits;
    }

    public void generateTable() {
        System.out.println("-------------------------------------------------");
        System.out.println("| Course Code | Course Unit | Grade | Grade Unit |");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < courseCodes.length; i++) {
        System.out.printf("| %-11s | %-12d | %-4c  | %-9d  |\n",
                courseCodes[i], courseUnits[i], grades[i], gradeUnits[i]);
        }
         System.out.println("-------------------------------------------------");
    }

    private char[] determineGrades(int[] scores) {
        char[] result = new char[scores.length];

        for (int i = 0; i < scores.length; i++) {
            result[i] = determineGrade(scores[i]);
        }

        return result;
    }

    private char determineGrade(int score) {
        if (score >= 70 && score <= 100) {
            return 'A';
        } else if (score >= 60 && score <= 69) {
            return 'B';
        } else if (score >= 50 && score <= 59) {
            return 'C';
        } else if (score >= 45 && score <= 49) {
            return 'C';
        } else if (score >= 40 && score <= 44) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
