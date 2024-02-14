package ada.PsicologyBookings.domain.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table (schema = "\"ventas\"", name = "\"Reservacion\"")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private AppointmentType appointmentType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha de reservacion")
    private LocalDate reservationDate;

    @DateTimeFormat(pattern = "HH:mm")
    @Column (name = "hora de inicio")
    private LocalTime startTime;

    @DateTimeFormat(pattern = "HH:mm")
    @Column (name = "hora fin")
    private LocalTime endTime;

    @OneToOne
    @JoinColumn(name = "producto_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Appointment appointment;


    @Column(name = "create_date", nullable = true)
    private OffsetDateTime dateCreated;

    @Column(name = "fecha_actualizacion", nullable = true)
    private OffsetDateTime lastUpdated;


    public Reservation(Long id, AppointmentType appointmentType, LocalDate reservationDate,
                       LocalTime startTime, LocalTime endTime,
                       User user, OffsetDateTime dateCreated, OffsetDateTime lastUpdated) {
        this.id = id;
        this.appointmentType = appointmentType;
        this.reservationDate = reservationDate;
        this.startTime = startTime;
        this.endTime = endTime;
//        this.user = user;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public Reservation() {
    }
}
