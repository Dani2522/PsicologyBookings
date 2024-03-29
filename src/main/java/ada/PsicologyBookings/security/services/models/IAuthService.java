package ada.PsicologyBookings.security.services.models;



import ada.PsicologyBookings.security.persistence.entities.UserEntity;
import ada.PsicologyBookings.security.services.models.dtos.LoginDTO;
import ada.PsicologyBookings.security.services.models.dtos.ResponseDTO;

import java.util.HashMap;

public interface IAuthService {

    public HashMap<String, String> login(LoginDTO loginRequest) throws Exception;
    public ResponseDTO register(UserEntity userEntity) throws Exception;
}
