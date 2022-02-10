package com.example.springmvc.ValidationAnnotations;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class User {

    @NotEmpty(message = "First name cannot be null and must have size greater than 0")
    private String firstName;

    @NotNull(message = "Second name must not be null, empty value/space can be considered")
    private String lastName;

    @NotBlank(message = "Username must not be null and must contain 1 or more characters")
    private String userName;;

    @AssertTrue
    private boolean working;

    @Min(value = 18, message = "Age must be greater than 18")
    @Max(value = 25, message = "Age must be smaller than 25")
    private int age;

    @Size(min = 10, max = 200,
            message = "About Me must be between 10 and 200 characters")
    private String aboutMe;

    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "^[a-zA-Z0-9]{6,10}$")
    private String password;

    @AssertTrue
    private boolean isWorking;

    @AssertFalse
    private boolean isStudent;

}
