package org.ChenYuepan.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //look at table
    private int id;

    private String username;

    private String password;

    private String email;

    private String gender;

    private String birthDay;

}
