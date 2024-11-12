package web.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repositories.UserRepository;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserRepository userRepository;

   @Autowired
   public UserServiceImp(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Transactional
   @Override
   public void delete(User user) {
      userRepository.deleteById(user.getId());
   }

   @Transactional
   @Override
   public void edit(User user) {;
      userRepository.save(user);
   }

   @Override
   @Transactional(readOnly = true)
   public User getUser(Long id) {
      return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
   }

   @Transactional
   @Override
   public void add(User user) {
      userRepository.save(user);
   }

   @Transactional
   @Override
   public List<User> getListUsers() {
      return userRepository.findAll();
   }
}
