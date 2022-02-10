package com.engeto.lesson2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;


public class Booking {

    private int id;
    private Room room;
    private List<Client> clients;
    private LocalDate dateOfArrive;
    private LocalDate dateOfDeparture;
    private boolean isWorkingStay;

    public Booking(int id, Room room, List<Client> clients, LocalDate dateOfArrive, LocalDate dateOfDeparture, boolean isWorkingStay) {
        this.id = id;
        this.room = room;
        setClients(clients);
        this.dateOfArrive = dateOfArrive;
        this.dateOfDeparture = dateOfDeparture;
        this.isWorkingStay = isWorkingStay;
    }

    public Booking(int id, Room room, List<Client> clients) {
        this(id, room, clients, LocalDate.now(), LocalDate.now().plusDays(6), false);
    }

    public String getDescription() {

        var out = "* BOOKING #" + id + " | term: " + dateOfArrive
                + " - " + dateOfDeparture + " | " + ((isWorkingStay) ? "working stay" : "holiday stay") + " | total price: "
                + (room.getPrice().multiply(BigDecimal.valueOf(DAYS.between(dateOfArrive, dateOfDeparture)))) + "Kč"
                + "\n > " + room.getDescription();

        for (Client client : clients)
            out += "\n  - " + client.getDescription();

        return out;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", room=" + room +
                ", clients=" + clients +
                ", dateOfArrive=" + dateOfArrive +
                ", dateOfDeparture=" + dateOfDeparture +
                ", isWorkingStay=" + isWorkingStay +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {

        int bedsInRoom = this.room.getBedsInRoom();

        if(clients.size() <= bedsInRoom)
            this.clients = clients;
        else
            this.clients = clients.subList(0, bedsInRoom);
    }

    public LocalDate getDateOfArrive() {
        return dateOfArrive;
    }

    public void setDateOfArrive(LocalDate dateOfArrive) {
        this.dateOfArrive = dateOfArrive;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public boolean isWorkingStay() {
        return isWorkingStay;
    }

    public void setWorkingStay(boolean workingStay) {
        isWorkingStay = workingStay;
    }
}
