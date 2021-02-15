package com.card.Server.types.User;

import com.card.Server.Entity.User.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String fName;
    private String lName;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userConfirmPassword;
    //private Address address;
}
