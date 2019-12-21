package sec.project.config;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sec.project.domain.Account;
import sec.project.repository.AccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

 @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        Account account = new Account();
        account.setUsername("ted");
        account.setPassword(passwordEncoder.encode("lol"));
        accountRepository.save(account);
        
        account = new Account();
        account.setUsername("aki");
        account.setPassword(passwordEncoder.encode("123"));
        accountRepository.save(account);
        
        System.out.println("luotu käyttäjät: " + accountRepository.findByUsername("ted") + "ja" + accountRepository.findByUsername("aki"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("No such user: " + username);
        }
        System.out.println("onnistui löytää käyttäjä");

        return new org.springframework.security.core.userdetails.User(
                account.getUsername(),
                account.getPassword(),
                true,
                true,
                true,
                true,
                Arrays.asList(new SimpleGrantedAuthority("USER")));
    }
}
 








//   private Map<String, String> accountDetails;

//    @PostConstruct
//    public void init() {
//        // this data would typically be retrieved from a database
//        this.accountDetails = new TreeMap<>();
//       // this.accountDetails.put("ted", "$2a$06$rtacOjuBuSlhnqMO2GKxW.Bs8J6KI0kYjw/gtF0bfErYgFyNTZRDm");
//       this.accountDetails.put("ted", "abc");
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if (!this.accountDetails.containsKey(username)) {
//            throw new UsernameNotFoundException("No such user: " + username);
//        }
//
//        return new org.springframework.security.core.userdetails.User(
//                username,
//                this.accountDetails.get(username),
//                true,
//                true,
//                true,
//                true,
//                Arrays.asList(new SimpleGrantedAuthority("USER")));
//    }
//}
