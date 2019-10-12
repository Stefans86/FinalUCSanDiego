
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		int id = BerryHelper.findMaxSizeBerry();
		System.out.println(BerryHelper.getBerry(id));
	}

}