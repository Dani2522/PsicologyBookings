package ada.PsicologyBookings.aplication.controller;


import ada.PsicologyBookings.aplication.service.AppointmentService;
import ada.PsicologyBookings.domain.Entity.Appointment;
import ada.PsicologyBookings.domain.dto.AppointmentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private  final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @GetMapping (path = "/all")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Optional<Appointment> getAppointmentById(@PathVariable Long id) {
        return Optional.ofNullable(appointmentService.getAppointmentById(id));

    }
    @PostMapping ("/create")
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.createAppointment(appointmentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody AppointmentDTO updateAppointment) {
       return appointmentService.updateAppointment(id, updateAppointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok("Se eliminó la usuario con el ID: " + id);
    }
}
