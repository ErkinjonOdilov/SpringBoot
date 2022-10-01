package com.example.forportfoliyo.service;

import com.example.forportfoliyo.model.Post;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private final RestTemplate restTemplate;//restTemplate inject qildim

    @Value("${api.jsonplaceholder}")
    private String api;

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Post> findAll(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<Post>> entity=new HttpEntity<>(headers);
        List<Post> result= restTemplate.exchange(this.api+"/posts", HttpMethod.GET, entity, List.class).getBody();
        return  result;
    }

}
