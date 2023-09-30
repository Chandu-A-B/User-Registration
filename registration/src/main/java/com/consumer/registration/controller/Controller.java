package com.consumer.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.registration.model.User;
import com.consumer.registration.model.UserCredentials;
import com.consumer.registration.repository.Repository;
import com.consumer.registration.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin("*")
public class Controller {
	
	@Autowired
	private Repository userRepo;
	
	@Autowired
	private PasswordEncoder encode;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
//	@GetMapping("/hello")
//    public String hello() {
//        return "hello world!";
//    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserCredentials user) throws Exception{
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        if (!authentication.isAuthenticated()) {
            throw new UsernameNotFoundException("invalid user request !");
        }

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }




    @DeleteMapping("/del/{name}")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> DeleteById(@PathVariable String name){
        userRepo.deleteById(name);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @PatchMapping("/edit/{name}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<User> UpdateFindById(@RequestBody User user,@PathVariable String name){
        User use=userRepo.findById(name).get();
        use.setEmail(user.getEmail());
        use.setFirstName(user.getFirstName());
        use.setLastName(user.getLastName());
        use.setRole(user.getRole());
        use.setPassword(user.getPassword());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userRepo.save(use));
    }
    
    
    
    @GetMapping("/user/{name}")
    public ResponseEntity<User> FindById(@PathVariable String name){
    	return ResponseEntity.status(HttpStatus.ACCEPTED).body(userRepo.findById(name).orElse(null));
    }
    
    

    @GetMapping("/all")
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<User>> FindAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userRepo.findAll());
    }
    
    
}
