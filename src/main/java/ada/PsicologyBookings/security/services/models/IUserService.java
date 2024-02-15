package ada.PsicologyBookings.security.services.models;



import ada.PsicologyBookings.security.persistence.DTO.UserDto;
import ada.PsicologyBookings.security.persistence.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<UserEntity> findAllUsers();

    Optional<UserEntity> newUser(UserDto userRegistration);
}
