package iss.nus.sg.day2.model;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    private String id;
    private String firstName;    
    private String lastName;
    
    public Person(String fistName, String lastName){
        this.id = UUID.randomUUID().toString().substring(0,8);
        this.firstName = fistName;
        this.lastName = lastName;
    }

    public Person(String id, String fistName, String lastName){
        this.id = id;
        this.firstName = fistName;
        this.lastName = lastName;
    }


}
