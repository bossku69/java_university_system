import java.util.Scanner;
public class Student {
    String name,email,contactNumber;
    int studentID;

    public Student(String name, String email, String contactNumber,int studentID){
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.studentID = studentID;
    }

    public void displayDetails(){
        System.out.println("\nStudent details are as follows");
        System.out.println("Name: "+this.name);
        System.out.println("Email: "+this.email);
        System.out.println("Contact Number: "+this.contactNumber);

    }

    public void editMenu(){
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int selection;
        String new_detail;
        System.out.println("You are only allowed to edit one detail at a time. What would you like to edit?");
        System.out.println("1. Name\n2.Email\n3.Contact Number\n");
        selection = s1.nextInt();

        switch(selection){
            case 1:
                System.out.print("What is your new name? : ");
                new_detail = s2.nextLine();
                break;
            case 2:
                System.out.print("What is your new email? : ");
                new_detail = s2.nextLine();
                break;
            default:
                System.out.print("What is your new contact number? : ");
                new_detail = s2.nextLine();
        }
        editDetail(selection, new_detail);
    }

    public void editDetail(int selection, String new_detail){
        if(selection == 1){
            this.name = new_detail;
        }
        else if(selection == 2){
            this.email = new_detail;
        }
        else{
            this.contactNumber = new_detail;
        }
    }

    public int getStudentID(){
        return this.studentID;
    }
}
