package com.example.SpringAi_Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class Controller {
    @Autowired
    Services ss;

    @Autowired
    AiServices ai;
    @PostMapping("bytitle")
    public MovieResponse getdata(@RequestBody String title){
        System.out.println(title);
        return ss.Apires(title);
    }
    @GetMapping("random")
    public MovieResponse getRandom(){
        return ai.RandomMovie();
    }
}
