package ada.PsicologyBookings.aplication.service;

import ada.PsicologyBookings.domain.Entity.Reservation;
import ada.PsicologyBookings.domain.dto.ReservationDTO;
import ada.PsicologyBookings.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReservationService {


        private final ReservationRepository reservationRepository;

        public ReservationService(ReservationRepository reservationRepository) {
            this.reservationRepository = reservationRepository;
        }

        public List<Reservation> getAllReservation() {

            return reservationRepository.findAll();
        }

        public Reservation getReservationtById(Long id) {
            Optional<Reservation> optionalReserva = reservationRepository.findById(id);
            return optionalReserva.orElse(null);
        }

        public ReservationDTO createReservation(ReservationDTO reservationDTO) {
            try {
                Optional<Reservation> existingBooking = reservationRepository.findById(reservationDTO.getId());
                if (existingBooking.isPresent()) {
                    throw new IllegalStateException("Este ID de reserva ya se encuentra registrado");
                }
                // Guardar la nueva reserva
                reservationRepository.save(reservationDTO.toEntity());

                // Retorna la reserva creada
                return reservationDTO;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Error al crear la reserva: " + e.getMessage());
            }
        }

        public Reservation updateReservation(Long id, ReservationDTO reservationDTO) {
            // Verificar si la reserva con el ID dado existe en la base de datos
            if (reservationRepository.existsById(id)) {
                // Establecer el ID de la reserva proporcionada para garantizar que se actualice la reserva correcta
                reservationDTO.setId(id);
                return reservationRepository.save(reservationDTO.toEntity());
            }
            return null; // Retornar null si la reserva no existe
        }

        public void deleteReservation(Long id) {
            reservationRepository.deleteById(id);
        }
    }


