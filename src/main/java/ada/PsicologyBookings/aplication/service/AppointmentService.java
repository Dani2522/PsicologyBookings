package ada.PsicologyBookings.aplication.service;


import ada.PsicologyBookings.domain.Entity.Appointment;
import ada.PsicologyBookings.domain.dto.AppointmentDTO;
import ada.PsicologyBookings.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById (Long id) {
    Optional<Appointment> optionalReserva = appointmentRepository.findById(id);
    return optionalReserva.orElse(null);
    }

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        try {
            Optional<Appointment> existingBooking = appointmentRepository.findById(appointmentDTO.getId());
            if (existingBooking.isPresent()) {
                throw new IllegalStateException("Este ID de reserva ya se encuentra registrado");
            }
            // Guardar la nueva reserva
            appointmentRepository.save(appointmentDTO.toEntity());

            // Retorna la reserva creada
            return appointmentDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear la reserva: " + e.getMessage());
        }
    }

    public Appointment updateAppointment (Long id, AppointmentDTO appointmentDTO) {
    // Verificar si la reserva con el ID dado existe en la base de datos
        if (appointmentRepository.existsById(id)) {
        // Establecer el ID de la reserva proporcionada para garantizar que se actualice la reserva correcta
        appointmentDTO.setId(id);
        return appointmentRepository.save(appointmentDTO.toEntity());
    }
        return null; // cambiar para que retorne un mensaje de error
}

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
