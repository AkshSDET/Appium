package Test;

import org.testng.annotations.*;

public class Follow_Test extends BaseClass {

	
	@Test(priority=0)
	public void searchpeople() throws Exception {
		follow.seachfeature();
	}
	@Test(priority=1)
	public void followpeople() throws Exception{
		follow.followpeople();
	}
}
