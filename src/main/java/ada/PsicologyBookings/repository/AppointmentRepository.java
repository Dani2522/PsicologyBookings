package ada.PsicologyBookings.repository;


import ada.PsicologyBookings.domain.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository <Appointment, Long> {
}
