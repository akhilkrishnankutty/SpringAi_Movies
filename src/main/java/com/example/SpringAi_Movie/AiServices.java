package com.example.SpringAi_Movie;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AiServices {
    @Autowired
    Services ss;
   private final ChatClient chatClient;

    public AiServices(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public MovieResponse RandomMovie(){
        String promt = """
                Give me name of any random movie ,
                return me just movie name nothing else
                """;

        String response = chatClient.prompt(promt).call().content();
        int last_new = response.lastIndexOf("\n");
        response = response.substring(last_new+1);
        System.out.println("Ai Recommending:-"+response);
        return ss.Apires(response.replaceAll(" ","_"));
    }

    public MovieResponse getBygenre(String genre) {
        String promt = """
                Recommend me an movie of {ge} genre ,return me just one movie name nothing else
                """;
        PromptTemplate template = new PromptTemplate(promt);
        Prompt promt_t = template.create(Map.of("ge",genre));
        System.out.println(promt_t);
        String response = chatClient.prompt(promt_t).call().content();
        System.out.println(response);
        return ss.Apires(response.replaceAll(" ","_"));
    }
}
