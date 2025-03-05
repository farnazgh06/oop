package Packages;

import java.util.ArrayList;
import java.util.HashMap;

public class Uni {
    class Major {
        public int id;
        public static ArrayList<Major> majorList;
        public String name;
        public final int capacity;
        public int numberOfStudents;


        public Major(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
            majorList.add(this);
        }

        public static Major findById(int ID) {
            for(Major major1 : majorList ){
                if(major1.id == ID ){
                    return major1;
                }
            }
            return null;

        }

        public void addStudent() {
            if(numberOfStudents != capacity){
                numberOfStudents++;
            }
            else {
                System.out.println("full of student");
            }

        }

    }
    class Student{

        public int id;
        public static ArrayList<Student>studentList;
        public int personalID;
        public final int enteranceYear;
        public int majorID;
        public String studentID;
        private static int idcount = 1;

        public Student(int personalID, int enteranceYear, int majorID){
            this.personalID = personalID;
            this.enteranceYear = enteranceYear;
            this.majorID = majorID;
            this.id = idcount++;
            studentList.add(this);
            setStudentCode();

        }

        public static Student findById(int ID){
            for(Student student1 : studentList ){
                if(student1.id == ID ){
                    return student1;
                }
            }
            return null;
        }

        public void setStudentCode(){
            int studentCount = 0;
            for(Student student1 : studentList){
                if (student1.majorID == this.majorID && student1.enteranceYear == this.enteranceYear){
                    studentCount++;
                }
            }
            String studentChandom = "" + studentCount;
            while ((studentChandom.length() < 3)){
                studentChandom = "0" + studentChandom;
            }
            this.studentID = enteranceYear + majorID + studentChandom;
        }

    }
    class Professor{
        public int id;
        public static ArrayList<Professor>professorList;
        public int personalID;
        public int majorID;

        public Professor(int personalID, int majorID){
            this.personalID = personalID;
            this.majorID = majorID;
            professorList.add(this);

        }
        public static Professor findById(int ID){
            for(Professor professor1 : professorList ){
                if(professor1.id == ID ){
                    return professor1;
                }
            }
            return null;
        }
    }
    class Course{
        public int id;
        public static ArrayList<Course>courseList;
        public String title;
        public int units;

        public Course(String title, int units){
            this.title = title;
            this.units = units;
            courseList.add(this);
            this.id = courseList.size();
        }

        public static Course findById(int ID){
            for(Course course1 : courseList ){
                if(course1.id == ID ){
                    return course1;
                }
            }
            return null;
        }

    }
    class PresentedCourse{
        public int id;
        public static ArrayList<PresentedCourse>presentedCourseList;
        public int courseID;
        public int professorID;
        public int capacity;
        public ArrayList<Integer> studentIds;

        public PresentedCourse(int courseID, int professorID, int maxCapacity){
            this.courseID = courseID;
            this.professorID = professorID;
            this.capacity = maxCapacity;
            this.studentIds = new ArrayList<>(maxCapacity);

            presentedCourseList.add(this);

            this.id = presentedCourseList.size();

        }

        public static PresentedCourse findById(int ID){
            for(PresentedCourse presentedCourse1 : presentedCourseList ){
                if(presentedCourse1.id == ID )
                {
                    return presentedCourse1;
                }
            }
            return null;
        }
        public void addStudent(int studentID){

            if (studentIds.size() != capacity) {
                    studentIds.add(studentID);
                }
                else
                {
                    System.out.println("Course is full.");
                }


        }

    }
    class Transcript{
        public int studentID;
        public String studentName;
        public HashMap<Integer, Double> transcript;


        public Transcript(int studentID){

            this.studentID = studentID;
            this.transcript = new HashMap<>();

        }
        public void setGrade(int presentedCourseID, double grade) {
            if (transcript.containsKey(presentedCourseID)) {
                transcript.put(presentedCourseID, grade);
            } else {
                System.out.println("نمره ندارد");
            }
        }
        public void printTranscript(){
            System.out.println(studentID);
            System.out.println(studentName);

            for (Integer courseID : transcript.keySet()) {

                PresentedCourse presentedCourse2 = PresentedCourse.findById(courseID);
                Course course2 = Course.findById(courseID);

                if (presentedCourse2 != null && course2 != null) {

                    System.out.println(courseID);
                    System.out.println(transcript.get(courseID));
                }
            }

        }
        public double getGPA(){
            double avg =0.0;
            int vahed = transcript.size();
            for(double transcript : transcript.values()){
                avg = avg + transcript;
            }
            return avg / vahed;

        }

    }






}
