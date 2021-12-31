import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Joe Sheen
 * created 12/12/2017
 * Public class for creating an instance of a room within the hotel
 *
 */

public class Room {
	private List<Bed> listBeds = new ArrayList<Bed>();
	private boolean isRoomVacant;
	
	public Room() {
		setRoomVacant(true);
	}
	
	public void addBed(Bed bed) {
		listBeds.add(bed);
	}
	
	public List<Bed> getListBeds() {
		return listBeds;
	}
	
	public void setListBeds(List<Bed> listBeds) {
		this.listBeds = listBeds;
	}
	
	public boolean isRoomVacant() {
		return isRoomVacant;
	}
	
	public void setRoomVacant(boolean isRoomVacant) {
		this.isRoomVacant = isRoomVacant;
	}
}
