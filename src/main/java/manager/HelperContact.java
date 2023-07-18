package manager;

import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }
    Logger logger = LoggerFactory.getLogger(HelperContact.class);

    public void openContactForm(){
        click(By.xpath("//*[text()='ADD']"));
    }
    public void fillContactForm(Contact contact){
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }
    public void submitContactForm(){
        click(By.xpath("//button[.='Save']"));
    }

    public int removeOneContact(){
        int countBefore = countOfContacts();
        logger.info("Number of contacts before is " + countBefore);
        String phone = wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM']//h3")).getText();
        logger.info("The deleted phone number is " + phone);
        click(By.xpath("//div[@class='contact-item_card__2SOIM']"));
        click(By.xpath("//button[.='Remove']"));
        pause(5000);
        int countAfter = countOfContacts();
        logger.info("Number of contacts after is " + countAfter);
        return countAfter - countBefore;
    }

    public int countOfContacts(){
        return wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size();
    }

    public void removeAllContacts(){
        while (wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size()!=0){
            removeOneContact();
        }
    }
}
