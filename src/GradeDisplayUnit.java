import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeDisplayUnit {

    public static char gradeCalculator(String studentName,int homework1,int homework2,int homework3,int midterm,int project,int finalMarks)
    {
               double f1 = 0.45*((homework1+homework2+homework3)/3);
        double f2 = 0.25*project;
        double f3 = 0.30*((midterm+finalMarks)/2);
        double final_numerical_grade = f1+f2+f3;


        if(final_numerical_grade>=90 && final_numerical_grade<=100 ){
            return 'A';

        }
        else if(final_numerical_grade>=80 && final_numerical_grade<=89 ){
            return 'B';
        }
        else if(final_numerical_grade>=70 && final_numerical_grade<=79 ){
            return 'C';
        }
        else if(final_numerical_grade>=60 && final_numerical_grade<=69 ){
            return 'D';
        }
        else
        {
            return 'F';
        }


    }

    public static void main(String[] args) throws FileNotFoundException
    {
        // TODO Auto-generated method stub
        File file = new File("student_grades_final.txt");
        Scanner sc = new Scanner(file);
        List<String> gradeList = new ArrayList<String>();

        try {

            while (sc.hasNextLine())
            {
                gradeList.add(sc.nextLine());

            }
            if(gradeList.size()>0)
            {
                for (int i = 1; i < gradeList.size(); i++)
                {
                    String[] arrOfStr = gradeList.get(i).split(",");
                    String studentName = arrOfStr[0];
                    int homework1 = Integer.parseInt(arrOfStr[1]);
                    int homework2 = Integer.parseInt(arrOfStr[2]);
                    int homework3 = Integer.parseInt(arrOfStr[3]);
                    int midterm = Integer.parseInt(arrOfStr[4]);
                    int project = Integer.parseInt(arrOfStr[5]);
                    int finalMarks = Integer.parseInt(arrOfStr[6]);
                    int total= homework1+homework2+homework3+midterm+project+finalMarks;
                    try
                    {
                        if(arrOfStr.length==7 && (total<=600))
                        {
                            char calculatedGrade = gradeCalculator(studentName,homework1,homework2,homework3,midterm,project,finalMarks);
                           System.out.println(studentName+" - "+calculatedGrade);
                           // JTextArea result=new JTextArea();

                        }

                        else
                        {
                            System.out.println("Invalid marks entered for:"+studentName);
                        }
                    }
                    catch (NumberFormatException n) {
                        // TODO: handle exception
                        System.out.println("Enter valid marks");
                    }
                    catch (Exception e) {
                        System.out.println("Enter valid marks");
                    }

                }

            }
            else
            {
                System.out.println("Please provide correct inputs");
            }
            sc.close();
        }
        catch (NumberFormatException nfe) {
            // TODO: handle exception

            System.out.println("Please provide valid marks");
        }
    }


}


