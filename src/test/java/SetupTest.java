import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.junit.Test;

public class SetupTest {

	@Test
	public void connectingTest() throws MalformedURLException, IOException {
		assertTrue(FoodPokFinder.connecting("https://pokeapi.co/api/v2/berry/").contains("count"));
		assertTrue(FoodPokFinder.connecting("https://pokeapi.co/api/v2/berry/1/").contains("size"));
		assertFalse(FoodPokFinder.connecting("https://pokeapi.co/api/v2/berry/").contains("size"));
		

	}

	@Test
	public void BerryToStringTest() {
		
		assertFalse("named: stefan,  growth time: 3, size: 65".equals(new Berry("banana", 3, 20).BerryToString()));
	}

	@Test
	public void gettingBerriesFromApiTest() throws MalformedURLException, IOException {
		assertEquals(new Berry("cheri", 3, 20).BerryToString(),
				FoodPokFinder.BerriesApi().get(0).BerryToString());
		assertNotEquals(new Berry("leppa", 4, 28).BerryToString(),
				FoodPokFinder.BerriesApi().get(20).BerryToString());

	}

	
	}

