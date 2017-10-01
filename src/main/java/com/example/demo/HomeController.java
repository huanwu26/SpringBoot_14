package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    DirectorRepository directorRepository;
    @RequestMapping("/")
    public String index(Model model)
    {
        Director director = new Director();
        director.setName("Stephen Bullock");
        director.setGenre("Sci Fi");

        Movie movie = new Movie();
        movie.setTitle("Star Wars");
        movie.setYear(2017);
        movie.setDescription("About Starwars....");
        director.addMovie(movie);

        movie = new Movie();
        movie.setTitle("Avatar");
        movie.setYear(2009);
        movie.setDescription("About Avatar....");
        director.addMovie(movie);

        directorRepository.save(director);
        model.addAttribute("directors", directorRepository.findAll());
        return "index";
    }
}
