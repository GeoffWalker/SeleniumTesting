/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bittertesting2018;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Kevin.Bourque
 */

public class BitterTesting2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WebDriver driver = BitterWebElements.initWebDriver();
        driver.manage().window().maximize();
        
        //create an account with correct information... test should pass.
        boolean BIT001 = BitterUnitTests.CreateUser(driver, "geoffwalker", "geoff", "geoff@gmail.com");
        System.out.println("BIT001 (expect true): " + BIT001);
        
        //create an account with incorrect information... test should fail.
        boolean BIT002 = BitterUnitTests.CreateUser(driver, "geoffwalker", "geoff", "geoff");
        System.out.println("BIT002 (expect false): " + BIT002);
        
        // Login using the username: test3r33 and Password: test3r33
        boolean BIT003 = BitterUnitTests.UserLogin(driver, "test3r33", "test3r33");
        System.out.println("BIT003(expect false): " + BIT003);
        driver.switchTo().alert().accept();
        
        // Login using the username: test and Password: test
        boolean BIT004 = BitterUnitTests.UserLogin(driver, "test", "test");
        System.out.println("BIT004 (expect true): " + BIT004);
        
        // Log out of current user
        boolean BIT005 = BitterUnitTests.Logout(driver);
        System.out.println("BIT005 (expect true): " + BIT005);

        // Submit tweet
        BitterUnitTests.UserLogin(driver, "nick", "asdf");
        boolean BIT006 = BitterUnitTests.Tweet(driver, "Super secret test tweet");
        System.out.println("BIT006 (expect true): " + BIT006);
        
        // Reply to tweet
        boolean BIT007 = BitterUnitTests.ReplyToTweet(driver, "Super secret reply");
        System.out.println("BIT007 (expect true): " + BIT007);
        
        // Retweet
        boolean BIT008 = BitterUnitTests.Retweet(driver);
        System.out.println("BIT008 (expect true): " + BIT008);
        
        // Submit tweet with no text
        driver.get("http://192.168.1.200/qa/jasonm/www/index.php");
        boolean BIT009 = BitterUnitTests.Tweet(driver, "");
        System.out.println("BIT009 (expect false): " + BIT009);
        
        // Reply to tweet with no text
        boolean BIT010 = BitterUnitTests.ReplyToTweet(driver, "");
        System.out.println("BIT010 (expect true): " + BIT010);
        
        // Go to user page.
        boolean BIT011 = BitterUnitTests.GoToUserPage(driver);
        System.out.println("BIT011 (expect true): " + BIT011);
        
        // Ensure there are no errors on the User Page.
        boolean BIT012 = BitterUnitTests.CheckPageForErrors(driver);
        System.out.println("BIT012 (expect true): " + BIT012);
        
        // Ensure there are no erros on the index page.
        driver.get("http://192.168.1.200/qa/jasonm/www/index.php");
        boolean BIT013 = BitterUnitTests.CheckPageForErrors(driver);
        System.out.println("BIT013 (expect true): " + BIT013);
        
        // Ensure there are no erros on the contact us page.
        driver.get("http://192.168.1.200/qa/jasonm/www/ContactUs.php");
        boolean BIT014 = BitterUnitTests.CheckPageForErrors(driver);
        System.out.println("BIT014 (expect true): " + BIT014);
        
        // Ensure there are no erros on the registration page.
        driver.get("http://192.168.1.200/qa/jasonm/www/signup.php");
        boolean BIT015 = BitterUnitTests.CheckPageForErrors(driver);
        System.out.println("BIT015 (expect true): " + BIT015);
        
        // Navigating to index page while logged out.
        boolean BIT016 = BitterUnitTests.IndexWhileLoggedOut(driver);
        System.out.println("BIT016 (expect true): " + BIT016);
        
        // Test incorrect username/password combination.
        boolean BIT017 = BitterUnitTests.UserLogin(driver, "nick", "wrongpassword");
        System.out.println("BIT017 (expect true): " + BIT017);
        
        // Close the WebDriver browser when the tests are complete.
        driver.close();
        
    }
}
