package ru.otus.project.authorization_server.service.user_details;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.otus.project.authorization_server.model.RehearsalBaseUser;
import ru.otus.project.authorization_server.repository.UserRepository;

@Service
@Primary
@RequiredArgsConstructor
public class RehearsalBaseUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        System.out.println("HERE WITH " + phone);

        return
            repository
                .findUserByPhone(phone)
                .map(user -> {
                    System.out.println("USER FOUND " + user);

                    return new RehearsalBaseUser(user);
                })
                .orElseThrow(
                    () -> new UsernameNotFoundException(String.format("User with phone %s not found", phone))
                );
    }
}
