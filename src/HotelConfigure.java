import java.util.Scanner;

/**
 * 
 * @author Joe Sheen
 * created 12/12/2017
 * Class used to create a hotel based on information provided by a user
 *
 */

public class HotelConfigure {

	public static void main(String[] args) {
		// Variables used in this main method
		Hotel hotel;
		HotelReport report;
		
		// Initial setup for this method and console output
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------- Hotel Configure -------------"); 
		System.out.println("Please enter the name of the hotel: ");
		hotel = new Hotel(scanner.nextLine());
		int numberOfRooms;
		
		// Handles setting the number of rooms in the hotel being configured
		while(true) {
			try {
				System.out.println("Please enter the number of hotel rooms: ");
				numberOfRooms = scanner.nextInt();
				if(numberOfRooms < 1) {
					System.err.println("The number of rooms in the hotel must be greater than 0.");
					scanner.nextLine(); // clears and resets scanner
				} else {
					break;
				}
			}
			catch(java.util.InputMismatchException e) { // handles the exception thrown if input is of the wrong type
				System.err.println("The number of rooms must be a whole number.");
				scanner.nextLine();// clears and resets scanner
			}
		}
		// Populates the rooms specified above
		for(int i = 0; i < numberOfRooms; i++) {
			hotel.addRoom();
			int numbSingleBeds = 0;
			int numbDoubleBeds = 0;
			String isRoomVacant = null;
			// Handles the creation of single beds in each room
			while(true) {
				try {
					System.out.println("Please enter the number of single beds in room " + (i+1) + ": ");
					numbSingleBeds = scanner.nextInt();
					if(numbSingleBeds < 0) {
						System.err.println("The number of single beds must be greater than 0.");
					} else {
						break;
					}
				} catch(java.util.InputMismatchException e) {
					System.err.println("The number of single beds should be a whole number.");
					scanner.nextLine(); // clears and resets scanner
				}
			}
			// Handles the creation of double beds in each room
			while(true) {
				try {
					System.out.println("Please enter the number of double beds in room " + (i+1) + ": ");
					numbDoubleBeds = scanner.nextInt();
					if(numbDoubleBeds < 0) {
						System.err.println("The number of double beds must be greater than 0.");
					} else {
						break;
					}
				} catch(java.util.InputMismatchException e) {
					System.err.println("The number of double beds should be a whole number.");
					scanner.nextLine(); // clears and resets scanner
				}
			}
			// Populates the room with the beds defined above
			for(int j = 0; j < numbSingleBeds; j++) {
				hotel.getRoom(i).addBed(new Bed(BedSize.SINGLE));
			}
			for(int j = 0; j < numbDoubleBeds; j++) {
				hotel.getRoom(i).addBed(new Bed(BedSize.DOUBLE));
			}
			// Asks the user if the room is vacant
			System.out.println("Is this room vacant? (yes or no).");
			isRoomVacant = scanner.next();
			if(isRoomVacant.substring(0, 1).toLowerCase().equals("y")) {
				hotel.getRoom(i).setRoomVacant(true);
			} else {
				hotel.getRoom(i).setRoomVacant(false);
			}
		}
		hotel.setHasVacancies();
		// Closes the scanner and prints hotel details to console
		scanner.close();
		report = new HotelReport(hotel);
		report.printHotel();
	}

}
