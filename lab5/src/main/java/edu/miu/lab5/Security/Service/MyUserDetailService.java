package edu.miu.lab5.Security.Service;

import edu.miu.lab5.Entity.User;
import edu.miu.lab5.Repository.UserRepo;
import edu.miu.lab5.Security.Model.MyUserDetails;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@Transactional
public class MyUserDetailService implements UserDetailsService {
    private final UserRepo userRepo;;

    public MyUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        return new MyUserDetails(user);
    }
}
