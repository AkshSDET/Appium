package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.BaseClass;
import io.appium.java_client.android.AndroidDriver;

public class Follow_Page {

	public AndroidDriver driver;
	public Follow_Page(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"People\"]/android.view.ViewGroup") 
	static WebElement btn_changesitestopeople;

	@FindBy(xpath = "//android.widget.EditText[@text=\"Search Items\"]") 
	WebElement txtbox_search;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Mia Moore\"]") 
	WebElement filtered_search;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Follow\"]") 
	List <WebElement> btn_follow;
	
	public void clickonpeople() {
		try {
			Thread.sleep(2000);
			btn_changesitestopeople.click();
			System.out.println("People page is displayed");

		}catch(Exception e) {
			BaseClass.takeScreenshot("FailedPeoplePage");
			System.out.println("People page is not displayd");
		}
	}
	
	public void seachpeople() throws Exception {

		Thread.sleep(2000);
		txtbox_search.sendKeys(BaseClass.props.getProperty("filtername"));
		String Expetedresult =BaseClass.props.getProperty("filtername");
		String Actualresult =filtered_search.getText();

		if(Expetedresult.equals(Actualresult)){
			System.out.println("Filter is woring fine");
		}else{
			BaseClass.takeScreenshot("FailedSearchFeature");
			System.out.println("Filter is not working as expected we are exepcting" + Expetedresult +" and found " + Actualresult );
		}
	}

	public void clickonfollow() {
		try {
			Thread.sleep(2000);
			btn_follow.get(0).click();
			System.out.println("Follow is woring fine");
		}
		catch(Exception e) {
			BaseClass.takeScreenshot("FailedFollowFeature");
			System.out.println("follow is not working as expected");
			Tag_People_Post.btn_changepagetopost.click();
		}
	}

	public void seachfeature() throws Exception {
		clickonpeople();
		seachpeople();
	}
	public void followpeople() throws Exception{
		clickonfollow();
		Thread.sleep(2000);
	}
}
