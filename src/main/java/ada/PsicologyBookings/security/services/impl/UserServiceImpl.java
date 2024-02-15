package ada.PsicologyBookings.security.services.impl;


import ada.PsicologyBookings.security.persistence.DTO.UserDto;
import ada.PsicologyBookings.security.persistence.entities.UserEntity;
import ada.PsicologyBookings.security.persistence.repositories.IUserRepository;
import ada.PsicologyBookings.security.services.models.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public List<UserEntity> findAllUsers(){

        return iUserRepository.findAll();
    }
    @Override
    public Optional<UserEntity> newUser(UserDto userdto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userdto.getFirstname());
        userEntity.setLastName(userdto.getLastname());
        userEntity.setPhone(userdto.getPhone());
        userEntity.setEmail(userdto.getEmail());
        userEntity.setPassword(userdto.getPassword());
        return Optional.of(iUserRepository.save(userEntity));
    }
}
