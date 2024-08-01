package Test;

import org.testng.annotations.*;

public class Tag_People_Post_Test extends BaseClass {
	
	@Test
	public void postwithtag() throws Exception {
		Peoplepost.postwithtag();
	}

}
