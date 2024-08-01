package Pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import Test.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class New_Post_Page  {

	AndroidDriver driver;	
	
	
	public New_Post_Page(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\"\"]") 
	static	WebElement btn_new_post;

	@FindBy(className = "android.widget.EditText") 
	WebElement enter_text;

	@FindBy(xpath ="//android.widget.TextView[@text=\"\"]")
	static WebElement btn_imageopener;

	@FindBy(xpath ="//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"]")
	static List <WebElement> imageselector;

	@FindBy(xpath ="//android.widget.TextView[@text=\"\"]")
	static 	WebElement btn_imageselector;

	@FindBy(xpath ="//android.widget.TextView[@text=\"New post\"]") 
	WebElement title;


	public void clickonAddbutton() throws InterruptedException {
		Thread.sleep(2000);
		btn_new_post.click();
	}

	public void checktitle() {
		String ExpectedTitle ="New post";
		String ActualTitle =title.getText();

		if(ExpectedTitle.equals(ActualTitle)){
			System.out.println("The Title of the page is as expected and it is " + ActualTitle);
		}
		else{
			BaseClass.takeScreenshot("FailedPostPageTitle");
			System.out.println("The Title of the page is not expected and it is "+ ActualTitle);	
		}
	}

	public void enterpostname() {
		try{
			enter_text.click();
			enter_text.sendKeys(BaseClass.props.getProperty("postname"));
		} catch(Exception e) {
			e.printStackTrace();
			Follow_Page.btn_changesitestopeople.click();
		}	
	}

	public static void selectimage() {

		try {
			Thread.sleep(2000);
			btn_imageopener.click();//TO open the Gallery

			Thread.sleep(2000);
			imageselector.get(0).click(); //To select the images
			btn_imageselector.click();// To click on the select button;
		} 
		catch(Exception e)
		{
			BaseClass.takeScreenshot("Failedselectimage");
			System.out.println("The image is not selectd");
			Follow_Page.btn_changesitestopeople.click();
		}
	}

	public void createpost() throws InterruptedException{
		clickonAddbutton();
		checktitle();
		enterpostname();
		selectimage();
	} 
}
