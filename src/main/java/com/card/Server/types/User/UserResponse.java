package com.card.Server.types.User;

import com.card.Server.Entity.User.Address;
import lombok.Data;

@Data
public class UserResponse {
    private String fName;
    private String lName;
    private String userName;
    private String userEmail;
    //private Address address;
    private String status;

}
