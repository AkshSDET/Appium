package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class Tag_People_Post {

	AndroidDriver driver;
	public Tag_People_Post(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Posts\"]/android.view.ViewGroup") 
	static WebElement btn_changepagetopost;

	@FindBy(xpath = "//android.widget.TextView[@text=\"\"]") 
	WebElement btn_new_post;

	@FindBy(className ="android.widget.EditText") 
	WebElement enter_text;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Mia\"]") 
	WebElement tag_people;

	public void clickonpost() {
		try {
			btn_changepagetopost.click();
		}catch(Exception e) {
			e.printStackTrace();
			BaseClass.takeScreenshot("Failed_click_pagewithtag");
		}

	}

	public void clickonadd() {
		try {
			btn_new_post.click();
		}catch(Exception e) {
			e.printStackTrace();
			BaseClass.takeScreenshot("Failed_click_ontextbox");
		}
	}

	public void enterpostname() {
		try {
			enter_text.click();
			enter_text.sendKeys("Fun with @");
		}
		catch(Exception e) {
			e.printStackTrace();
			BaseClass.takeScreenshot("Failed_enter_postname");
		}
	}

	public void tagpeople() {
		try {
			tag_people.click();
		}
		catch(Exception e) {
			e.printStackTrace();
			BaseClass.takeScreenshot("Failed_tag_people");
		}
	}

	public void postwithtag() throws Exception {
		clickonpost();
		clickonadd();
		enterpostname();
		tagpeople();
		New_Post_Page.selectimage();
		System.out.println("Post with tag feature is also working fine");
	}
}
