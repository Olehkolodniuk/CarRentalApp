package validators;

import db.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLoginValidator {
   private final UserRepository userRepository;

    @Autowired
    public UserLoginValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validate(User user){
        User actualUser = userRepository.findByLogin(user.getLogin());
        return actualUser == null || !actualUser.getLogin().equals(user.getLogin());
    }
}
