package com.example.healthcare;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.standard.MediaSizeName;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;


@Controller
public class DoctorController {
    
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/new_doctor")
    public Doctor new_doctor() {
        System.out.println("hello");

        HttpHeaders headers = new HttpHeaders();
		List<MediaType> acceptTypes = new ArrayList<MediaType>();
		acceptTypes.add(MediaType.APPLICATION_JSON);
		headers.setAccept(acceptTypes);
        
        String url = "https://8080-kumquat-narwhal-6msaatvi.ws-us09.gitpod.io/api/finddoctors/?specialization=occology&city=pune";
        System.out.println(restTemplate.getForObject(url, String.class));
        HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
        System.out.println(restTemplate.exchange(url, HttpMethod.GET, entity, ResponseEntity.class).getBody());
         ResponseEntity<List<Doctor>> result = restTemplate.exchange(url, HttpMethod.GET, entity, ResponseEntity.class).getBody();
        System.out.println(restTemplate.exchange(url, HttpMethod.GET, entity, ResponseEntity.class).getBody());

    

       return result.getBody().get(0);
    }

    // @RequestMapping(path="/create_new_doctor",method=RequestMethod.POST)
    // public ModelAndView create_new_doctor(@Validated @ModelAttribute("doctor") Doctor doctor, BindingResult bindingResult,
    // @RequestParam String firstName,
    // @RequestParam String lastName,
    // @RequestParam String specialization,
    // @RequestParam String phoneNumber,
    // @RequestParam String address,
    // @RequestParam String city,
    // @RequestParam Integer pincode) {
    //     if (bindingResult.hasErrors()) {       
    //         System.out.println(bindingResult);
    //         ModelAndView modelAndView = new ModelAndView();
    //         modelAndView.setViewName("new_doctor");
    //         return modelAndView;
    //     }
    //     doctorRepository.save(new Doctor(doctor.getFirstName(), doctor.getLastName(), doctor.getSpecialization(), doctor.getPhoneNumber(), doctor.getAddress(), doctor.getCity(), doctor.getPincode()));
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("submit_doctor");
    //     modelAndView.addObject("firstName", firstName);
    //     modelAndView.addObject("lastName", lastName);
    //     modelAndView.addObject("specialization", specialization);
    //     modelAndView.addObject("phoneNumber", phoneNumber);
    //     modelAndView.addObject("address", address);
    //     modelAndView.addObject("city", city);
    //     modelAndView.addObject("pincode", pincode);

    //     return modelAndView;
    // }

    // @RequestMapping(path="/search_doctor_form",method=RequestMethod.GET)
    // public ModelAndView search_doctor_form() {
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("search_doctor_form");

    //     return modelAndView;
    // }

    // @RequestMapping(path="/search_doctor",method=RequestMethod.GET)
    // public ModelAndView search_doctor(@RequestParam String specialization, @RequestParam String city) {
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("search_doctor_result");
    //     modelAndView.addObject("doctors", doctorRepository.findBySpecializationAndCity(specialization, city));

    //     return modelAndView;
    // }

    // @RequestMapping(path = "/view_all_doctor/{page}", method = RequestMethod.GET)
    // public ModelAndView view_all_doctor(@PathVariable("page") Integer page) {
    //     Pageable pageable = PageRequest.of(page, 10);
    //     ModelAndView modelAndView = new ModelAndView();
    //     Page<Doctor> doctors = doctorRepository.findAll(pageable);
    //     modelAndView.setViewName("view_all_doctor");
    //     modelAndView.addObject("doctors", doctors.getContent());
    //     modelAndView.addObject("number", doctors.getNumber()+1);
    //     modelAndView.addObject("totalPages", doctors.getTotalPages());
    //     modelAndView.addObject("currentPage", page);
        
    //     return modelAndView;
    // }

    // @RequestMapping(value = "/edit1/{id}")
    // public ModelAndView showEditDoctorPage(@PathVariable(name = "id") String id) {
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("edit_doctor");
    //     modelAndView.addObject("doctor", doctorRepository.findById(id));
    //     modelAndView.addObject("id", id);

    //     return modelAndView;
    // }

    // @RequestMapping(value ="/update1/{id}",method=RequestMethod.POST)
    // public ModelAndView updatePatient(@ModelAttribute("doctor") Doctor doctor, @PathVariable String id) {
    //     Optional<Doctor> doctorData = doctorRepository.findById(id);
    //     Doctor _doctor = doctorData.get();
    //     _doctor.setFirstName(doctor.getFirstName());
    //     _doctor.setLastName(doctor.getLastName());
    //     _doctor.setSpecialization(doctor.getSpecialization());
    //     _doctor.setPhoneNumber(doctor.getPhoneNumber());
    //     _doctor.setAddress(doctor.getAddress());
    //     _doctor.setCity(doctor.getCity());
    //     _doctor.setPincode(doctor.getPincode());
    //     doctorRepository.save(_doctor);
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("submit_doctor");
    //     modelAndView.addObject("firstName", _doctor.getFirstName());
    //     modelAndView.addObject("lastName", _doctor.getLastName());
    //     modelAndView.addObject("specialization", _doctor.getSpecialization());
    //     modelAndView.addObject("phoneNumber", _doctor.getPhoneNumber());
    //     modelAndView.addObject("address", _doctor.getAddress());
    //     modelAndView.addObject("city", _doctor.getCity());
    //     modelAndView.addObject("pincode", _doctor.getPincode());
    
    //     return modelAndView;  
    // }
    
    // @RequestMapping(value = "/delete1/{id}")
    // public String deleteDoctor(@PathVariable(name = "id") String id) {
    //     doctorRepository.deleteById(id);

    //     return "redirect:/";       
    // }
    
}
