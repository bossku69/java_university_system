import java.util.Scanner;
public class User {
    private String username, password, occupation;

    public User(String username, String password, String occupation){
        this.username = username;
        this.password = password;
        this.occupation = occupation;
    }

    public int credentialCheck(String username_input, String password_input, String occupation_converted){
        if(this.username.equals(username_input) && this.password.equals(password_input) && this.occupation.equals(occupation_converted)){
            return 1;
        }
        else{
            return 0;
        }
    }

    /*
    1. getter functions are used below to obtain private variables and data that is inaccessible directly by instances due to access control and scope
    2. this keyword represents the context of the object accessing the variable, where only the value associated with the particular instance is accessed here
    */
    public String getUsername(){
        return this.username;
    }

    public String getOccupation(){
        return this.occupation;
    }
}
