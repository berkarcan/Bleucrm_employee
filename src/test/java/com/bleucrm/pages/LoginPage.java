package com.bleucrm.pages;

import com.bleucrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

  public LoginPage(){
    PageFactory.initElements(Driver.get(), this);
  }

  @FindBy (name="USER_LOGIN")
  public WebElement username_box;

  @FindBy (name="USER_PASSWORD")
  public WebElement password_box;

  @FindBy (className = "login-btn")
  public WebElement LogInButton;

  @FindBy (xpath = "//*[.='Forgot your password?']")
  public WebElement ForgetPasswordButton;

  @FindBy (id="USER_REMEMBER")
  public WebElement remember;


  public void login(String username, String password){
    username_box.sendKeys(username);
    password_box.sendKeys(password);
    LogInButton.click();
  }

}
