package case_management.data.service;

import java.util.ArrayList;
import java.util.Collection;

import case_management.data.entities.DAOUser;
import case_management.data.entities.UserDTO;
import case_management.data.repositories.UserGroupsEntityRepository;
import case_management.data.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserGroupsEntityRepository userGroupsEntityRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private UserGroupService userGroupService;

    private String group;
    private int groupId;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        DAOUser user = userDao.findByUsername(username);
        System.out.println(user);
        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException(String.format("Username not found for username=%s",
                    username));

        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        groupId =  user.getGroupId();
        group = userGroupsEntityRepository.findTitleById(groupId);
        authorities.add(new SimpleGrantedAuthority(group));
        System.out.println("AUTHORITIES -----" + authorities);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);

    }

    public DAOUser save(UserDTO user) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setGroupId(2); // default role - user
        return userDao.save(newUser);

    }
}
