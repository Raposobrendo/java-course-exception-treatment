package creatingPersonalizedExceptions.application;

import creatingPersonalizedExceptions.model.entities.BadReservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VeryBadSolution {
    public static void main(String[] Args){

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number: ");
        Integer roomNumber = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), fmt);
        System.out.print("Check-out date (dd/MM/yyyy): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), fmt);
        if(!checkOut.isAfter(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        }
        else{
            BadReservation reservation = new BadReservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), fmt);
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), fmt);

            LocalDate now = LocalDate.now();
            if(checkIn.isBefore(now) || checkOut.isBefore(now)){
                System.out.println("Error in reservation: Reservation dates must be future dates.");
            }else if(!checkOut.isAfter(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date.");
            } else{
                reservation.updateDates(checkIn, checkOut);
                System.out.println(reservation);
            }
        }

        sc.close();
    }
}
