package ada.PsicologyBookings.domain.dto;


import ada.PsicologyBookings.domain.Entity.Appointment;
import ada.PsicologyBookings.domain.Entity.AppointmentType;
import ada.PsicologyBookings.domain.Entity.Reservation;
import ada.PsicologyBookings.domain.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDTO {

    private Long id;
    private AppointmentType appointmentType;
    private LocalDate reservationDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private User user;
    private Appointment appointment;
    private OffsetDateTime dateCreated;
    private OffsetDateTime lastUpdated;

    public Reservation toEntity() {
        Reservation reservation = new Reservation(this.id,this.appointmentType, this.reservationDate,
                this.startTime, this.endTime,
                this.user, this.dateCreated, this.lastUpdated);
        return reservation;
    }

}
