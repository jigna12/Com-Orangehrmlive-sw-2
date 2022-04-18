/*3. Write down the following test into ‘LoginTest’ class
1. userSholdLoginSuccessfullyWithValidCredentials
* Enter “Admin” username
* Enter “admin123 password
* Click on ‘LOGIN’ button
* Verify the ‘Welcome’ text is display*/
package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String BaseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials()
    {
        //Find username element and enter the username
        WebElement username = driver.findElement(By.name("txtUsername"));
        username.sendKeys("Admin");
        //Find password element and enter the password
        WebElement password = driver.findElement(By.name("txtPassword"));
        password.sendKeys("admin123");

        //Find Login Button element and click
        WebElement LoginBtn = driver.findElement(By.id("btnLogin"));
        LoginBtn.click();

        WebElement ActualMassageElement = driver.findElement(By.xpath("//a[@id='welcome']"));
        String ActMsg = ActualMassageElement.getText();
        System.out.println("Actual Message :" +ActMsg);
        boolean x = ActMsg.contains("Welcome");//if login successful give true value
        boolean y = true;

        //Validate actual and expected message
       Assert.assertEquals("Massage is not as expected:",x,y);//x && y = true
    }
    @After
    public void closedown()
    {
        closeBrowser();
    }

}
