package com.marcelo.workshopmongo.services;

import com.marcelo.workshopmongo.domain.User;
import com.marcelo.workshopmongo.dto.UserDTO;
import com.marcelo.workshopmongo.repository.UserRepository;
import com.marcelo.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        try {
            return repo.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Id nao encontrado!");
        }
    }

    public User insert(User obj){
        return repo.insert(obj);
    }
    public User fromDTO(UserDTO objDTO){

        return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());

    }

    public void delete(String id){
        repo.findById(id);
        repo.deleteById(id);

    }


}
