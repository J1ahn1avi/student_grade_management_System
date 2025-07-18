//simple grading system.
import java.util.Scanner;

class Student {
    private String name;
    private int marks;

    public void setDetails(String name, int marks){
        this.name=name;
        this.marks=marks;
    }

    public int getmarks(){return marks;}
    public String getname() {return name;}

}

class GradeCalculator{
    public char calculatorGrade(int marks){
        if(marks>=90) return 'A';
        else if (marks>=75) return 'B';
        else if (marks>=60) return 'C';
        else if (marks>=40) return 'D';
        else return 'F';
    }

    public char calculatorGrade(int marks, int bonus){
        int finalMarks=marks+bonus;
        return calculatorGrade(finalMarks);
    }
}

class DisplayUtil{
    public static  void printHeading(){
        System.out.println("\n===== STUDENT GRADE MANAGER =====");
    }
}

public class StudentGradeManager{
    public static void main (String args[]){
        Scanner scan=new Scanner(System.in);

        DisplayUtil.printHeading();

        System.out.print("Enter number of students: ");
        int n=scan.nextInt();

        Student[] students=new Student[n];
        GradeCalculator calculator=new GradeCalculator();
        
        for(int i=0;i<n;i++){
            students[i]=new Student();

            System.out.println("Enter the name of the student "+(i+1)+": ");
            String name=scan.next();

            System.out.println("Enter marks of "+name+" : ");
            int marks=scan.nextInt();
            students[i].setDetails(name, marks);
        }


        System.out.println("\n ------- Student Grades ------- ");

        for(Student s: students){
            char grade=calculator.calculatorGrade(s.getmarks());

            System.out.println(s.getname()+"  Marks: "+ s.getmarks()+ "--> Grade: "+ grade);
        }

        System.out.println("\nEnter bonus marks to apply to all :");
        int bonus=scan.nextInt();

        System.out.println("\nGrades after bonus ");

        for(Student s:students){
            char grade=calculator.calculatorGrade(s.getmarks(), bonus);
            System.out.println(s.getname()+" --> Final Grade (with bonus) : "+grade);
        }

        scan.close();
    }
}

