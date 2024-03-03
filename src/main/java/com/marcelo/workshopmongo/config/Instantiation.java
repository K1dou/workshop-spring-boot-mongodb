package com.marcelo.workshopmongo.config;

import com.marcelo.workshopmongo.domain.Post;
import com.marcelo.workshopmongo.domain.User;
import com.marcelo.workshopmongo.dto.AuthorDTO;
import com.marcelo.workshopmongo.dto.CommentDTO;
import com.marcelo.workshopmongo.repository.PostRepository;
import com.marcelo.workshopmongo.repository.UserRepository;
import com.marcelo.workshopmongo.resources.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        List<User> users= Arrays.asList(maria,alex,bob);
        userRepository.saveAll(users);

        Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",new AuthorDTO(alex));
        Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!",new AuthorDTO(bob));


        postRepository.saveAll(Arrays.asList(p1,p2));

        maria.getPosts().addAll(Arrays.asList(p1,p2));

        userRepository.save(maria);

       CommentDTO commentDTO = new CommentDTO("Boa viagem mano!",sdf.parse("21/03/2018"),new AuthorDTO(alex));
       CommentDTO commentDTO2 = new CommentDTO("Aproveite!",sdf.parse("22/03/2018"),new AuthorDTO(bob));
       CommentDTO commentDTO3 = new CommentDTO("Tenha um ótimo dia!",sdf.parse("23/03/2018"),new AuthorDTO(alex));





        p1.getComments().addAll(Arrays.asList(commentDTO,commentDTO2));
        p2.getComments().add(commentDTO3);

        postRepository.saveAll(Arrays.asList(p1,p2));



    }
}
