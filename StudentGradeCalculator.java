package src.StudentGradeCalculator;

import java.util.Scanner;

class Student
{
    public int[] getStudentMarks()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int totalSubjects = sc.nextInt();
        int[] subjectMarks = new int[totalSubjects];

        for(int i = 0; i < totalSubjects; i++)
        {
            int validMarks = 0; // Temporary variable to hold input marks
            do
            {
                System.out.print("Enter marks obtained in " + (i+1) + suffix(i+1) + " Subject out of 100: ");
                validMarks = sc.nextInt();
                if(validMarks < 1 || validMarks > 100)
                {
                    System.out.println("Please enter the marks in range 1 to 100");
                }
            }while(validMarks < 1 || validMarks > 100);

            subjectMarks[i] = validMarks;
        }
        return subjectMarks;
    }

    private String suffix(int number) {
        if (number >= 11 && number <= 13) {
            return "th"; // Special case for 11th, 12th, and 13th
        }
        switch (number % 10) { // Check the last digit
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            default: return "th";
        }
    }

    public int totalMarks(int[] subjectMarks)
    {
        int calculateTotalMarks = 0;
        for(int ele: subjectMarks)
        {
            calculateTotalMarks += ele;
        }
        return calculateTotalMarks;
    }

    public float averagePercentage(int[] subjectMarks, int totalMarks)
    {
        int n = subjectMarks.length;
        float avgPercent = (float) totalMarks / n;
        return Float.parseFloat(String.format("%.2f", avgPercent));
    }

    public void assignGrades(float avgPercent)
    {
        if(avgPercent < 50)
        {
            System.out.println("Grade: F");
        }
        else if(avgPercent < 60)
        {
            System.out.println("Grade: E");
        }
        else if(avgPercent < 70)
        {
            System.out.println("Grade: D");
        }
        else if(avgPercent < 80)
        {
            System.out.println("Grade: C");
        }
        else if(avgPercent < 90)
        {
            System.out.println("Grade: B");
        }
        else
        {
            System.out.println("Grade: A");
        }
    }
}

public class StudentGradeCalculator
{
    public static void main(String[] args) {
        Student s1 = new Student();
        int[] marks = s1.getStudentMarks();
        int n = marks.length;
        int sumOfMarks = s1.totalMarks(marks);
        System.out.println("Total marks obtained: " + sumOfMarks + ", Out of " + (100 * n));
        float avgPercent = s1.averagePercentage(marks, sumOfMarks);
        System.out.println("Percentage: " + avgPercent + " %");
        s1.assignGrades(avgPercent);

    }
}
