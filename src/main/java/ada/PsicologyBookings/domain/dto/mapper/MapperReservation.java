package ada.PsicologyBookings.domain.dto.mapper;

import ada.PsicologyBookings.domain.Entity.Reservation;
import ada.PsicologyBookings.domain.dto.ReservationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperReservation {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Reservation.class, ReservationDTO.class);
        return modelMapper;
    }
}
