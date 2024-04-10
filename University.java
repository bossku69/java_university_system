//import relevant packages & libraries here:
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/*
README:
    - this is a 100% original hard work by Yudesh Kumar, no AI was used at all in the creation of this original work.
    - while the concepts such as univeristy being the main file / program may be flawed,it demonstrates originality in the work done here
    - there is zero prior experience with Java and any other programming language, hence this program involved very hard work.


1. The university is the main class & is where the main program sits
2. the university is not treated as a separate object requiring instantiation, it is itself where the main program lives and is dependent on the other classes.
3. As there are no wrong or right answers, it is merely my interpretation of the question and how i have modelled my system.
4. in a nutshell, University.java = main.java (equivalent) which means that the student management system is the university itself

5. other functions are defined further down the program handling procedures such as:
    - defining new class instances
    - method calls

6. a user represents neither a student object not admin object directly but is merely a representation of the access and authorisation required for accessing the student management system
*/
public class University {
    //create sample courses here for when program runs:
    static Course chem = new Course("Chemistry", "Subject about reagents, acids & bases", "Dr. Adam", 1102, 15);
    static Course mat = new Course("Mathematics", "Study of algebra & calculus", "Dr. Farah", 1231, 30);
    static Course[] preCourses = {chem, mat};

    //declare array lists as static due to availability of these variables to methods without instantiation of University
    static ArrayList<Course> courseList = new ArrayList<Course>(Arrays.asList(preCourses));
    static ArrayList<Enrolment> enrolList = new ArrayList<Enrolment>();
    static ArrayList<Student> studentList = new ArrayList<Student>();
    static ArrayList<User> userList = new ArrayList<>();


