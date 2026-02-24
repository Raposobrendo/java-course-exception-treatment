package creatingPersonalizedExceptions.model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BadReservation {

    private final static DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public BadReservation() {
    }

    public BadReservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public Integer duration(){
        return Math.toIntExact(ChronoUnit.DAYS.between(checkIn, checkOut));
    }

    public String updateDates(LocalDate checkIn, LocalDate checkOut){

        LocalDate now = LocalDate.now();
        if(checkIn.isBefore(now) || checkOut.isBefore(now)){
            return "Reservation dates must be future dates.";
        }
        if(!checkOut.isAfter(checkIn)){
            return "Error in reservation: Check-out date must be after check-in date.";
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;

        return null;
    }

    @Override
    public String toString(){
        return "Reservation: Room " + roomNumber + ", check-in: " + FMT.format(checkIn) + ", check-out: " + FMT.format(checkOut) + ", " + duration() + " nights";
    }

}
