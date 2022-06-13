package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "div[role='tablist']>a")
    public List<WebElement> mainMenu;

    @FindBy(xpath = "//li[@name='travelTab']/../li")
    public List<WebElement> bookTravelMenu;

    @FindBy (xpath = "(//span[contains(@class,'checkmark--2DHJD')])[1]")
    public WebElement roundTripRadioButton;

    //@FindBy(css = "label[for='roundtrip']")
    //public WebElement roundTripButtonText;

    @FindBy (xpath = "(//span[contains(@class,'checkmark--2DHJD')])[2]")
    public WebElement oneWayTripRadioButton;

    //@FindBy(css = "label[for='oneway']")
    //public WebElement oneWayTripButtonText;

    @FindBy( css = "label[for='award']")
    public WebElement bookWithMilesCheckBox;

    @FindBy(css = "label[for='flexibleDates']")
    public WebElement flexibleDatesCheckBox;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement fromInputBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toInputBox;

    @FindBy(id = "DepartDate")
    public WebElement dateInputBox;

    @FindBy (css = "div[id=passengerSelector]>button")
    public WebElement travelerInputBox;

    @FindBy(css = "button[aria-label='Substract one Adult']")
    public WebElement adultTravellerPlusButton;

    @FindBy (css = "button[class='atm-c-btn atm-c-btn--bare']")
    public WebElement travelerInfoCloseButton;

    @FindBy (id = "cabinType")
    public WebElement cabinTypeInputBox;

    @FindBy(css = "ul[role='listbox']>li")
    public List<WebElement> cabinDropdown;

    @FindBy(css = "button[aria-label='Find flights']")
    public WebElement findFlightsButton;




}
