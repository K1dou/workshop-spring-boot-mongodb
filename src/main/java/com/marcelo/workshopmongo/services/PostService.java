package com.marcelo.workshopmongo.services;

import com.marcelo.workshopmongo.domain.Post;
import com.marcelo.workshopmongo.domain.User;
import com.marcelo.workshopmongo.repository.PostRepository;
import com.marcelo.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id) {
        try {
            return postRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Id nao encontrado!");
        }
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }






}
