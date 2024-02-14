package ada.PsicologyBookings.aplication.service;



import ada.PsicologyBookings.domain.Entity.User;

import ada.PsicologyBookings.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class   UserService{

    private final UserRepository userRepository;
    HashMap<String, Object> datos = new HashMap<>();
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //vista de usuarios@get
    public List<User> getUser() {
        return this.userRepository.findAll();
    }

    // vista de usuario por id
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    /// añadir usuarios@post
    public ResponseEntity<Object> newUser(User user) {
        Optional<User> res = userRepository.findByfullName(user.getFullName());


        if (res.isPresent()) {

            return new ResponseEntity<>(datos,
                    HttpStatus.CONFLICT);
        } else {
            User savedUser = userRepository.save(user);
            return new ResponseEntity<>(datos, HttpStatus.CREATED);
        }
    }



    /// actualizar@put
    public ResponseEntity<Object> updateUser(Long Id, User user) {
        Map<String, Object> datos = new HashMap<>();

        Optional<User> existingUserOptional = userRepository.findById(Id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setFullName(user.getFullName());
            existingUser.setReservations(user.getReservations());

            User updatedUser = userRepository.save(existingUser);
            datos.put("message", "Se actualizó con éxito");
            datos.put("data", updatedUser);
            return new ResponseEntity<>(datos, HttpStatus.OK);
        } else {
            datos.put("error", true);
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> delete(Long id){
        boolean existing= this.userRepository.existsById(id);
        if(!existing){
            datos.put("error", true);
            datos.put("massage", "No existe el usuario  ");
            return new ResponseEntity<>(datos,
                    HttpStatus.CONFLICT);
        }
        userRepository.deleteById(id);
        datos.put("massage", "Usuario eliminado   ");
        return new ResponseEntity<>(datos,
                HttpStatus.ACCEPTED);
    }

}
