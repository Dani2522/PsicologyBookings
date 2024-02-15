package ada.PsicologyBookings.security.controllers;

import ada.PsicologyBookings.security.persistence.DTO.UserDto;
import ada.PsicologyBookings.security.persistence.entities.UserEntity;
import ada.PsicologyBookings.security.services.models.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/user")
public class RegistroController {

    @Autowired
    IUserService userService;

    @GetMapping("/all")
    private ResponseEntity<List<UserEntity>> getAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Object> createUser(@RequestBody UserDto userRegistration) {
        Optional<UserEntity> newUser = userService.newUser(userRegistration);

        if (newUser.isPresent()) {
            return new ResponseEntity<>(newUser.get(), HttpStatus.CREATED);
        } else {

            return new ResponseEntity<>("No se pudo crear el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

