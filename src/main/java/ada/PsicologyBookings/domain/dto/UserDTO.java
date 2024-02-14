package ada.PsicologyBookings.domain.dto;


import ada.PsicologyBookings.domain.Entity.Reservation;
import ada.PsicologyBookings.domain.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String fullName;
    private int idUser;
    private String passwordHash;
    private Set<Reservation> reservations = new HashSet<>();
    private OffsetDateTime dateCreated;
    private OffsetDateTime lastUpdated;

    public User toEntity() {
        User user = new User(this.id, this.fullName,
                this.passwordHash, this.reservations,
                this.dateCreated, this.lastUpdated);
        return user;
    }
}
