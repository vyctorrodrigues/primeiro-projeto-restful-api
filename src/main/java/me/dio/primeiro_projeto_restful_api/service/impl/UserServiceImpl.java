package me.dio.primeiro_projeto_restful_api.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.primeiro_projeto_restful_api.domain.model.User;
import me.dio.primeiro_projeto_restful_api.domain.repository.UserRepository;
import me.dio.primeiro_projeto_restful_api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User findById(long id) {
        //ultilizando referebce method para criar uma nova instancia caso o Optional esteja vazio(NoSuchElementException::new)
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("this Account number already exist");
        }
        return userRepository.save(userToCreate);
    }
    
}
