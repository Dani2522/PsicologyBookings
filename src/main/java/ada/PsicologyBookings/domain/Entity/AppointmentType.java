package ada.PsicologyBookings.domain.Entity;

public enum AppointmentType {
   INDIVIDUALTHERAPY("Terapia Individual"), FAMILYTHERAPY("Terapia Familia"), COUPLETHERAPY("Terapia de Pareja");

    private final String name;

    private AppointmentType(String value) {
        name = value;
    }

    @Override
    public String toString() {
        return name;
    }
}
