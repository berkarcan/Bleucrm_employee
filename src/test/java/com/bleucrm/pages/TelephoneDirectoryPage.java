package com.bleucrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TelephoneDirectoryPage extends BasePage  {

  @FindBy(xpath = "//span[.='Telephone Directory']")
  public WebElement TelephoneDirectoryTab;

  @FindBy(id = "pagetitle")
  public WebElement TelephoneDirectoryTitle;

  @FindBy(xpath = "//*[@id='comp_f26732056c92442fa1ef487951f5465d']/table/thead/tr/td")
  public List<WebElement> actualTitles;

  @FindBy(className = "webform-small-button-text")
  public  WebElement sendMessageButton;

  @FindBy(className = "bx-messenger-textarea-input")
  public WebElement textbox;

  @FindBy(xpath = "//*[@title='Browse and select relevant GIF images']")
  public WebElement gifButton;

  @FindBy(xpath = "//*[@class='bx-messenger-iframe-element bx-messenger-custom-scroll']")
  public WebElement gifIframe;

  @FindBy(xpath = "//body/span")
  public WebElement errorMessage;

  @FindBy(className = "bx-messenger-message")
  public  List<WebElement> messages;




}
