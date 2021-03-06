package db;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    <S extends User> S save(S entity);
    List<User> findAll();
    User findByLogin(String login);
}
