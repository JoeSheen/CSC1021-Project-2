import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Joe Sheen
 * created 12/12/2017
 * Class used to create hotel object instances
 *
 */

public class Hotel {
	private String hotelName;
	private List<Room> listRooms = new ArrayList<Room>();
	private boolean hasVacancies;
	
	public Hotel(String name) {
		setHotelName(name);
	}
	
	public void setHotelName(String name) {
		this.hotelName = name;
	}
	
	public String getHotelName() {
		return hotelName;
	}
	
	public int getNumberOfRooms() {
		return listRooms.size();
	}
	
	public Room getRoom(int roomNumb) {
		return listRooms.get(roomNumb);
	}
	
	public void setHasVacancies() {
		for(Room room : listRooms) {
			if(room.isRoomVacant() == true) {
				this.hasVacancies = true;
			}
		}
	}
	
	public boolean getHasVacancies() {
		return hasVacancies;
	}
	
	public void addRoom() {
		Room newRoom = new Room();
		listRooms.add(newRoom);
	}
	
	public int maximumOccupancy() {
		int maxOccupancy = 0;
		for(Room room : listRooms) {
			for(Bed bed : room.getListBeds()) {
				if(bed.getBedSize().equals(BedSize.SINGLE)) {
					maxOccupancy += 1;
				} else {
					maxOccupancy += 2;
				}
			}
		}
		return maxOccupancy;
	}
}
