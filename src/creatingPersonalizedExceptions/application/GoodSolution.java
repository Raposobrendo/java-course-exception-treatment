package creatingPersonalizedExceptions.application;

import creatingPersonalizedExceptions.model.entities.GoodReservation;
import creatingPersonalizedExceptions.model.exceptions.DomainExceptions;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GoodSolution {
    public static void main(String[] Args){

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{
            System.out.print("Room number: ");
            Integer roomNumber = sc.nextInt();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            LocalDate checkIn = LocalDate.parse(sc.next(), fmt);

            System.out.print("Check-out date (dd/MM/yyyy): ");
            LocalDate checkOut = LocalDate.parse(sc.next(), fmt);


            GoodReservation reservation = new GoodReservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);


            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = LocalDate.parse(sc.next(), fmt);

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = LocalDate.parse(sc.next(), fmt);

            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
        }
        catch (DomainExceptions e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error.");
        }




        sc.close();
    }
}