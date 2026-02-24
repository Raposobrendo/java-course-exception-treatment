package creatingPersonalizedExceptions.model.entities;

import creatingPersonalizedExceptions.model.exceptions.DomainExceptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class GoodReservation {

    private final static DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public GoodReservation() {
    }

    public GoodReservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainExceptions {
        if(!checkOut.isAfter(checkIn)){
            throw new DomainExceptions("Error in reservation: Check-out date must be after check-in date.");
        }
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

    public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainExceptions{

        LocalDate now = LocalDate.now();
        if(checkIn.isBefore(now) || checkOut.isBefore(now)){
            throw new DomainExceptions("Reservation dates must be future dates.");
        }
        if(!checkOut.isAfter(checkIn)){
            throw new DomainExceptions("Error in reservation: Check-out date must be after check-in date.");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        return "Reservation: Room " + roomNumber + ", check-in: " + FMT.format(checkIn) + ", check-out: " + FMT.format(checkOut) + ", " + duration() + " nights";
    }

}
