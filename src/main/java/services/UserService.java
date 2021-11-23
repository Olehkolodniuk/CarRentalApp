package services;

import db.UserRepository;
import exceptions.UserAlreadyExistException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import validators.UserLoginValidator;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserLoginValidator userLoginValidator;

    @Autowired
    public UserService(UserRepository userRepository, UserLoginValidator userLoginValidator) {
        this.userRepository = userRepository;
        this.userLoginValidator = userLoginValidator;
    }
    public User addUser(User user){
        if(userLoginValidator.validate(user)){
            return userRepository.save(user);
        }
        throw new UserAlreadyExistException("User with this login already exist please choice another login");
    }
    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }
    public List<User> findAll(){
       return userRepository.findAll();
    }

}
