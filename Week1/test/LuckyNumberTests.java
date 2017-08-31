import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LuckyNumberTests {
	
	private LuckyNumber luckyNumber;
	@Before
	public void setUp() throws Exception {
		luckyNumber = new LuckyNumber();
	}

	@Test
	public void testLuckyNumber() {
		assertNotNull(luckyNumber);
	}
	
	@Test
	public void testGetLuckyNumber()
	{
		assertEquals(42, luckyNumber.getLuckyNumber());
	}

}
