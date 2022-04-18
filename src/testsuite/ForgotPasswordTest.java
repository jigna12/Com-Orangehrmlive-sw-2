/*4. Write down the following test into ‘ForgotPasswordTest’
class
1. userShouldNavigateToForgotPasswordPageSuccessfully
* click on the ‘Forgot your password’ link
* Verify the text ‘Forgot Your Password?’*/
package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String BaseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }
    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully()
    {
       // Find the Forgot your password and click
        WebElement ForgotPassword = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        ForgotPassword.click();

        ////This is from requirement
        String ExpectedMsg = "Forgot your password";
        WebElement AcatulMsg = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String ActMsg = AcatulMsg.getText();
        System.out.println("Forgot password acutal message:" +ActMsg);
        //Validate actual and expected message
        Assert.assertEquals("Forgot Password is not as per project require:",ExpectedMsg,AcatulMsg);
    }

    @After
    public void closedown() {
      //  closeBrowser();
    }
}