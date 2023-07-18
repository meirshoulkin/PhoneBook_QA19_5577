package tests;

import manager.ProviderData;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

//    WebDriver wd;
//
//    @BeforeMethod
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

//    @Test
//    public void registrationPositiveTest(){
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//        // open login form
//        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
//        // fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abc_" + i + "@def.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abcdef12345");
//        // click on Registration button
//        wd.findElement(By.xpath("//button[2]")).click();
//
//        // Assert
//        Assert.assertTrue(wd.findElements(By.xpath("//a[@href='/add']")).size() > 0);
//    }

    @Test(groups = {"sanityGroup", "regressionGroup"}, invocationCount = 3)
    public void registrationPositiveTest(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "abc_" + i + "@def.com", password = "$Abcdef12345";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
    }
    @Test(groups = {"sanityGroup", "regressionGroup"}, dataProvider = "dataCSV", dataProviderClass = ProviderData.class)
    public void registrationPositiveTestCSV(User user){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user.getEmail(), user.getPassword());
        app.getUser().submitRegistration();
    }

    @Test
    public void registrationNegativeTestWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        String email = "abc_" + i + "def.com", password = "$Abcdef12345";

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();
        Assert.assertTrue(app.getUser().isErrorMessageFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

    }

}
