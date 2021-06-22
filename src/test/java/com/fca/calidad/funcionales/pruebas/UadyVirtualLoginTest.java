package com.fca.calidad.funcionales.pruebas;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UadyVirtualLoginTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  //C:\Users\gonza\eclipse-workspace\Driver\chromedriver_win32\chromedriver.exe
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\gonza\\eclipse-workspace\\Driver\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://www.google.com/");
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("uady virtual");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//div[@id='rso']/div/div/div/div/a/h3")).click();
    driver.findElement(By.linkText("Ingresar")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("a17211344");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("value");
    driver.findElement(By.id("loginbtn")).click();
     assertEquals("Datos erróneos. Por favor, inténtelo otra vez.", driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/section/div/div[2]/div/div/div/div/div[1]/div")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