    public static void main(String[] args){
        boolean programFlag = true;
        boolean[] loginFlag;
        int selection;
        Scanner blank_input = new Scanner(System.in);

        //this is for when the program first runs
        if (userList.toArray().length == 0) {
            System.out.println("\nFirst Program execution detected! Welcome to the program! You will be guided to create a user account first!\n");
            userList.add(newStudentUser());
        }
        //this is the main while loop for the overall program to run continuously:
        while (programFlag) {
            Scanner landing_scan = new Scanner(System.in);

            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\nWelcome to the main landing page! Would you like to login or create a new user?");
            System.out.print("1. Create new student user\n2. Create new admin user\n3.Login\n4.Exit\n\nWhat is your selection? : ");
            int landing_input = landing_scan.nextInt();
            landing_scan.nextLine();

            switch(landing_input){
                case 1:
                    userList.add(newStudentUser());
                    System.out.println("New student user created successfully! hit enter to continue...");
                    landing_scan.nextLine();
                    break;
                case 2:
                    int checkCounter = 0;
                    for(User i:userList){
                        if(i.getOccupation() == "admin"){
                            checkCounter++;
                        }
                    }

                    if(checkCounter > 0){
                        System.out.println("There is already an admin user record! Only one admind user allowed! hit enter to return...");
                        landing_scan.nextLine();
                        break;
                    }
                    else {
                        userList.add(newAdminUser());
                        System.out.println("New admin user created successfully! hit enter to continue...");
                        landing_scan.nextLine();
                        break;
                    }
                case 3:
                    loginFlag = login();
                    programFlag = loginFlag[0];

                    boolean studentFlag, adminFlag;
                    if(loginFlag[1]){
                        studentFlag = true;
                        adminFlag = false;
                    }
                    else{
                        studentFlag = false;
                        adminFlag = true;
                    }
                    while(studentFlag){
                        //this if is for student program flow only:
                        //if (loginFlag[1]) {
                        selection = studentMenu();
                        switch (selection) {
                            case 1:
                                if(studentList.toArray().length == 0) {
                                    studentList.add(newStudent());
                                    System.out.println("\nSuccessfully added student! hit enter to proceed...");
                                    blank_input.nextLine();
                                }
                                else{
                                    System.out.println("You cannot create a new profile! Only one student profile per user account allowed! hit enter to return...\n");
                                    blank_input.nextLine();
                                }
                                break;
                            case 2:
                                if(studentList.toArray().length == 0){
                                    System.out.println("no students to edit yet! please create some students first. hit enter to return...\n");
                                    blank_input.nextLine();
                                    break;
                                }
                                else{
                                    for (Student i : studentList) {
                                        i.editMenu();
                                    }
                                    System.out.println("\nAny student detail changes are saved!");
                                    blank_input.nextLine();
                                    break;
                                }
                            case 3:
                                if(studentList.toArray().length == 0){
                                    System.out.println("no students to display yet! please create some students first. hit enter to return...\n");
                                    blank_input.nextLine();
                                    break;
                                }
                                else {
                                    for (Student i : studentList) {
                                        i.displayDetails();
                                    }
                                    System.out.println("\nStudent details displayed successfully! hit enter to proceed...");
                                    blank_input.nextLine();
                                    break;
                                }
                            case 4:
                                for (Course i:courseList){
                                    i.displayDetails();
                                }
                                System.out.println("\nCourse details displayed successfully! hit enter to proceed...");
                                blank_input.nextLine();
                                break;
                            case 5:
                                enrolList.add(newEnrolment());
                                System.out.println("\nYou have enrolled successfully! hit enter to proceed...");
                                blank_input.nextLine();
                                break;
                            case 6:
                                if(enrolList.toArray().length == 0){
                                    System.out.println("No enrolment records to display! Pleae create one, hit enter to proceed...");
                                    blank_input.nextLine();
                                    break;
                                }
                                else {
                                    for (Enrolment i : enrolList) {
                                        i.displayDetails();
                                    }
                                    System.out.println("\nEnrolment details displayed successfully! hit enter to proceed...");
                                    blank_input.nextLine();
                                    break;
                                }
                            case 7:
                                if(enrolList.toArray().length == 0){
                                    System.out.println("No enrolment records to edit! Please create one, hit enter to proceed...");
                                    blank_input.nextLine();
                                    break;
                                }
                                else {
                                    for (Enrolment i : enrolList) {
                                        i.editEnrolment();
                                    }
                                    System.out.println("\nEnrolment details edited successfully! hit enter to proceed...");
                                    blank_input.nextLine();
                                    break;
                                }
                            default:
                                studentFlag = false;
                        }
                    }
                    //else-if is for the admin program flow only:
                    while(adminFlag){
                        selection = adminMenu();
                        switch(selection){
                            case 1:
                                if(studentList.toArray().length == 0){
                                    System.out.println("no students to display yet! please create some students first. hit enter to return...\n");
                                    blank_input.nextLine();
                                    break;
                                }
                                else {
                                    for (Student i : studentList) {
                                        i.displayDetails();
                                    }
                                    System.out.println("\nStudent details displayed successfully! hit enter to proceed...");
                                    blank_input.nextLine();
                                    break;
                                }
                            case 2:
                                for (Course i:courseList){
                                    i.displayDetails();
                                }
                                System.out.println("\nCourse details displayed successfully! hit enter to proceed...");
                                blank_input.nextLine();
                                break;
                            case 3:
                                courseList.add(newCourse());
                                System.out.println("\nNew course added successfully! hit enter to proceed...");
                                blank_input.nextLine();
                                break;
                            case 4:
                                editCourse();
                                System.out.println("\nCourse edited successfully! hit enter to proceed...");
                                blank_input.nextLine();
                                break;
                            case 5:
                                if(enrolList.toArray().length == 0){
                                    System.out.println("No enrolment records to display! Pleae create one, hit enter to proceed...");
                                    blank_input.nextLine();
                                    break;
                                }
                                else {
                                    for (Enrolment i : enrolList) {
                                        i.displayDetails();
                                    }
                                    System.out.println("\nEnrolment details displayed successfully! hit enter to proceed...");
                                    blank_input.nextLine();
                                    break;
                                }
                            default:
                                adminFlag = false;
                        }
                    }
                    break;
                default:
                    programFlag = false;
            }
        }
        System.out.println("program will exit...");
    }

/*
1.this class is for creating student users who will be part of the self defined User class.
2. User instances created are not equivalent to Student instances but are representations of their login accounts only
3. Further instantiation of student objects will be done in other methods but this method serves to allow only authorised users to login to the system
4. static keyword is used here because this method is used in a static context (main is a static method)
 */
    public static User newStudentUser(){
        String username, password;
        Scanner s = new Scanner(System.in);
        int selection;
        System.out.println("\nWelcome to the user account setup program! You are about to create a new student user");
        System.out.print("Enter your username: ");
        username = s.nextLine();
        System.out.print("Enter a password: ");
        password = s.nextLine();

        System.out.print("\033[H\033[2J");
        System.out.flush();
        return new User(username, password, "student");
    }

/*
1. Similar to the concept above, method catering solely for admin users
*/
    public static User newAdminUser(){
        String username, password;
        Scanner s = new Scanner(System.in);
        int selection;
        System.out.println("\nWelcome to the user account setup program! You are about to create a new admin user");
        System.out.print("Enter your username: ");
        username = s.nextLine();
        System.out.print("Enter a password: ");
        password = s.nextLine();

        System.out.print("\033[H\033[2J");
        System.out.flush();
        return new User(username, password, "admin");
    }

/*
1. this method is for the login procedure that will be called my the program
2. this function call utilises the User object method in the program to perform validation of credentials entered
*/
    public static boolean[] login(){
        int attempt = 1;
        int occupation_input,credentialCounter = 0;
        boolean credentialFlag = false;
        boolean occupationFlag = true; //student = true, admin = false
        String username_input, password_input, occupation_converted;
        Scanner s = new Scanner(System.in);

        System.out.print("\033[H\033[2J");
        System.out.flush();

        while(attempt < 4 && !credentialFlag) {
            System.out.println("User Login Attempt " + attempt);
            System.out.print("Username: ");
            username_input = s.nextLine();
            System.out.print("Password: ");
            password_input = s.nextLine();
            System.out.print("Press 1 if you are a student, else you are an admin: ");
            occupation_input = s.nextInt();
            s.nextLine();

            if(occupation_input == 1){
                occupationFlag = true;
                occupation_converted = "student";
            }
            else{
                occupationFlag = false;
                occupation_converted = "admin";
            }

            for(User i:userList){
                credentialCounter += i.credentialCheck(username_input, password_input, occupation_converted);
            }
            if(credentialCounter > 0){
                credentialFlag = true;
            }
            else{
                credentialFlag = false;
                attempt+=1;
            }
            System.out.println("\n");
        }
        boolean[] arr = {credentialFlag, occupationFlag};
        return arr;
    }

/*
1. this is the user menu displayed to admin users only
2. the page that they will revert to whenever they are return to the option selection flow
*/
    public static int adminMenu(){
        Scanner s = new Scanner(System.in);
        int selection;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome to the admin management system. Choose one option from below:");
        System.out.println("1. View Student Details");
        System.out.println("2. View Available Courses");
        System.out.println("3. Add Course");
        System.out.println("4. Edit Course");
        System.out.println("5. View Enrolment");
        System.out.println("6. Exit to login");
        System.out.print("\nMake a selection: ");
        selection = Integer.valueOf(s.nextLine());

        return selection;
    }

