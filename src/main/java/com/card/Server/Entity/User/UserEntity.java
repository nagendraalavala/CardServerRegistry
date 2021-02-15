package com.card.Server.Entity.User;

import com.card.Server.Validation.UserPasswordConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   // @JoinColumn(name = "iduser", insertable = false, updatable = false)
    private Long empId;

    @NotEmpty(message = "First Name Cannot be empty")
    private String fName;

    @NotEmpty(message = "Last Name Cannot be empty")
    private String lName;

    @NotEmpty(message = "Username Cannot be empty")
    @Column(unique = true)
    private String userName;

    @Email
    @NotEmpty(message = "Email cannot be empty")
    @Column(unique = true)
    private String userEmail;

    @UserPasswordConstraint(message = "Passoword cannot be Empty and must be Minimum eight characters, at least one letter, one number and one special character:")
    private String userPassword;

    @UserPasswordConstraint(message = "Passoword cannot be Empty and must be Minimum eight characters, at least one letter, one number and one special character:")
    private String userConfirmPassword;

//    @OneToOne
//    private Address address;


    private String status;

    private boolean isEnabled;


}
