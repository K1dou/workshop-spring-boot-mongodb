package com.marcelo.workshopmongo.dto;

import com.marcelo.workshopmongo.domain.Post;
import com.marcelo.workshopmongo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class AuthorDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = -7683287587878789650L;


    private String id;
    private String name;

    public AuthorDTO() {
    }
    public AuthorDTO(User obj) {

        id= obj.getId();
        name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}