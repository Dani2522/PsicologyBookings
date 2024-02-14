package ada.PsicologyBookings.domain.dto;


import ada.PsicologyBookings.domain.Entity.Appointment;
import ada.PsicologyBookings.domain.Entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDTO {
    private Long id;
    private BigDecimal price;
    private int amount;
    private Reservation reservation;
    private OffsetDateTime dateCreated;
    private OffsetDateTime lastUpdated;
    public Appointment toEntity() {
        Appointment appointment = new Appointment(this.id, this.price, this.amount,
                this.reservation, this.dateCreated, this.lastUpdated);
        return appointment;
    }
}
