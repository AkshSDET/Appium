package Test;

import org.testng.annotations.Test;

public class New_Post_Test extends BaseClass{

	@Test
	public void createpost() throws InterruptedException {
		Post.createpost();
	}
}
