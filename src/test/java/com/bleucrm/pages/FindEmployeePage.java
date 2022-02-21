package com.bleucrm.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class FindEmployeePage extends BasePage {


 @FindBy (id="pagetitle")
 public WebElement FindEmployeeTitle;

 @FindAll({
         @FindBy(xpath = "//*[.='Search By Alphabet']"),
         @FindBy(className = "filter-but-text")
 })
 public WebElement SearchByAlphabetButton;


}
