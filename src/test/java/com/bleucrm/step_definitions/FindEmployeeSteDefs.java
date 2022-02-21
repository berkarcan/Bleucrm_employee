package com.bleucrm.step_definitions;

import com.bleucrm.pages.EmployeesPage;
import com.bleucrm.pages.FindEmployeePage;
import com.bleucrm.utilities.Driver;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.bleucrm.utilities.BrowserUtils.*;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class FindEmployeeSteDefs {
  @When("the user click on Find Employee menu")
  public void the_user_click_on_Find_Employee_menu() {
    EmployeesPage employeesPage=new EmployeesPage();
    waitForClickability(employeesPage.findEmployeeButton,15);
    employeesPage.findEmployeeButton.click();

  }

  @Then("{string} title is displayed")
  public void titleIsDisplayed(String expectedtitle) {
    FindEmployeePage findEmployeePage = new FindEmployeePage();
    String actualTitle = findEmployeePage.FindEmployeeTitle.getText();
    Assert.assertEquals("Actual title is different tha expected", expectedtitle, actualTitle);
  }

  @And("the user  clicks Search By Alphabet button")
  public void the_user_clicks_Search_By_Alphabet_button() {
    new FindEmployeePage().SearchByAlphabetButton.click();

  }

  @And("the user clicks the initial character {string} of the searched user")
  public void the_user_clicks_the_initial_character_of_the_searched_user(String character) {
    Driver.get().findElement(By.linkText(character)).click();
    waitForVisibility(Driver.get().findElement(By.xpath("//*[.='Search By Alphabet: "+character+"' and @class='filter-but-text']")),5);
  }

  @Then("the information of the user with initial {string} is displayed")
  public void the_information_of_the_user_with_initial_is_displayed(String expectedCharacter) {
    List<WebElement> resulting_employees = Driver.get().findElements(By.className("employee-name-link"));
    Assert.assertFalse(resulting_employees.isEmpty());
    for (WebElement resulting_employee : resulting_employees) {
      String actualCharacter=String.valueOf(resulting_employee.getText().split(" ")[1].charAt(0)).toUpperCase();;
      Assert.assertEquals("actual differs from expected",expectedCharacter,actualCharacter);

    }

  }


}
