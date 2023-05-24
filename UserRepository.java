package Notes.com.example.Notesdemo.repository;

import Notes.com.example.Notesdemo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {


}
