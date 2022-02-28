package com.bleucrm.step_definitions;

import com.bleucrm.pages.BasePage;
import com.bleucrm.pages.TelephoneDirectoryPage;
import com.bleucrm.utilities.BrowserUtils;
import com.bleucrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TelephoneDirectoryStepDefs {

  TelephoneDirectoryPage telephoneDirectoryPage=new TelephoneDirectoryPage();
  @When("User clicks on Telephone Directory tab next to Find Employee tab")
  public void userClicksOnTelephoneDirectoryTabNextToFindEmployeeTab() {
    telephoneDirectoryPage.TelephoneDirectoryTab.click();
  }



  @Then("{string} title is displayed with the following columns for the information of users")
  public void titleIsDisplayedWithTheFollowingColumnsForTheInformationOfUsers(String expectedTitle,List<String> expectedColumns) {
    String actualTitle= telephoneDirectoryPage.TelephoneDirectoryTitle.getText();
    Assert.assertEquals(expectedTitle,actualTitle);
    List<String> actualColumns= BrowserUtils.getElementsText(telephoneDirectoryPage.actualTitles);
    Assert.assertEquals(expectedColumns,actualColumns);
  }

  @And("User clicks on an any info of a user e.g. {string} in the directory")
  public void userClicksOnAnAnyInfoOfAUserEGInTheDirectory(String clickedInfo) {
    Driver.get().findElement(By.linkText(clickedInfo)).click();
  }

  @And("User clicks Send message")
  public void userClicksSendMessage() {
    Actions actions = new Actions(Driver.get());
    actions.moveToElement(telephoneDirectoryPage.sendMessageButton);
    actions.perform();
    telephoneDirectoryPage.sendMessageButton.click();
  }


  @And("User inserts a message e.g. {string} into the textbox where there is Enter message note")
  public void userInsertsAMessageEGIntoTheTextboxWhereThereIsEnterMessageNote(String message) {
    telephoneDirectoryPage.textbox.sendKeys(message, Keys.ENTER);
  }

  @Then("the inserted message {string} is displayed on the messages screen")
  public void theInsertedMessageIsDisplayedOnTheMessagesScreen(String expectedMessage) {
    List<String> actualMessages=BrowserUtils.getElementsText(telephoneDirectoryPage.messages);
    Assert.assertTrue("Message is not available",actualMessages.contains(expectedMessage));
  }

  @And("User clicks Browse and select relevant GIF images below the textbox")
  public void userClicksBrowseAndSelectRelevantGIFImagesBelowTheTextbox() {
    telephoneDirectoryPage.gifButton.click();
  }

  @Then("the user will not have {string} message")
  public void theUserWillNotHaveMessage(String expectedErrorMesssage) {
    Driver.get().switchTo().frame(telephoneDirectoryPage.gifIframe);
    System.out.println("telephoneDirectoryPage.errorMessage.getText() = " + telephoneDirectoryPage.errorMessage.getText());
    System.out.println("expectedErrorMesssage = " + expectedErrorMesssage);
    Assert.assertFalse(telephoneDirectoryPage.errorMessage.getText().contains(expectedErrorMesssage));
  }
}
