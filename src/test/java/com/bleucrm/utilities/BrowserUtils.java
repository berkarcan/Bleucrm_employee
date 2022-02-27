package com.bleucrm.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
  static int number;
  public static int NumberOfStrings(List<String> l, String str) {
    number=0;
    for (String element: l) {
      if(element.contains(str)){
        number++;
      }
    }
    return number;
  }

  public static List<String> getElementsText(List<WebElement> list) {
    List<String> elemTexts = new ArrayList<>();
    for (WebElement el : list) {
      elemTexts.add(el.getText());
    }
    return elemTexts;
  }

  public static void waitFor(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
    WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
    return wait.until(ExpectedConditions.visibilityOf(element));
  }

  public static WebElement waitForClickability(WebElement element, int timeout) {
    WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
    return wait.until(ExpectedConditions.elementToBeClickable(element));
  }


}
