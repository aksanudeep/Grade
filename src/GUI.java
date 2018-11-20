import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.sound.midi.Soundbank;
import javax.swing.*;

class ButtonFrame extends JFrame
{
    ButtonFrame(String title)
    {
        super( title );                     // invoke the JFrame constructor
        setLayout( new FlowLayout() );      // set the layout manager
        JButton button = new JButton("Click Me For your grades!"); // construct a JButton
        add( button );                     // add the button to the JFrame
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                File file = new File("student_grades_final.txt");
                Scanner sc = null;
                try {
                    sc = new Scanner(file);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                List<String> gradeList = new ArrayList<String>();
                List<String> res = new ArrayList<>();

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
                            // GradeDisplayUnit = new GradeDisplayUnit();
                            try
                            {
                                if(arrOfStr.length==7 && (total<=600))
                                {
                                    char calculatedGrade = GradeDisplayUnit.gradeCalculator(studentName,homework1,homework2,homework3,midterm,project,finalMarks);
                                    System.out.println(studentName+" - "+calculatedGrade);
                                    res.add("Grade"+calculatedGrade);
                                    JTextArea text = new JTextArea(studentName+" - "+calculatedGrade);
                                    add(text);
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
                            catch (Exception e1) {
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
               // JTextArea text = new JTextArea("grade"+gradeList);
                //add(text);
                System.out.println(res);
                int A= Collections.frequency(res, "GradeA");
                int B =Collections.frequency(res, "GradeB");
                int C =Collections.frequency(res, "GradeC");
                System.out.println("Total Counts of Grade A "  + A +
                        " Total Counts of Grade B "
                        + B + " Total Counts of Grade C "  + C);
            }


        });
        button.setBounds(50,50,50,50);




        //this.setVisible(false);
        //JFrame frame= new JFrame();
        //JTextArea tarea=new JTextArea();
      //  frame.setVisible(true);
      // frame.setSize(400,400);




    }
}

public class GUI
{

    public static void main ( String[] args )
    {
        ButtonFrame frm = new ButtonFrame("Button Demo");
        frm.setSize( 400, 400 );
        frm.setVisible( true );

    }
}

