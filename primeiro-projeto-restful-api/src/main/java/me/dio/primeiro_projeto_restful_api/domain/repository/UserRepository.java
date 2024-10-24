package me.dio.primeiro_projeto_restful_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.primeiro_projeto_restful_api.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
