/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaclass.gpacalculator;
public class GPALogic {
    private int totalQualityPoints;
    private int totalGradeUnits;

    public void calculateQualityPoints(int courseUnit, int score) {
        int gradeUnit = determineGradeUnit(score);
        int qualityPoint = courseUnit * gradeUnit;

        totalQualityPoints += qualityPoint;
        totalGradeUnits += courseUnit;
    }

    public double calculateGPA() {
        if (totalGradeUnits == 0) {
            return 0.0;
        }

        double gpa = (double) totalQualityPoints / totalGradeUnits;
        return Math.round(gpa * 100.0) / 100.0;
    }

    public int[] getGradeUnits() {
        return new int[]{5, 4, 3, 2, 1, 0}; // Adjust as per your grading scale
    }

    private int determineGradeUnit(int score) {
        if (score >= 70 && score <= 100) {
            return 5;
        } else if (score >= 60 && score <= 69) {
            return 4;
        } else if (score >= 50 && score <= 59) {
            return 3;
        } else if (score >= 45 && score <= 49) {
            return 2;
        } else if (score >= 40 && score <= 44) {
            return 1;
        } else {
            return 0;
        }
    }
}


