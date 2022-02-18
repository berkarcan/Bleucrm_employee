package com.bleucrm.step_definitions;

import com.bleucrm.pages.DashBoardPage;
import com.bleucrm.pages.EmployeesPage;
import com.bleucrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class EmployeesStepDEf {

  @When("the user clicks on on {string} tab on the Dashboard page")
  public void theUserClicksOnOnTabOnTheDashboardPage(String Employees) {
    DashBoardPage dashBoardPage=new DashBoardPage();
    dashBoardPage.employees_tab.click();
  }


  @Then("the user should be able to see {string} title")
  public void theUserShouldBeAbleToSeeTitle(String expectedTitle) {
    System.out.println("expectedTitle = " + expectedTitle);
    EmployeesPage employeesPage=new EmployeesPage();
    String actualTitle=employeesPage.company_structure_title.getText();
    System.out.println("actualTitle = " + actualTitle);
    Assert.assertEquals("Page title is different",actualTitle , expectedTitle);
  }


  @And("the user click on Add department button")
  public void theUserClickOnAddDepartmentButton() {
   new EmployeesPage().addDepartment.click();
  }


  @Then("the user should be able insert department name and click ADD")
  public void theUserShouldBeAbleInsertDepartmentNameAndClickADD() {
    String expectedDepartmentName="THE NEWEST";
    Driver.get().findElement(By.id("NAME")).sendKeys(expectedDepartmentName);
    Driver.get().findElement(By.xpath("//*[.='Add']")).click();

    String actualDepartmentName=Driver.get().findElement(By.xpath("//*[.='"+expectedDepartmentName+"']")).getText();
    Assert.assertEquals("Department  not added",actualDepartmentName,expectedDepartmentName);


  }

}
