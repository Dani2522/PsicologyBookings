package ada.PsicologyBookings.domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table ( schema = "\"ventas\"",name= "\"Usuario\"")
public class User {
    public User() {
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "nombre")
    private String fullName;
    @Column(name = "documento")
    private int idUser;

    @Column (name = "contraseña")
    private String passwordHash;

    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations = new HashSet<>();

    @Column(name = "createdate")
    private OffsetDateTime dateCreated;

    @Column(name = "ultmitate")
    private OffsetDateTime lastUpdated;



    public User(Long id, String fullName,
                String passwordHash, Set<Reservation> reservations,
                OffsetDateTime dateCreated, OffsetDateTime lastUpdated) {

        this.id = id;
        this.fullName = fullName;
        this.passwordHash = passwordHash;
        this.reservations = reservations;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }
}
