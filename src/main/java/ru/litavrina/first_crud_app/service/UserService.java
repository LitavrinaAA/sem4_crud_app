package ru.litavrina.first_crud_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.litavrina.first_crud_app.model.User;
import ru.litavrina.first_crud_app.repository.UserRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
    public void updateById( User user) {
        userRepository.updateById(user);
    }

    //public void deleteById(int id)
}