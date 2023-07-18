package tests;

import model.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(!app.getUser().isLogged()){
            app.getUser().openLoginRegistrationForm();
            app.getUser().fillLoginRegistrationForm("abc@def.com", "$Abcdef12345");
            app.getUser().submitLogin();
        }
    }

    @Test(invocationCount = 5, groups = {"sanityGroup"})
    public void addNewContactPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Joe")
                .lastName("Doe")
                .phone("123456" + i)
                .email("joe" + i + "@mail.com")
                .address("Haifa")
                .description("Best friend")
                .build();

        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().submitContactForm();

        Assert.assertTrue(
                app.getUser().getText(
                        By.xpath("//div[@class='contact-item_card__2SOIM']" +
                                "[last()]//h3")).equals(contact.getPhone())
        );
    }

}
