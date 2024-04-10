import java.util.Scanner;
public class Enrolment {
    private int studentID;
    int courseCode, coursePax = 0;
    String status;

    public Enrolment(int studentID, int courseCode, String status){
        this.studentID = studentID;
        this.courseCode = courseCode;
        this.status = status;
        coursePax+=1;
    }

    public void displayDetails(){
        System.out.println("\\033[1mEnrolment Summary\\033[0m");
        System.out.println("Student ID: "+this.studentID);
        System.out.println("Course code: "+this.courseCode);
        System.out.println("Status: "+this.status);
        System.out.println("\n");
    }

    public void editEnrolment(){
        String newStatus;
        int newCode;
        Scanner s = new Scanner(System.in);
        System.out.println("\nYou are about to edit the enrolment, which detail would you like to edit?");
        System.out.println("1. Enrolment status");
        System.out.println("2. Change course code");
        System.out.print("Enter your selection: ");
        int selection = s.nextInt();

        if(selection == 1){
            System.out.print("\nWhat is the new enrolment status?: ");
            newStatus = s.nextLine();
            changeStatus(newStatus);
        }
        else{
            System.out.print("\nInput the new course code (integer >0 only)?: ");
            newCode = s.nextInt();
            changeCourseCode(newCode);
        }

    }

    public void changeStatus(String new_status){
        this.status = new_status;
    }

    public void changeCourseCode(int new_course_code){
        this.courseCode = new_course_code;
    }
}
