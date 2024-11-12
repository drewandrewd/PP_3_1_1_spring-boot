package web.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotEmpty(message = "Имя нужно заполнить")
   @Size(min = 2, max = 30, message = "Длина от 2 до 30 символов")
   @Column(name = "name")
   private String firstName;

   @NotEmpty(message = "Фамилию нужно заполнить")
   @Size(min = 2, max = 30, message = "Длина от 2 до 30 символов")
   @Column(name = "last_name")
   private String lastName;

   @NotEmpty(message = "Email нужно заполнить")
   @Email(message = "Ошибка в Email")
   @Column(name = "email", unique = true)
   private String email;

   public User() {}

   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, firstName, lastName, email);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      User user = (User) obj;
      return Objects.equals(id, user.id) &&
              Objects.equals(firstName, user.firstName) &&
              Objects.equals(lastName, user.lastName) &&
              Objects.equals(email, user.email);
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
