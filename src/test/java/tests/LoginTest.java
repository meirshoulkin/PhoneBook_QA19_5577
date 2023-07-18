package tests;

import manager.NgListener;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NgListener.class)
public class LoginTest extends TestBase{

//    WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }

//    @Test
//    public void loginPositiveTest(){
//        // open login form
//        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
//        // fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abc@def.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abcdef12345");
//        // click on Login button
//        wd.findElement(By.xpath("//button[1]")).click();
//
//        // Assert
////        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0);
////        pause(3000);
//        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));
//    }

    @Test(groups = {"smokeGroup", "sanityGroup", "regressionGroup"})
    public void loginPositiveTestUser(){
        String email = "abc@def.com", password = "$Abcdef12345";
        User user = new User()
                .withEmail(email)
                .withPassword(password)
                ;
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLogged());
    }
    @Test(groups = {"smokeGroup", "sanityGroup", "regressionGroup"})
    public void loginPositiveTestUserProp(){
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(app.getEmail(), app.getPassword());
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test
    public void loginNegativeTestWrongEmail() {
        String email = "abcdef.com", password = "$Abcdef12345";
        // open login form
//        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
        app.getUser().openLoginRegistrationForm();
        // fill login form
        app.getUser().fillLoginRegistrationForm(email, password);
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abcdef.com");

//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abcdef12345");
        // click on Login button
//        wd.findElement(By.xpath("//button[1]")).click();
        app.getUser().submitLogin();
        // Assert
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

    }

}
