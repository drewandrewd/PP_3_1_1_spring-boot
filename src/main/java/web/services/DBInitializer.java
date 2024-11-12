package web.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.models.User;

@Component
public class DBInitializer {

    private final UserService userService;

    @Autowired
    public DBInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
    }
}
