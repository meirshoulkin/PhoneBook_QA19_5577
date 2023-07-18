package tests;

import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLogged()){
            app.getUser().login(new User()
                    .withEmail("abc@def.com")
                    .withPassword("$Abcdef12345"));
        }
    }

    @Test
    public void removeOneContact(){
        int res = app.getContact().removeOneContact();
        Assert.assertEquals(res, -1);
    }

    @Test
    public void removeAllContacts(){
        app.getContact().removeAllContacts();
        Assert.assertTrue(app.getContact().isElementPresent(By.xpath("//div[@class='contact-item_card__2SOIM']")));
    }

}
