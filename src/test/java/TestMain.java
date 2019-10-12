import static org.junit.Assert.*;
import java.io.*;
import org.junit.*;

public class TestMain {
	private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testCase1() {
        final String testString = "The biggest Berry you can grow in shortest time is:\n" + 
        		"Named: razz\n" + 
        		"Growth time: 2\n" + 
        		"Size: 120\n";
        
        //provideInput(testString);

        Main.main(new String[0]);

        assertEquals(testString, getOutput());
    }

}
