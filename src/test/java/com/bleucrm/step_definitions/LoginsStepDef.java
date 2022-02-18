package com.bleucrm.step_definitions;


import com.bleucrm.pages.DashBoardPage;
import com.bleucrm.pages.LoginPage;
import static com.bleucrm.utilities.BrowserUtils.*;
import com.bleucrm.utilities.ConfigurationReader;
import com.bleucrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginsStepDef {


  @Given("the user is on the page which has the title {string}")
  public void theUserIsOnThePageWhichHasTheTitle(String title){

    //waitForVisibility(Driver.get().findElement(By.xpath("//title")),10);
    Assert.assertEquals("Title is different than expected",title,Driver.get().getTitle());

  }

  @When("the user logins with a valid {string} and {string}")
  public void theUserLoginsWithAValidAnd(String username, String password) {
    LoginPage loginPage=new LoginPage();
    username= ConfigurationReader.get("username");
    password=ConfigurationReader.get("password");
    loginPage.login(username, password);
  }

  @Then("the user should be able to reach the dashboard page with the username on the the top right")
  public void the_user_should_be_able_to_reach_the_dashboard_page_with_the_username_on_the_the_top_right() {
    DashBoardPage dashBoardPage=new DashBoardPage();
    waitForVisibility(dashBoardPage.usernameText,10);
    Assert.assertEquals("Different Username", ConfigurationReader.get("username"),dashBoardPage.usernameText.getText());
  }

  @When("the user logins with invalid credential {string} username {string} password")
  public void theUserLoginsWithAInvalidCredentialUsernamePassword(String username, String password){
    LoginPage loginPage=new LoginPage();
    if (username.equals(ConfigurationReader.get("username")) && !password.equals(ConfigurationReader.get("password")) ){
      username = ConfigurationReader.get("username");
    }else if(!username.equals(ConfigurationReader.get("username")) && password.equals(ConfigurationReader.get("password")) ){
      password=ConfigurationReader.get("password");
    }
    loginPage.login(username, password);

  }

  @Then("the user should be able to have {string} message")
  public void theUserShouldBeAbleToHaveMessage(String message) {

    Assert.assertEquals("The message is different",message,Driver.get().findElement(By.className("errortext")).getText());
  }


  @When("the user clicks on the Forgot your password? link")
  public void theUserClicksOnTheForgotYourPasswordLink() {
      new LoginPage().ForgetPasswordButton.click();
  }

  @And("Inserts login or email clicks to reset {string}")
  public void insertsLoginOrEmailClicksToReset(String reset) {
    Driver.get().findElement(By.name("USER_LOGIN")).sendKeys(ConfigurationReader.get("login"));
    Driver.get().findElement(By.name("USER_EMAIL")).sendKeys(ConfigurationReader.get("username"));
    Driver.get().findElement(By.xpath("//*[.='"+reset+"']")).click();

  }

  @Then("the user sees a message containing {string}")
  public void theUserSeesAMessageContaining(String expectedMessage) {
    String actualMessage = Driver.get().findElement(By.className("notetext")).getText();
    Assert.assertTrue("Message differs from expected",actualMessage.contains(expectedMessage));
  }


  @When("the user logins with valid {string} and {string} clicking on Remember check box")
  public void theUserEntersAValidClickingOnRememberCheckBox(String username, String password) {
    LoginPage loginPage=new LoginPage();
    username= ConfigurationReader.get("username");
    password=ConfigurationReader.get("password");
    loginPage.remember.click();
    loginPage.login(username, password);

  }

  @And("the user logout")
  public void theUserLogout() {
    new DashBoardPage().usernameText.click();
    Driver.get().findElement(By.linkText("Log out")).click();
  }

  @Then("the username remains on the username box")
  public void theUsernameRemainsOnTheUsernameBox() {
    System.out.println("new LoginPage().username_box.getText() = " + new LoginPage().username_box.getText());
  }


  @And("Inserts incorrect login or email clicks to reset {string}")
  public void insertsIncorrectLoginOrEmailClicksToReset(String reset) {

  }

  @And("Inserts incorrect {string} or {string} clicks to reset {string} and sees {string}")
  public void insertsIncorrectOrClicksToReset( String login, String email, String reset, String expectedMessage) {
    if (!login.isEmpty()) {
      Driver.get().findElement(By.name("USER_LOGIN")).sendKeys(login);
    }
    if (!email.isEmpty()){
      Driver.get().findElement(By.name("USER_EMAIL")).sendKeys(email);
    }

    Driver.get().findElement(By.xpath("//*[.='"+reset+"']")).click();

    String actualMessage = Driver.get().findElement(By.className("errortext")).getText();
    Assert.assertTrue("Message differs from expected",actualMessage.contains(expectedMessage));

  }


}






