package mybootapp.web;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Component
@SessionScope
@Data
public class User {

    private String name;

    public User () {
        name = "Anonymous";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}