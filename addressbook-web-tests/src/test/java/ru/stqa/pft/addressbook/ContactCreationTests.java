package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactCreationTests {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login("admin", "secret");
    }

    private void login(String login, String password) {
        login(login, password, wd);
    }

    static void login(String login, String password, WebDriver wd) {
        wd.get("http://localhost/addressbook/group.php");
        wd.findElement(By.id("LoginForm")).click();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(login);
        wd.findElement(By.id("LoginForm")).click();
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testContactCreation() throws Exception {
        initContactCreation();
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        fillContactForm(new ContactData("test1", "test2", "test3", "test4", "C:\\fakepath\\59d0ce0b5087915ed7a4dc42.jpg", "test5", "test6", "test7", "test8", "test9", "test10", "test11", "test12", "test13", "test14", "test15", "1", "January", "1990", "2", "February", "2000", "test1", "test16", "test17", "test18"));
        submitContactCreation();
        returnHomePage();
    }

    private void fillContactForm(ContactData contactData) {
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
        /*wd.findElement(By.name("photo")).click();
        wd.findElement(By.name("photo")).clear();
        wd.findElement(By.name("photo")).sendKeys(contactData.getPhoto());*/
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
        wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(contactData.getHome());
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
        wd.findElement(By.name("work")).clear();
        wd.findElement(By.name("work")).sendKeys(contactData.getWork());
        wd.findElement(By.name("fax")).clear();
        wd.findElement(By.name("fax")).sendKeys(contactData.getFax());
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
        wd.findElement(By.name("email2")).clear();
        wd.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
        wd.findElement(By.name("email3")).clear();
        wd.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
        wd.findElement(By.name("homepage")).clear();
        wd.findElement(By.name("homepage")).sendKeys(contactData.getHomepage());
        wd.findElement(By.name("bday")).click();
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
        wd.findElement(By.xpath("//option[@value='1']")).click();
        wd.findElement(By.name("bmonth")).click();
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
        wd.findElement(By.xpath("//option[@value='January']")).click();
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(contactData.getByear());
        wd.findElement(By.name("aday")).click();
        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAday());
        wd.findElement(By.xpath("(//option[@value='2'])[2]")).click();
        wd.findElement(By.name("amonth")).click();
        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAmonth());
        wd.findElement(By.xpath("(//option[@value='February'])[2]")).click();
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).clear();
        wd.findElement(By.name("ayear")).sendKeys(contactData.getAyear());
        wd.findElement(By.name("new_group")).click();
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getNew_group());
        wd.findElement(By.xpath("(//option[@value='1'])[3]")).click();
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(contactData.getAddress2());
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(contactData.getPhone2());
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(contactData.getNotes());
    }

    private void returnHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void submitContactCreation() {
        wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    private void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        logout();
        wd.quit();
    }

    private void logout() {
        wd.findElement(By.linkText("Logout")).click();
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
