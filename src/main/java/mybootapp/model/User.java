package mybootapp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.*;
import java.util.Set;

@Entity
@Component
@NoArgsConstructor
@AllArgsConstructor
@SessionScope
public class User {

    @Id
    String userName;

    @Basic
    String password;

    @ElementCollection(fetch = FetchType.EAGER)
    Set<String> roles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    /**
     * Méthode equals
     */

    public boolean equals(User user) {
        return (this.userName.equals(user.getUserName()));
    }
}