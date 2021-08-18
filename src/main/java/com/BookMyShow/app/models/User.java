package com.BookMyShow.app.models;

import com.BookMyShow.app.exceptions.validations.PasswordLengthException;
import com.BookMyShow.app.exceptions.validations.UsernameLengthException;
import com.BookMyShow.app.models.services.utils.passwordEncoder.PasswordEncoder;
import com.BookMyShow.app.models.services.utils.passwordEncoder.PlainTextPasswordEncoder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class User extends Audit{
    //Authentication
    String username;
    String hashedSaltedPassword;

    //Authorization
    private Set<Role> role;

    public User(String username) {
        this.username = username;
    }

    public  void addRole(Role customerRole){
        this.role.add(customerRole);
    }
    //Validation
    public void setUsername(String username){
        if(username.length() < 3){
            throw new UsernameLengthException("Length must be greater than 3 letters");
        }

        this.username = username;
    }

    public void setPassword(String password , PasswordEncoder passwordEncoder){
        if(password.length() < 8){
            throw new PasswordLengthException("Password must have length greater than 8");
        }
        String salt = "Salt"; // generate salt
        this.hashedSaltedPassword =   passwordEncoder.encode(password+salt);
        this.hashedSaltedPassword += ';'+salt; // to store the salt with password

    }
    public boolean checkPassword(String password , PasswordEncoder passwordEncoder){
    // adding dependency injection here
        String salt = this.hashedSaltedPassword.split(";")[1]; // salt is stored as hashedpassword + ; salt , so we will fetch the salt first
        String encodedPassword =  passwordEncoder.encode(password+salt)+salt; // due to this step this.hashedSaltedPassword += ';'+salt;
        return encodedPassword.equals(this.getHashedSaltedPassword());

    }

}
