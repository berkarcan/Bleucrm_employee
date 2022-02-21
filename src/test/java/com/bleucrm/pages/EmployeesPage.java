package com.bleucrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeesPage extends  BasePage{

  @FindBy(className = "pagetitle-item")
  public WebElement company_structure_title;

  @FindBy(className = "webform-small-button-text")
  public WebElement addDepartment;


  @FindBy(xpath = "//span[.='Find Employee']")
  public WebElement findEmployeeButton;

}
