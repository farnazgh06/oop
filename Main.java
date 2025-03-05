import java.util.Scanner;
import Packages.Base.*;
import Packages.Uni.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String major1 = scn.nextLine();
        String major2 = scn.nextLine();

        Person[] person = new Person[5];
        Student[] students = new Student[3];
        Professor[] professors = new Professor[2];

        students[0] = new student(person[0].name, person[0].id, major1);
        students[1] = new student(person[1].name, person[1].id, major1);
        students[2] = new student(person[2].name, person[2].id, major2);

        for (student studentX : students) {
            System.out.println("Name : " + studentX.name);
            System.out.println("ID : " + studentX.id);
            System.out.println("major : " + studentX.major);
        }

        professors[0] = new professor(person[3].personalID, person[3].id, major1);
        professors[1] = new professor(person[4].personalID, person[4].id, major2);

        for (professor professorX : professors){
            System.out.println("personalID : " + professorX.personalID);
            System.out.println("ID : " + professorX.id);
            System.out.println("major : " + professorX.major);
        }

        String courseName1 = scn.nextLine();
        String courseName2 = scn.nextLine();
        String courseName3 = scn.nextLine();

        Course course1 = new Course(courseName1, professors[0]);
        Course course2 = new Course(courseName2, professors[0]);
        Course course3 = new Course(courseName3, professors[1]);

        course1.addStudent(students[0]);
        course1.addStudent(students[1]);
        course2.addStudent(students[0]);
        course2.addStudent(students[1]);
        course2.addStudent(students[2]);
        course3.addStudent(students[2]);

        Transcript transcripts = new Transcript();

        for (student studentX : students) {
            if (studentX.major.equals(major1)) {
                double transcript1 = scn.nextDouble();
                course1.addTranscript(studentX, transcript1);

                double transcript2 = scn.nextDouble();
                course2.addTranscript(studentX, transcript2);
            }

            if (studentX.major.equals(major2)) {
                double transcript2 = scn.nextDouble();
                course2.addTranscript(studentX, transcript2);
            }
        }

        System.out.println("Transcript: ");
        System.out.println(course1.courseName + " " + course1.getTranscript(students[0]));
        System.out.println(course1.courseName + " " + course1.getTranscript(students[1]));
        System.out.println(course1.courseName + " " + course1.getTranscript(students[2]));

        System.out.println("GPA: " + Uni.getGPA());
    }
}
