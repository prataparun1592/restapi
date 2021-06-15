package com.example.healthcare;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;


@Controller

@RequestMapping("/new_doctor")
public class DoctorController {
    
    @Autowired
   
   // public Doctor new_doctor() {
        // System.out.println("hello");

        // HttpHeaders headers = new HttpHeaders();
		// List<MediaType> acceptTypes = new ArrayList<MediaType>();
		// acceptTypes.add(MediaType.APPLICATION_JSON);
		// headers.setAccept(acceptTypes);
        
        // String url = "https://8080-kumquat-narwhal-6msaatvi.ws-us09.gitpod.io/api/finddoctors/?specialization=occology&city=pune";
        // System.out.println(restTemplate.getForObject(url, String.class));
        // // HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
        // // System.out.println(restTemplate.exchange(url, HttpMethod.GET, entity, ResponseEntity.class).getBody());
        // // ResponseEntity<List<Doctor>> result = restTemplate.exchange(url, HttpMethod.GET, entity, ResponseEntity.class).getBody();
        // // System.out.println(restTemplate.exchange(url, HttpMethod.GET, entity, ResponseEntity.class).getBody());
        //  return "result";


         private static final String GET_new_doctor = "https://8080-kumquat-narwhal-6msaatvi.ws-us09.gitpod.io/api/finddoctors/?specialization=occology&city=pune";
         static RestTemplate restTemplate = new RestTemplate();

         private static void new_doctor(){
             HttpHeaders headers = new HttpHeaders();
             headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
             HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
             ResponseEntity<String> result = restTemplate.exchange(GET_new_doctor, HttpMethod.GET, entity, String.class);
             System.out.println(result);
         }
    }

