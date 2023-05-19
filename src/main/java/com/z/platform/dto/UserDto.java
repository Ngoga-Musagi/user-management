package com.z.platform.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;
    
    private String photos;
	
    @NotEmpty(message = "gender should not be empty")
	private String gender;
//    @NotNull(message = "dob should not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private String dob;
    @NotEmpty(message = "maritalStatus should not be empty")
	private String maritalStatus;
    @NotEmpty(message = "nationality should not be empty")
	private String nationality;
	
}
