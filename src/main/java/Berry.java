public class Berry {
	String BerryName;
	int BerryGrowTime;
	int BerrySize;

	public Berry(String name, int growTime, int size) {
		super();
		this.BerryName = name;
		this.BerryGrowTime = growTime;
		this.BerrySize = size;

	}

	public String BerryToString() {
		return "\n Named: " + this.BerryName  + "\n Growth time: " + Integer.toString(this.BerryGrowTime)+ " days" + "\n Size: "
				+ Integer.toString(this.BerrySize) + " inches";
	}

}