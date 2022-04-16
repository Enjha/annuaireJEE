package mybootapp.web.security;

import mybootapp.manager.IDirectoryManager;
import mybootapp.model.User;
import mybootapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    private IDirectoryManager dm;


    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = dm.findOneByStringProperty(User.class, "userName", username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
}