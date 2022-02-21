package com.bleucrm.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.security.PublicKey;

public class FindEmployeePage extends BasePage {

 @FindBys({
         @FindBy(xpath = "//*[.='Find Employee']"),
         @FindBy(className = "main-buttons-item-text-title")
 })
 public WebElement findEmployeeButton;

 @FindBys({
         @FindBy(xpath = "//*[.='Search By Alphabet']"),
         @FindBy(className = "filter-but-text")
 })
 public WebElement SearchByAlphabetButton;



}
