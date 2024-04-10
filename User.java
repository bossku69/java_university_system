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

    public String getUsername(){
        return this.username;
    }

    public String getOccupation(){
        return this.occupation;
    }
}
