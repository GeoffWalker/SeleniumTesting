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
public class BitterWebElements {
    
    // Initialize / Create the WebDriver to use in future tests.
    static WebDriver initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "c:/Users/Geoff Walker/Google Drive/School/Term 4/QA/Selenium/chromedriver_win32/chromedriver.exe");
        
        // Initialize the Chrome Web Driver (Open the browser)
        WebDriver driver = new ChromeDriver();
        
        return driver;
    }
    
    // Grab the Login's Username textbox.
    static WebElement txtUsername(WebDriver driver) {
        WebElement txtUsername = driver.findElement(By.id("username"));
        return txtUsername;
    }
    
    // Grab the Login's Password textbox.
    static WebElement txtPassword(WebDriver driver) {
        return driver.findElement(By.id("password"));
    }
    
    // Grab the Login button.
    static WebElement btnLogin(WebDriver driver) {
        WebElement btnLogin = driver.findElement(By.id("button"));
        return btnLogin;
    }
    
    static WebElement navDropdown(WebDriver driver){
        WebElement navBarDrop = driver.findElement(By.id("dropdown01"));
        return navBarDrop;
    }
    
    static WebElement btnLogout(WebDriver driver){
        WebElement btnLogout = driver.findElement(By.linkText("Logout"));
        return btnLogout;
    }
    
    static WebElement txtTweet(WebDriver driver){
        WebElement txtTweet = driver.findElement(By.id("myTweet"));
        txtTweet.click();
        return txtTweet;
    }
    
    static WebElement txtReplyTweet(WebDriver driver){
        WebElement txtReplyTweet = driver.findElement(By.id("replyTweet"));
        txtReplyTweet.click();
        return txtReplyTweet;
    }
    
    static WebElement btnRetweet(WebDriver driver){
        WebElement btnRetweet = driver.findElement(By.linkText("Retweet"));
        return btnRetweet;
    }
    
    static WebElement btnUserPage(WebDriver driver){
        WebElement btnUserPage = driver.findElement(By.linkText("Nick Taggart"));
        return btnUserPage;
    }
    
}
