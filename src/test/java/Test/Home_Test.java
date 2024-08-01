package Test;

import org.testng.annotations.*;

public class Home_Test extends BaseClass{

	@Test(priority=0)
	public void scroll() throws InterruptedException {
		home.scroll();
	}
	
	@Test(priority=1)
	public void checkTitle() {
		home.checktitle();
	}
	
	
}