    public static int studentMenu(){
        Scanner s = new Scanner(System.in);
        int selection;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome "+userList.getFirst().getUsername()+", to the student management system! Choose one option from below:");
        System.out.println("1. Create Student");
        System.out.println("2. Edit Details");
        System.out.println("3. Display Details");
        System.out.println("4. View Available Courses");
        System.out.println("5. New Enrolment");
        System.out.println("6. View Enrolment");
        System.out.println("7. Edit Enrolment");
        System.out.println("8. Exit to login");
        System.out.print("\nMake a selection: ");
        selection = Integer.valueOf(s.nextLine());

        return selection;
    }



    public static Student newStudent(){
        String name, email, contactNumber;
        int studentID;
        Scanner s = new Scanner(System.in);
        System.out.println("\n------You are about to create a new student--------");
        System.out.print("Enter your name: ");
        name = s.nextLine();
        System.out.print("Enter your email: ");
        email = s.nextLine();
        System.out.print("Enter your contactNumber: ");
        contactNumber = s.nextLine();
        System.out.print("Enter your studentID (integer > 0 only): ");
        studentID = s.nextInt();

        return new Student(name, email, contactNumber, studentID);
    }

    public static Course newCourse(){
        Scanner s = new Scanner(System.in);
        String title, description, instructor;
        int code, paxMax;
        System.out.println("You are about to register a new course");
        System.out.print("Course title: ");
        title = s.nextLine();
        System.out.print("Course description: ");
        description = s.nextLine();
        System.out.print("Instructor for this course: ");
        instructor = s.nextLine();
        System.out.print("Course code (integer > 0 only) : ");
        code = Integer.valueOf(s.nextLine());
        System.out.print("Max. students allowed: ");
        paxMax = Integer.valueOf(s.nextLine());

        return new Course(title, description, instructor, code, paxMax);
    }

    public static Enrolment newEnrolment(){
        Scanner s = new Scanner(System.in);
        int selection;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\nYou are about to enrol in a course! Here are the available courses listed below");
        for(Course i:courseList){
            System.out.print("\nOption "+(courseList.indexOf(i) + 1)+" :");
            i.displayDetails();
        }

        System.out.print("\nMake a selection from the courses above: ");
        selection = s.nextInt();
        //this is for ensuring the selection corresponds to list index
        selection--;

        return new Enrolment(studentList.getFirst().getStudentID(), courseList.get(selection).getCourseCode(), "Enrolled");
    }

    public static void editCourse(){
        Scanner s = new Scanner(System.in);
        int selection;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\nYou are about to edit a course. Here are the available courses listed below");
        for(Course i:courseList){
            System.out.print("\nOption "+(courseList.indexOf(i) + 1)+" :");
            i.displayDetails();
        }

        System.out.print("\nMake a selection from the courses above: ");
        selection = s.nextInt();
        s.nextLine();
        //this is for ensuring the selection corresponds to list index
        selection--;
        courseList.get(selection).editMenu();
    }
}
