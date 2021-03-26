package com.motorsSmart.controllers;

import com.motorsSmart.domain.entities.User;
import com.motorsSmart.services.UserService;
import com.motorsSmart.utils.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Route.BASE + Route.USERS, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "${environmen.url.origins}", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = Route.GETALL)
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(Route.GETBY_ID)
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return new ResponseEntity<User>(userService.getByUserId(id), HttpStatus.OK);
    }

}
