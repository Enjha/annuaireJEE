package mybootapp.web.security;

import org.springframework.stereotype.Service;

@Service("securityChecker")
public class SecurityChecker {

    public boolean isOk(String userName, String user) {
        return user.equals(userName);
    }

}