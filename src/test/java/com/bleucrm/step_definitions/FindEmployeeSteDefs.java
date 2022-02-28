package com.bleucrm.step_definitions;

import com.bleucrm.pages.EmployeesPage;
import com.bleucrm.pages.FindEmployeePage;
import com.bleucrm.utilities.BrowserUtils;
import com.bleucrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bleucrm.utilities.BrowserUtils.*;

import java.util.List;


public class FindEmployeeSteDefs {

  public static List<List<String>> initials;

  EmployeesPage employeesPage = new EmployeesPage();

  @When("the user click on Find Employee menu")
  public void the_user_click_on_Find_Employee_menu() {

    waitForClickability(employeesPage.findEmployeeButton, 15);
    employeesPage.findEmployeeButton.click();

  }

  FindEmployeePage findEmployeePage = new FindEmployeePage();

  @Then("{string} title is displayed with the user list")
  public void titleIsDisplayedWithTheUserList(String expectedtitle) {

    initials = findEmployeePage.initials();
    String actualTitle = findEmployeePage.FindEmployeeTitle.getText();
    Assert.assertEquals("Actual title is different tha expected", expectedtitle, actualTitle);

    Assert.assertFalse(initials.isEmpty());
    System.out.println("[Surname initials, Only Name initials]\n" + initials);

  }


  @When("the user clicks Search By Alphabet button")
  public void the_user_clicks_Search_By_Alphabet_button() {
    findEmployeePage.SearchByAlphabetButton.click();

  }

  @And("the user clicks the initial character {string} of the searched user")
  public void the_user_clicks_the_initial_character_of_the_searched_user(String character) {
    Driver.get().findElement(By.linkText(character)).click();
    waitForVisibility(Driver.get().findElement(By.xpath("//*[.='Search By Alphabet: " + character + "' and @class='filter-but-text']")), 10);

  }

  @Then("the information of the user with initial {string} is displayed")
  public void the_information_of_the_user_with_initial_is_displayed(String expectedCharacter) {

    List<WebElement> resulting_employees = Driver.get().findElements(By.className("employee-name-link"));
    if (initials.get(0).contains(expectedCharacter)) {

      for (WebElement resulting_employee : resulting_employees) {
        String actualCharacter = String.valueOf(resulting_employee.getText().split(" ")[1].charAt(0)).toUpperCase();
        Assert.assertEquals("actual differs from expected", expectedCharacter, actualCharacter);
      }
    } else if (initials.get(1).contains(expectedCharacter)) {
      Assert.assertFalse("No results for an employee without surname. There are users with " + initials.get(1).toString() + " initials.", resulting_employees.isEmpty());
    } else {

      Assert.fail("Initial character must be one of the following: \n" + initials);

    }


  }

  public List<String> employeeList;
  public List<String> actualList;
  public Actions actions;
  String errorMessage;
  @When("the user inserts {string} and click enter")
  public void theUserInsertsAndClickEnter(String chars) {
    employeeList = getElementsText(findEmployeePage.employees);
    System.out.println("employee_list = " + employeeList);
    findEmployeePage.SearchByBox.sendKeys(chars, Keys.ENTER);
  }


  @Then("the information of the usernames containing {string} is displayed")
  public void theInformationOfTheUsernamesContainingIsDisplayed(String str) {
    actualList = getElementsText(findEmployeePage.employees);
    System.out.println("actualList  = " + actualList );

    if (!findEmployeePage.errorMessage.isEmpty()) {
      errorMessage = findEmployeePage.errorMessage.get(0).getText();
    }

    List<String> expectedList=BrowserUtils.matchingStrings(employeeList,str);
    System.out.println("expectedList = " + expectedList);

    if (!actualList.equals(expectedList)) {
      for (String employee : employeeList) {
        if (employee.contains(str) && !actualList.contains(employee)){
          employeesPage.findEmployeeButton.click();
          actions = new Actions(Driver.get());
          actions.moveToElement(Driver.get().findElement(By.linkText(employee)));
          actions.perform();//go to the unlisted element
          Assert.assertEquals(errorMessage+" NOTE: Screenshot shows an unlisted employee.", expectedList,actualList);
          break;
        }
      }
    }
  }

  @When("the user clicks on More")
  public void theUserClicksOnMore() {
    findEmployeePage.MoreButton.click();


  }

  @Then("the user clicks Export to Excel to save users.xls successfully")
  public void theUserClicksExportToExcelToSaveUsersXls() {
    findEmployeePage.exportToExcelButton.click();
  }



}




//if (employee_list.stream().anyMatch(keyword -> keyword.contains(chars))) { //if there is matching string in the whole list