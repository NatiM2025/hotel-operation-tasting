package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    void newRoomIsAvailable(){
        Room room = new Room(2,100);
        assertTrue(room.isAvailable());
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
    }
    @Test
    void checkInRoomOccupiedAndDirty(){
        Room room =new Room(2,100);
        room.checkIn();
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
        assertFalse(room.isAvailable());
    }
    @Test
    void checkOutRoomDirtyNotOccupied(){
        Room room =new Room(2,100);
        room.checkIn();
        room.checkOut();
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
        assertFalse(room.isAvailable());
    }
    @Test
    void cleanRoomAfterCheckOutMakesRoomAvailable(){
        Room room =new Room(2,100);
        room.checkIn();
        room.checkOut();
        room.cleanRoom();

        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
        assertTrue(room.isAvailable());
    }
}