package com.example.SpringAi_Movie;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class Services {
    @Value("${omdb.api.key}")
    private String apikey;
    @Value("${omdb.api.url}")
    private String apiurl;

    private final RestTemplate rs;

    public Services(RestTemplate rs) {
        this.rs = rs;
    }
    public MovieResponse Apires(String ss){
        ss = ss.replaceAll(" ","_");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiurl)
                .queryParam("apikey",apikey)
                .queryParam("t",ss);
//        System.out.println(builder.toUriString());
        System.out.println(rs.getForObject(builder.toUriString(),String.class));
        return rs.getForObject(builder.toUriString(),MovieResponse.class);
    }

}
