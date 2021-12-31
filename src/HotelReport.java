/**
 * 
 * @author Joe Sheen
 * created 12/12/2017
 * Report class used to print hotel detail to console
 *
 */

public class HotelReport {
	Hotel hotel;
	
	public HotelReport(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public void printHotel() {
		System.out.println("-----------------------------------------"); 
		System.out.println("------------- Hotel Report --------------"); 
		System.out.println("-----------------------------------------");
		System.out.println("Hotel Name: " + hotel.getHotelName());
		System.out.println("Total number of rooms: " + hotel.getNumberOfRooms());
		System.out.println("Maximum Occupancy: " + hotel.maximumOccupancy());
		if(hotel.getHasVacancies() == true) {
			System.out.println("Vacancies: Rooms available.");
		} else {
			System.out.println("Vacancies: No rooms available.");
		}
		System.out.println("-----------------------------------------");
		for(int i = 0; i < hotel.getNumberOfRooms(); i++) {
			System.out.println("Room " + (i+1) + " has " + hotel.getRoom(i).getListBeds().size() + " bed(s).");
			if(hotel.getRoom(i).isRoomVacant() == true) {
				System.out.println("Room is available.");
			} else {
				System.out.println("Room is unavailable.");
			}
			System.out.println("The bed(s) in this room are: ");
			for(int j = 0; j < hotel.getRoom(i).getListBeds().size(); j++) {
				System.out.println( "~ "+ hotel.getRoom(i).getListBeds().get(j).getBedSize().toString().toLowerCase());
			}
			System.out.println("-----------------------------------------");
		}
		System.out.println("------------------ End ------------------");
		System.out.println("-----------------------------------------");
	}
}
