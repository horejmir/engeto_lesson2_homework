package com.engeto.lesson2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingsService {

    private int bookingId = 0;
    private final List<Room> rooms;
    private final List<Booking> bookings = new ArrayList<>();

    public BookingsService(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void createBooking(int roomId, LocalDate dateOfArrive, LocalDate dateOfDeparture, boolean isWorkingStay, Client ... client) {

        if (dateOfArrive.isAfter(dateOfDeparture) || dateOfArrive.isEqual(dateOfDeparture)){
            System.out.println("ERROR creating booking - wrong date of arrive or departure");
            return;
        }

        var optionalRoom = rooms
                            .stream()
                            .filter(r -> r.getId() == roomId)
                            .findFirst();

        if(optionalRoom.isEmpty()) {
            System.out.println("ERROR creating booking - invalid room number");
            return;
        }

        var room = optionalRoom.get();

        List<Client> clients = Arrays.stream(client).toList();

        if(clients.size() > room.getBedsInRoom() || clients.size() == 0){
            System.out.println("ERROR creating booking - selected room is too small for " + clients.size() + " guests");
            return;
        }


        for(Booking booking : bookings){
            if(booking.getRoom().getId() == roomId) {

                var errorMessage = "ERROR creating booking - room number " + roomId +" is already booked in this term";
                if((dateOfArrive.equals(booking.getDateOfArrive())
                        || dateOfArrive.isAfter(booking.getDateOfArrive())) && dateOfArrive.isBefore(booking.getDateOfDeparture())) {
                    System.out.println(errorMessage);
                    return;
                }

                if((dateOfDeparture.isAfter(booking.getDateOfArrive()) && (dateOfDeparture.isBefore(booking.getDateOfDeparture()))
                        || dateOfDeparture.equals(booking.getDateOfDeparture()))) {
                    System.out.println(errorMessage);
                    return;
                }

                if((dateOfArrive.isBefore(booking.getDateOfArrive()) && (dateOfDeparture.isAfter(booking.getDateOfDeparture())))) {
                    System.out.println(errorMessage);
                    return;
                }
            }
        }

        bookings.add(new Booking(++bookingId, room, clients, dateOfArrive, dateOfDeparture, isWorkingStay));
        System.out.println("DONE - booking #" + bookingId + " created!!");
    }

    public void createBooking(int roomId, Client ... client) {
        createBooking(roomId, LocalDate.now(), LocalDate.now().plusDays(6), false, client);
    }

    public void cencelBooking(int id) {
        if(bookings.removeIf(b -> b.getId() == id))
            System.out.println("DONE - booking #" +id+" cenceled!!");
    }

    public void printAllBookings() {
        System.out.println("LIST OF ALL BOOKINGS:");
        bookings.forEach(b -> System.out.println(b.getDescription()));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

}
