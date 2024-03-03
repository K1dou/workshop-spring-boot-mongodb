package com.marcelo.workshopmongo.dto;

import com.marcelo.workshopmongo.domain.Post;
import com.marcelo.workshopmongo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class PostDTO implements Serializable
{


    @Serial
    private static final long serialVersionUID = -7683287587878789650L;


    private String id;
    private Date data;
    private String title;
    private String body;

    @Autowired
    private User author;
    public PostDTO() {
    }

    public PostDTO(Post obj,User author) {
        id = obj.getId();
        data = obj.getData();
        title = obj.getTitle();
        body = obj.getBody();
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
