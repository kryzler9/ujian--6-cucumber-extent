package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAndCheckoutPage {

    private WebDriver driver;

    public AddAndCheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addBackpack;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
    private WebElement addOnesie;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement myCart;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement firstCheckout;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueCheckout;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishCheckout;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement txtSuccessCheckout;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backHome;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtPostalCodeRequired;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtLastNameRequired;

    public void setAddBackpack(){
        addBackpack.click();
    }

    public void setAddOnesie(){
        addOnesie.click();
    }

    public void setMyCart(){
        myCart.click();
    }

    public void setFirstCheckout(){
        firstCheckout.click();
    }

    public void yourInfo(String firstname, String lastname, String postalcode){
        this.firstName.sendKeys(firstname);
        this.lastName.sendKeys(lastname);
        this.postalCode.sendKeys(postalcode);
    }

    public void setFinishCheckout(){
        finishCheckout.click();
    }

    public void setContinueCheckout(){
        continueCheckout.click();
    }

    public String getTxtSuccessCheckout(){
        return txtSuccessCheckout.getText();
    }

    public void setBackHome(){
        backHome.click();
    }

    public String getTxtLastNameRequired(){
        return txtLastNameRequired.getText();
    }

    public String getTxtPostalCodeRequired(){
        return txtPostalCodeRequired.getText();
    }
}
