package com.linkedin.collections;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class GuestService {

	private List<Guest> checkinList = new ArrayList<>(100);

	public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {

		/*
		 *  1. Returns a new collection that contains guests from the provided collection
		 *  who have indicated the provided room as the first preference in their preferred
		 *  room list. 
		 */
		List <Guest> favRoomVsProvidedRoom = new ArrayList<>();
		favRoomVsProvidedRoom = guests.stream()
				.filter(g -> g.getPreferredRooms().indexOf(room) == 0)
				.collect(Collectors.toList());
		return favRoomVsProvidedRoom;

	}

	public void checkIn(Guest guest) {
		
		/*
		 *  2. Adds a guest to the checkinList, placing members of the loyalty program
		 *  ahead of those guests not in the program. Otherwise, guests are arranged in the
		 *  order they were inserted.
		 */
		if(guest.isLoyaltyProgramMember()){

			if(checkinList.isEmpty()){
				checkinList.add(guest);
			}else {
				int index=0;
				for (Guest g: checkinList) {
					if (!g.isLoyaltyProgramMember()){
						index =checkinList.indexOf(g);
						break;
					}
				}
				checkinList.add(index, guest);
			}

		}else{
			checkinList.add(guest);
		}

	}
	
	public void swapPosition(Guest guest1, Guest guest2) {
		
		/*
		 *  3.  Swaps the position of the two provided guests within the checkinList.
		 *  If guests are not currently in the list no action is required.
		 */
		int index1 = checkinList.indexOf(guest1);
		int index2 = checkinList.indexOf(guest2);
		if(checkinList.containsAll(List.of(guest1,guest2))){
			checkinList.set(index1, guest2);
			checkinList.set(index2,guest1);
		}

	}

	public List<Guest> getCheckInList() {
		return List.copyOf(this.checkinList);
	}
}
