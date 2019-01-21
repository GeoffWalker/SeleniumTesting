/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bittertesting2018;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Kevin.Bourque
 */
public class BitterUnitTests {
    
    static boolean CreateUser(WebDriver driver, String strUsername, String strPassword, String strEmail) {
        
        driver.get("http://192.168.1.200/qa/jasonm/www/Signup.php");        
        
        WebElement txtFirstName = driver.findElement(By.id("firstname"));
        txtFirstName.sendKeys("nick");
    
        WebElement txtLastName = driver.findElement(By.id("lastname"));
        txtLastName.sendKeys("tagart");  
        
        WebElement txtEmail = driver.findElement(By.id("email"));
        txtEmail.sendKeys(strEmail);   
        
        WebElement txtUsername = driver.findElement(By.id("username"));
        txtUsername.sendKeys(strUsername);

        WebElement txtPassword = driver.findElement(By.id("password"));
        txtPassword.sendKeys(strPassword);

        WebElement txtConfirm = driver.findElement(By.id("confirm"));
        txtConfirm.sendKeys(strPassword); 
 
        WebElement txtPhone = driver.findElement(By.id("phone"));
        txtPhone.sendKeys("506-476-1234"); 
        
        WebElement txtAddress = driver.findElement(By.id("address"));
        txtAddress.sendKeys("19 fake avenue");
        
        Select cboProvince = new Select(driver.findElement(By.id("province")));
        cboProvince.selectByVisibleText("New Brunswick");
        
        WebElement txtPostalCode = driver.findElement(By.id("postalCode"));
        txtPostalCode.sendKeys("E3G 1T3");
    
        WebElement txtUrl = driver.findElement(By.id("url"));
        txtUrl.sendKeys("nick.nick,ca");
        
        WebElement txtDescription = driver.findElement(By.id("desc"));
        txtDescription.sendKeys("Hello");
        
        WebElement txtLocation = driver.findElement(By.id("location"));
        txtLocation.sendKeys("Canada");
        
        WebElement btnLogin = driver.findElement(By.id("button"));
        btnLogin.click();
        
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch (Exception x) {
            
        }
        
        
        String successURL = "http://192.168.1.200/qa/jasonm/www/Login.php";
        //String successURL = "http://localhost/Signup.php";
        String actualURL = driver.getCurrentUrl();
        
        if (actualURL.contains(successURL)) {
            return true;
        } else {
            return false;
        }

        
    }
    
    static boolean UserLogin(WebDriver driver, String username, String password) {
        
        // Put everything in a try-catch block. If something fails, the test fails.
        try {
            // Have the WebDriver load the login page.
            driver.get("http://192.168.1.200/qa/jasonm/www/Login.php");

            // Grab the Web Elements we need to test a page login.
            WebElement txtUsername = BitterWebElements.txtUsername(driver);
            WebElement txtPassword = BitterWebElements.txtPassword(driver);
            WebElement btnLogin = BitterWebElements.btnLogin(driver);

            // Interact with the Web Elements.
            // Put the username in the Username textbox.
            txtUsername.sendKeys(username);
            // Put the password in the Password textbox.
            txtPassword.sendKeys(password);
            // Click the login button.
            btnLogin.click();

            // Compare the page URLs to see if the test passed.
            
            // The URL the page should be on if the test passes.
            String strExpectedUrl1 = "http://192.168.1.200/qa/jasonm/www/index.php";
            String strExpectedUrl2 = "http://192.168.1.200/qa/jasonm/www/login.php";
            
            // A variable to hold the actual URL of the WebDriver.
            String strActualUrl = "";

            // Grab the current URL of the WebDriver and store it in a variable.
            strActualUrl = driver.getCurrentUrl();

            // Compare the URLs to see if the test passes.
            if (strActualUrl.contains(strExpectedUrl1) || strActualUrl.contains(strExpectedUrl2)) {
                return true;
            } else {
                return false;
            }        
        
        // If there is an error, throw out an error message and fail the test.
        } catch (Exception e) {
            System.out.println("User Login Exception Thrown");
            return false;
        }
    }
    
    static boolean Logout(WebDriver driver){
        WebElement navBar = BitterWebElements.navDropdown(driver);
        navBar.click();
        WebElement logout = BitterWebElements.btnLogout(driver);
        logout.click();
        //if there is an alert box, use this.
        //driver.switchTo().alert().accept();
        
        String strSuccess = "http://192.168.1.200/qa/jasonm/www/Login.php";
        String URL = driver.getCurrentUrl();
        
        if(URL.contains(strSuccess)){
            return true;
        }
        else{
            return false;
        }
    }
    
    static boolean Tweet(WebDriver driver, String tweetText){
        WebElement txtTweet = BitterWebElements.txtTweet(driver);
        txtTweet.sendKeys(tweetText);
        txtTweet.sendKeys(Keys.ENTER);
        
        //check if the page has the text that you just tweeted.
        if(driver.getPageSource().contains(tweetText)){
            return true;
        }
        else{
            return false;
        }
    }
    
    static boolean ReplyToTweet(WebDriver driver, String replyText){
        WebElement txtTweet = BitterWebElements.txtReplyTweet(driver);
        txtTweet.sendKeys(replyText);
        txtTweet.sendKeys(Keys.ENTER);
        
        //check if the page has the text that you just tweeted.
        if(driver.getPageSource().contains(replyText)){
            return true;
        }
        else{
            return false;
        }
    }
    
    static boolean Retweet(WebDriver driver){
        BitterWebElements.btnRetweet(driver).click();
        
        String strSuccess = "http://192.168.1.200/qa/jasonm/www/index.php";
        String URL = driver.getCurrentUrl();
        
        if(URL.contains(strSuccess)){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    static boolean GoToUserPage(WebDriver driver){
        BitterWebElements.btnUserPage(driver).click();
        
        String strSuccess = "http://192.168.1.200/qa/jasonm/www/userpage.php";
        String URL = driver.getCurrentUrl();
        
        if(URL.contains(strSuccess)){
            return true;
        }
        else{
            return false;
        }
    }
    
    static boolean CheckPageForErrors(WebDriver driver){

        List<WebElement> allLinks = driver.findElements(By.className("xdebug-error"));

        if (allLinks.size()>0){
            //return false if there are errors. (IE: test failed)
            return false;
        }
        else{
            //return true if there are no errors. (IE: test passed)
            return true;
        }
    }
    
    static boolean IndexWhileLoggedOut(WebDriver driver){
        Logout(driver);
        driver.get("http://192.168.1.200/qa/jasonm/www/index.php");
        String strSuccess = "http://192.168.1.200/qa/jasonm/www/Login.php";
        String url = driver.getCurrentUrl();
        
        if(url.contains(strSuccess)){
            return true;
        }
        else{
            return false;
        }
    }

}