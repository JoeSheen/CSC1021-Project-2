/**
 * 
 * @author Joe Sheen
 * created 12/12/2017
 * Public class used to create bed objects for the hotel system
 *
 */

public class Bed {
	private BedSize bedSize;
	
	public Bed(BedSize bedSize) {
		setBedSize(bedSize);
	}
	
	public void setBedSize(BedSize bedSize) {
		this.bedSize = bedSize;
	}
	
	public BedSize getBedSize() {
		return bedSize;
	}
}
