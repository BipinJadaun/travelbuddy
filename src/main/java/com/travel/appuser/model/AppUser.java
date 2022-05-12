package com.travel.appuser.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.validation.ValidEmail;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document("user")
public class AppUser {

    @Id
    @NotBlank
    private String userId;

    @NotBlank
   // @JsonIgnore //to ignore returning password in the responses
    private String password;

   // @JsonIgnore
    private boolean isActive;

    private List<String> roles;

    @NotBlank
    private String fullName;

    @NotBlank
    @Size(min = 10, max = 10)
    private String phoneNo;

    @NotBlank
    @ValidEmail
    private String mailId;

    @NotNull
    private Date birthDate;

    private double walletMoney;

    public AppUser(String userId, String password, String fullName, String phoneNo, String mailId, Date birthDate) {
        this.userId = userId;
        this.password = password;
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.mailId = mailId;
        this.birthDate = birthDate;
        this.roles = new ArrayList<>();
    }
}
