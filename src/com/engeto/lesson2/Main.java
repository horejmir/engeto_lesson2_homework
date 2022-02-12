package com.engeto.lesson2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1, 1, true, true, new BigDecimal(1000)));
        rooms.add(new Room(2, 1, true, true, new BigDecimal(1000)));
        rooms.add(new Room(3, 3, false, true, new BigDecimal(2400)));

        System.out.println("hotel rooms:");
        rooms.forEach(r -> System.out.println(r.getDescription()));
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("clients:");
        var client1 = new Client("Adéla","Malíková", LocalDate.of(1993,3,13));
        System.out.println(client1.getDescription());
        var client2 = new Client("Jan","Dvořáček", LocalDate.of(1995,5,5));
        System.out.println(client2.getDescription());
        var client3 = new Client("Antonín","Karlíček", LocalDate.of(1982,8,1));
        System.out.println(client3.getDescription());
        System.out.println("------------------------------------------------------------------------------------");

        var bookingsService = new BookingsService(rooms);

        bookingsService.createBooking(3, LocalDate.of(2022,9,2), LocalDate.of(2022,9,1), false, client1, client2);
        bookingsService.createBooking(1, LocalDate.of(2022,9,2), LocalDate.of(2022,9,11), false, client1, client2);
        bookingsService.createBooking(4, LocalDate.of(2022,7,19), LocalDate.of(2022,7,26), false, client1, client2);
        bookingsService.createBooking(3, LocalDate.of(2022,7,19), LocalDate.of(2022,7,26), false, client1, client2);
        bookingsService.createBooking(3, LocalDate.of(2022,7,19), LocalDate.of(2022,9,14), false, client1, client2);
        bookingsService.createBooking(3, LocalDate.of(2022,8,27), LocalDate.of(2022,9,5), true, client1);
        bookingsService.createBooking(1, client3);
        bookingsService.createBooking(1, client1);
        bookingsService.createBooking(2, client1);
        bookingsService.cencelBooking(4);

        System.out.println("------------------------------------------------------------------------------------");
        bookingsService.printAllBookings();

    }
}
