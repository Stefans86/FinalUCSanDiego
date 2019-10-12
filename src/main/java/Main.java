import java.util.ArrayList;



public class Main {
	public static void main(String[] args) {
		ArrayList<String> urls = Berrie.getAllBerriesURL();

		Berrie finalBerrie = new Berrie("", Integer.MIN_VALUE, Integer.MAX_VALUE);

		for (String url : urls) {
			Berrie berrie = new Berrie(url);
						
			if (berrie.growthTime  < finalBerrie.growthTime ||
				(berrie.growthTime  == finalBerrie.growthTime && berrie.size > finalBerrie.size)) {
				
				finalBerrie.name = berrie.name;
				finalBerrie.growthTime = berrie.growthTime;
				finalBerrie.size = berrie.size;
			}
		}
		
		System.out.println("The biggest Berry you can grow in shortest time is:");
		System.out.println("Named: " + finalBerrie.name);
		System.out.println("Growth time: " + finalBerrie.growthTime);
		System.out.println("Size: " + finalBerrie.size);
	}
}
