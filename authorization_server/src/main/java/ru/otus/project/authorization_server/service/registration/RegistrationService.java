package ru.otus.project.authorization_server.service.registration;

import ru.otus.project.authorization_server.domain.User;

public interface RegistrationService {
    User register(User newUser);
}
