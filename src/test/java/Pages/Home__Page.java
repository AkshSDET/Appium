package Pages;


import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Test.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class Home__Page {

	AndroidDriver driver;
	public Home__Page(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\"Demo Project\"]") 
	WebElement Page_title;

	public void checktitle() {
		String ExpectedTitle ="Demo Project";
		String ActualTitle =Page_title.getText();

		if(ExpectedTitle.equals(ActualTitle)){
			System.out.println("The Title of the page is as expected and it is " + ActualTitle);
		} else{
			BaseClass.takeScreenshot("FailedHomePageTitle");
			Assert.fail("The Title of the page is as expected and it is " + ActualTitle);
			New_Post_Page.btn_new_post.click();
		}
	}


	public void scroll() throws InterruptedException {

		Thread.sleep(3000);
		Dimension size = driver.manage().window().getSize();

		int startx = size.getWidth()/2;
		int starty = size.getHeight()/2;

		int endx = startx;
		int endy = (int)(size.getHeight() * 0.25);

		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200))) //wait for some time
				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endx, endy))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); 

		driver.perform(Collections.singletonList(sequence));
	}
}
