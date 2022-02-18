package com.bleucrm.pages;

import com.bleucrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

  public BasePage() {
    PageFactory.initElements(Driver.get(), this);
  }

 @FindBy (linkText = "Employees")
 public WebElement employees_tab;

  @FindBy (id = "user-name")
  public WebElement usernameText;


}
