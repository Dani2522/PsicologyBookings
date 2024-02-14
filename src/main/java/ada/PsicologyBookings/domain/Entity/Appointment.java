package ada.PsicologyBookings.domain.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table (schema = "\"ventas\"",  name = "\"servicio\"")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "precio")
    private BigDecimal price;

    @Column(name = "cantidad")
    private int amount;

    @OneToOne(mappedBy = "appointment")
    private Reservation reservation;

    @CreatedDate
    @Column(name = "date_create")
    private OffsetDateTime dateCreated;

    public Appointment() {
    }

    @LastModifiedDate
    @Column(name = "fecha_ultimate")
    private OffsetDateTime lastUpdated;

    public Appointment(Long id, BigDecimal price, int amount, Reservation reservation, OffsetDateTime dateCreated, OffsetDateTime lastUpdated) {
        this.id = id;
        this.price = price;
        this.amount = amount;
        this.reservation = reservation;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }
}
