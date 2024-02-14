package ada.PsicologyBookings.aplication.controller;



import ada.PsicologyBookings.aplication.service.UserService;
import ada.PsicologyBookings.domain.Entity.User;
import ada.PsicologyBookings.domain.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
// buscar
    @GetMapping(path = "/view")
    public List<User> getUser(){
        return this.userService.getUser();
    }
//buscar por id
    @GetMapping(path = "search/{id}")
    public ResponseEntity<Object> getUserId(@PathVariable("id") long id){
        Optional<User> userOptional = userService.getUserById(id);
        return userOptional.<ResponseEntity<Object>>map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    // añadir usuario
    @PostMapping(path = "add")
    public ResponseEntity<Object> Add(@RequestBody User user){
        return  this.userService.newUser(user);
    }

    // actualizando
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Object> Update(@PathVariable Long id, @RequestBody User user){
        return this.userService.updateUser(id, user);
    }
 // borrar
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") long id){
        return  this.userService.delete(id);

    }

}