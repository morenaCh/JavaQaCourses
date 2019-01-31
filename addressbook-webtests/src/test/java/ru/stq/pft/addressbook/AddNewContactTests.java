package ru.stq.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class AddNewContactTests {
  private WebDriver wd;


  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/edit.php");
    login("admin","secret");
  }

  private void login(String login, String password) {
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(login);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys (password);
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
  }

  @Test
  public void testAddNewContacts() throws Exception {
    initAddNewContact();
    fillPersonalData(new GroupDataContact("Bozena", "Kaminska", "Chilecka", "Ordona 7B/41", "567-098-098", "bozena.chilecka@gmail.com"));
    clickSubmitButton();
    returnToNewContact();
    Logout();
  }

  private void Logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  private void returnToNewContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  private void clickSubmitButton() {
    wd.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]")).click();
  }

  private void fillPersonalData(GroupDataContact groupDataContact) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(groupDataContact.getFirstName());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(groupDataContact.getMiddelname());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(groupDataContact.getLastname());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(groupDataContact.getAddress());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(groupDataContact.getMobilePhone());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.linkText("add new")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(groupDataContact.getEmail());
  }


  private void initAddNewContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
    }


  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
