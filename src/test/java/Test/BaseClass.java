package Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import Pages.Follow_Page;
import Pages.Home__Page;
import Pages.New_Post_Page;
import Pages.Tag_People_Post;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	public static AndroidDriver driver;
	public Home__Page home;
	public New_Post_Page Post;
	public Follow_Page follow;
	public Tag_People_Post Peoplepost;
	public static Properties props = new Properties();

	@BeforeSuite
	public void setup() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities  = new DesiredCapabilities();
		capabilities.setCapability("appium:deviceName","samsung SM-M025F");
		capabilities.setCapability("appium:platformname", "Android");     
		capabilities.setCapability("appium:automationName","uiautomator2");
		capabilities.setCapability("appium:uuid","R9ZR10117AV");
		capabilities.setCapability("appium:app", "C:\\Users\\admin\\eclipse-workspace\\Appium_git\\src\\test\\resources\\Apk_File\\Demo.apk");
		capabilities.setCapability("appium:autoGrantPermissions", "true");
		capabilities.setCapability("appium:platformversion", "12");

		URL url = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver(url, capabilities);
		System.out.println("Application started");
		Thread.sleep(2000);
		
		try {
			FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			props.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Method to take Screenshot
	public static void takeScreenshot(String filePath) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\admin\\eclipse-workspace\\Appium_git\\target\\Failed_Screenshots\\"+filePath+".jpg");

		try {
			FileHandler.copy(source, destination);
			System.out.println("Test case is failed and Screen shot has taken");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void initObj() {
		home= new Home__Page(driver);
		Post = new New_Post_Page(driver);
		follow = new Follow_Page(driver);
		Peoplepost = new Tag_People_Post(driver);
	}

	@AfterSuite
	public void teardown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
