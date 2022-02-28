package com.bleucrm.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FindEmployeePage extends BasePage {


  @FindBy(id = "pagetitle")
  public WebElement FindEmployeeTitle;

  @FindAll({
          @FindBy(xpath = "//*[.='Search By Alphabet']"),
          @FindBy(className = "filter-but-text")
  })
  public WebElement SearchByAlphabetButton;

  @FindBy(id="user-fio")
  public WebElement SearchByBox;

  @FindBy(className = "employee-name-link")
  public List<WebElement> employees;
  @FindBy(xpath = "//*[@id='comp_c14920942c1dc3377c56d580c09bf654']/p")
  public List<WebElement> errorMessage; //not to have an error if there is not message

  @FindBy(xpath = "//*[@class='filter-but-icon']")
  public WebElement MoreButton;

   @FindBy(xpath = "//*[.='Export to Excel']/span[2]")
   public WebElement exportToExcelButton;


  public List<List<String>> initials() {

    ArrayList charsWithSurname = new ArrayList();
    ArrayList charsWithNameOnly = new ArrayList();
    String surnameInitial;
    String nameInitial;
    for (WebElement employee : employees) {
      nameInitial= String.valueOf(employee.getText().split(" ")[0].charAt(0)).toUpperCase();

      if (employee.getText().split(" ").length == 2) {
        surnameInitial= String.valueOf(employee.getText().split(" ")[1].charAt(0)).toUpperCase();
        if (!charsWithSurname.contains(surnameInitial)){
          charsWithSurname.add(surnameInitial);
        }
      }else if ((!charsWithNameOnly.contains(nameInitial))&&(!charsWithSurname.contains(nameInitial))) {
        charsWithNameOnly.add(nameInitial);
        }
      }

    List<List<String>> initialsList = new ArrayList<List<String>>();
    initialsList.add(charsWithSurname);
    initialsList.add(charsWithNameOnly);

    return initialsList;
  }


}
