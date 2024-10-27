package me.dio.primeiro_projeto_restful_api.service;

import me.dio.primeiro_projeto_restful_api.domain.model.User;

public interface UserService {
    
    User findById(long id);

    User create (User userToCreate);
}
