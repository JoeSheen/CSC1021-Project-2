import java.util.Random;

/**
 * 
 * @author Joe Sheen
 * created 12/12/2017
 * Class used to test (not JUnit) that the classes used by the hotel 
 * management system works correctly
 *
 */

public class HotelTest {
	
	public static void main(String[] args) {
		// Variables used test hotel classes work correctly
		Random random = new Random();
		Hotel hotel = new Hotel("Caesars Palace");
		int numberOfRooms = 9;
		HotelReport report;
		
		// Creates and adds a set number of rooms to the hotel
		for(int i = 0; i < numberOfRooms; i++) {
			BedSize bedSize;
			hotel.addRoom();
			int randomNumberOfBeds = random.nextInt(5) + 1;
			// Populates the rooms with randomly allocated bed sizes
			for(int j = 0; j < randomNumberOfBeds; j++) {
				int randomBedSize = random.nextInt(2);
				if(randomBedSize == 1) {
					bedSize = BedSize.DOUBLE;
				} else {
					bedSize = BedSize.SINGLE;
				}
				hotel.getRoom(i).addBed(new Bed(bedSize));
			}
			// Sets the rooms vacancy if its at an odd index within hotel class
			if(i % 2 == 0) {
				hotel.getRoom(i).setRoomVacant(false);
			}
		}
		// Adds a final room that is always vacant and has 1 of each bed type
		hotel.addRoom();
		hotel.getRoom(numberOfRooms).addBed(new Bed(BedSize.SINGLE));
		hotel.getRoom(numberOfRooms).addBed(new Bed(BedSize.DOUBLE));
		hotel.setHasVacancies();
		// Prints hotel report
		report  = new HotelReport(hotel);
		report.printHotel();
	}

}
