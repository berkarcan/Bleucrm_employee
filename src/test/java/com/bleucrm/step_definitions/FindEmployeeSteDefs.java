package com.bleucrm.step_definitions;

import com.bleucrm.pages.EmployeesPage;
import com.bleucrm.pages.FindEmployeePage;
import com.bleucrm.utilities.BrowserUtils;
import com.bleucrm.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.assertj.core.api.SoftAssertions;

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


  @When("the user  clicks Search By Alphabet button")
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

  public List<String> employee_list;
  public List<String> retrievedList;
  public Actions actions;
  public int nRetrieved;
  public int nListed;

  @When("the user inserts {string} and click enter")
  public void theUserInsertsAndClickEnter(String chars) {
    employee_list = getElementsText(findEmployeePage.employees);
    System.out.println("employee_list = " + employee_list);
    findEmployeePage.SearchByBox.sendKeys(chars, Keys.ENTER);
  }

  SoftAssertions sa = null;
  @Then("the number of retrieved users equals to the number users containing {string}")
  public void theNumberOfRetrievedUsersEqualsToTheNumberUsersContaining(String chars) {
    retrievedList = getElementsText(findEmployeePage.employees);
    System.out.println("retrievedList  = " + retrievedList );
    nRetrieved=BrowserUtils.NumberOfStrings(retrievedList,chars);
    System.out.println("nRetrieved = " + nRetrieved);
    nListed=BrowserUtils.NumberOfStrings(employee_list,chars);
    System.out.println("nListed = " + nListed);
    if (nRetrieved!=nListed) {
      for (String employee : employee_list) {
        if (employee.contains(chars)) {
          employeesPage.findEmployeeButton.click();
          actions = new Actions(Driver.get());
          actions.moveToElement(Driver.get().findElement(By.linkText(employee)));
          actions.perform();//go to the failing element
          sa.assertThat(nListed=nRetrieved);
          break;
        }
      }
    }

  }

  @Then("the information of the usernames containing {string} is displayed")
  public void theInformationOfTheUsernamesContainingIsDisplayed(String chars) {
    if (nRetrieved!=nListed){
      actions.moveToElement(employeesPage.findEmployeeButton);
      actions.perform();
      employeesPage.findEmployeeButton.click();
      findEmployeePage.SearchByBox.sendKeys(chars, Keys.ENTER);
      sa.assertThat(nListed=nRetrieved);

    }

  }


}




//if (employee_list.stream().anyMatch(keyword -> keyword.contains(chars))) { //if there is matching string in the whole list