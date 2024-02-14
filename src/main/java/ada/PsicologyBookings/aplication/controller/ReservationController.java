package ada.PsicologyBookings.aplication.controller;

import ada.PsicologyBookings.aplication.service.ReservationService;
import ada.PsicologyBookings.domain.Entity.Reservation;
import ada.PsicologyBookings.domain.dto.ReservationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path = "/All")
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getResevationById(@PathVariable Long id) {
        reservationService.getReservationtById(id);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
    @PostMapping(path = "/create")
    public ResponseEntity<?> createReservation (@RequestBody ReservationDTO reservationDTO) {
        reservationService.createReservation(reservationDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation (@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) {
        return reservationService.updateReservation(id, reservationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation (@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok("Se eliminó la reserva con el ID: " + id);
    }
}
