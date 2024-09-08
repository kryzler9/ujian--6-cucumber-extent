package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtInvalidCredentials;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtUsernameRequired;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtPasswordRequired;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement btnLogin;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement txtProducts;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement menuDropdown;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement btnLogout;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void setBtnLogin(){
        btnLogin.click();
    }

    public void logout(){
        menuDropdown.click();
        btnLogout.click();
    }

    public String getTxtProducts(){
        return txtProducts.getText();
    }

    public String getTxtInvalidCredentials(){
        return txtInvalidCredentials.getText();
    }

    public String getTxtUsernameRequired(){
        return txtUsernameRequired.getText();
    }

    public String getTxtPasswordRequired(){
        return txtPasswordRequired.getText();
    }

    public void clearPassword(){
        password.sendKeys(Keys.CONTROL+"A");
        password.sendKeys(Keys.DELETE);
    }

    public void clearUsername(){
        username.sendKeys(Keys.CONTROL+"A");
        username.sendKeys(Keys.DELETE);
    }
}
