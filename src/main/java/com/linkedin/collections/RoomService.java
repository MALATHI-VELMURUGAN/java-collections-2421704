package com.linkedin.collections;

import java.util.*;

public class RoomService {

	private Collection<Room> inventory;

	public RoomService() {
		this.inventory = new LinkedHashSet<>();
	}
	
	public boolean hasRoom(Room room) {
		
	// 1. Returns a boolean that indicates if the Room Inventory contains a Room.
		if(inventory.contains(room)) return true;
		
		else return false;
	}
	
	public Room[] asArray() {
		
	// 2. Returns all Rooms as an Array of Rooms in the **order** they were Added.

		
		return inventory.toArray(new Room[0]);
	}
	
	public Collection<Room> getByType(String type){

	/*
	   3. Return a new Collection of Rooms where Room#type matches the provided String.
		  The original Room Inventory collection MUST NOT BE MODIFIED.
	*/
		Collection <Room> newInvertory = new HashSet<>();
		inventory.forEach(a->{if(a.getType()== type){
			newInvertory.add(a);
		}
		});

		return newInvertory;
		
	}

	public Collection<Room> getInventory() {
		return new HashSet<>(this.inventory); 
	}

	public void createRoom(String name, String type, int capacity, double price) {
		this.inventory.add(new Room(name, type, capacity, price));
	}

	public void createRooms(Room[] rooms) {
		this.inventory.addAll(Arrays.asList(rooms));
	}

	public void removeRoom(Room room) {
		this.inventory.remove(room);
	}

}
