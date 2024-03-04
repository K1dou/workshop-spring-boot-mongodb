package com.marcelo.workshopmongo.resources;

import com.marcelo.workshopmongo.domain.Post;
import com.marcelo.workshopmongo.domain.User;
import com.marcelo.workshopmongo.dto.UserDTO;
import com.marcelo.workshopmongo.resources.util.URL;
import com.marcelo.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findbyId(@PathVariable String id) {
        Post obj = postService.findById(id);

        return ResponseEntity.ok().body(obj);
    }


    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findbyTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = postService.fullSearch(text, min, max);

        return ResponseEntity.ok().body(list);
    }


}
