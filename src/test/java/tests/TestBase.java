package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);
//    WebDriver wd;

    public static ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite(alwaysRun = true)
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }
    public void setUp() throws IOException {
        app.init();
    }


    @AfterSuite(alwaysRun = true)
//    public void tearDown() {
//        wd.quit();
//    }
    public void stop(){
//        app.tearDown();
    }

    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method method){
        logger.info("Start test ---> " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void end(){
        logger.info("=================================");
    }

//    public void click(By locator){
//        wd.findElement(locator).click();
//    }

//    public void openLoginRegistrationForm(){
//        click(By.xpath("//*[text()='LOGIN']"));
//    }

//    public void type(By locator, String text){
//        WebElement element = wd.findElement(locator);
//        element.click();
//        element.clear();
//        element.sendKeys(text);
//    }

//    public void fillLoginRegistrationForm(String email, String password) {
//        type(By.xpath("//input[1]"), email);
//        type(By.xpath("//input[2]"), password);
//    }

//    public void submitLogin(){
//        click(By.xpath("//button[1]"));
//    }
//    public void submitRegistration(){
//        click(By.xpath("//button[2]"));
//    }

//    public boolean isElementPresent(By locator){
//        return wd.findElements(locator).size() > 0;
//    }

//    public void pause(int millis){
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

//    public boolean isLogged(){
//        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
//    }
//
//    public void logout(){
//        click(By.xpath("//*[text()='Sign Out']"));
//    }
}
