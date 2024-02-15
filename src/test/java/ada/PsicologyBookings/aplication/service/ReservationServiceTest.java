package ada.PsicologyBookings.aplication.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import ada.PsicologyBookings.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ada.PsicologyBookings.domain.Entity.Reservation;
import ada.PsicologyBookings.domain.dto.ReservationDTO;
import ada.PsicologyBookings.domain.Entity.User;


class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllReservation() {
        // Given
        List<Reservation> reservations = new ArrayList<>();
        when(reservationRepository.findAll()).thenReturn(reservations);

        // When
        List<Reservation> result = reservationService.getAllReservation();

        // Then
        assertEquals(reservations, result);
    }

    @Test
    void testGetReservationtById() {
        // Given
        long id = 1;
        Reservation reservation = new Reservation();
        Optional<Reservation> optionalReservation = Optional.of(reservation);
        when(reservationRepository.findById(id)).thenReturn(optionalReservation);

        // When
        Reservation result = reservationService.getReservationtById(id);

        // Then
        assertEquals(reservation, result);
    }

    @Test
    void testCreateReservation() {
        // Given
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(1L);
        reservationDTO.setReservationDate(LocalDate.now());
        reservationDTO.setStartTime(LocalTime.now());
        reservationDTO.setEndTime(LocalTime.now());
        reservationDTO.setUser(new User());
        reservationDTO.setDateCreated(OffsetDateTime.now());

        // When
        ReservationDTO result = reservationService.createReservation(reservationDTO);

        // Then
        assertNotNull(result);
        assertEquals(reservationDTO, result);
    }

    @Test
    void testDeleteReservation() {
        // Given
        long id = 1;

        // When
        reservationService.deleteReservation(id);

        // Then
        verify(reservationRepository, times(1)).deleteById(id);
    }
}