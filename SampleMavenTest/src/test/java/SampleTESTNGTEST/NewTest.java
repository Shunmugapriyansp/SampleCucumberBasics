package SampleTESTNGTEST;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test(dataProvider = "dp")
  public void ClsTest(Integer n, String s) {
	  System.out.println("Printing n -->" + n);
	  System.out.println("Printing s -->" + s);
  }
  
  @Test(dataProvider = "dp")
  public void ClsTest2(Integer n, String s) {
	  System.out.println("Printing2 n -->" + n);
	  System.out.println("Printing2 s -->" + s);
  }
  
  @Test
  public void testyahoo()
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\FarmClient\\JavaPreRequisite\\WebDriverExe\\Win32\\chromedriver.exe");
	  WebDriver driver= new ChromeDriver();
	  driver.get("www.google.com");
	  driver.quit();
  }

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Printing BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  System.out.println("Printing AFTERMethod");
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Printing BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Printing AfterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Printing BeforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Printing AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Printing BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Printing AfterSuite");
  }

}
