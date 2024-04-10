import java.util.Scanner;

public class Course {
    int courseCode, coursePaxMax;
    String title, description, instructor;

    public Course(String title, String description, String instructor, int courseCode, int coursePaxMax){
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.coursePaxMax = coursePaxMax;
    }

    public void displayDetails(){
        System.out.println("\n------Available Course Details------");
        System.out.println("Title: "+this.title);
        System.out.println("Description: "+this.description);
        System.out.println("Instructor: "+this.instructor);
        System.out.println("Course Code: "+this.courseCode);
        System.out.println("Max. allowed students: "+this.coursePaxMax);
    }

    public int getCourseCode(){
        return this.courseCode;
    }

    public int getCoursePaxMax(){
        return this.coursePaxMax;
    }

    public void editMenu(){
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int selection;
        String new_detail;
        System.out.println("You are only allowed to edit one detail at a time. What would you like to edit?");
        System.out.println("1. Title\n2. Description\n3. Instructor\n4. Course code\n5. Max allowed students");
        selection = s1.nextInt();

        switch(selection){
            case 1:
                System.out.print("What is the new title? : ");
                new_detail = s2.nextLine();
                break;
            case 2:
                System.out.print("What is the new description? : ");
                new_detail = s2.nextLine();
                break;
            case 3:
                System.out.print("Who is the new instructor? : ");
                new_detail = s2.nextLine();
                break;
            case 4:
                System.out.print("What is the new course code? (integer >0 only) : ");
                new_detail = s2.nextLine();
                break;
            default:
                System.out.print("What is the new maximum allowed students? (integer >0 only) : ");
                new_detail = s2.nextLine();
        }
        editDetail(selection, new_detail);
    }

    public void editDetail(int selection, String new_detail){
        if(selection == 1){
            this.title = new_detail;
        }
        else if(selection == 2){
            this.description = new_detail;
        }
        else if(selection == 3){
            this.instructor = new_detail;
        }
        else if(selection == 4){
            this.courseCode = Integer.valueOf(new_detail);
        }
        else{
            this.coursePaxMax = Integer.valueOf(new_detail);
        }
    }

}
