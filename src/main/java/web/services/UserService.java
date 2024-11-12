package web.services;


import web.models.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getListUsers();
    void delete(User user);
    void edit(User user);
    User getUser(Long id);
}
