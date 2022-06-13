package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class UnitedAirlinesTest extends Base{
    @Test(priority = 1, description = "Test Case 1: Validate Main menu")
    public void validateMainMenu(){
        driver.get("https://www.united.com/en/us");
        String[] mainMenuList = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};
        for (int i = 0; i < homePage.mainMenu.size(); i++) {
            Assert.assertTrue(homePage.mainMenu.get(i).isDisplayed());
            Assert.assertEquals(homePage.mainMenu.get(i).getText(), mainMenuList[i]);

        }
    }

    @Test(priority = 2, description = "Test Case 2: Validate Book travel menu navigation items")
    public void validateBookTravelMenu(){
        driver.get("https://www.united.com/en/us");
        String[] bookTravelMenuList = {"Book", "Flight status", "Check-in", "My trips"};
        for (int i = 0; i < homePage.bookTravelMenu.size(); i++) {
            Assert.assertTrue(homePage.bookTravelMenu.get(i).isDisplayed());
            Assert.assertEquals(homePage.bookTravelMenu.get(i).getText(), bookTravelMenuList[i]);

        }
    }
    @Test(priority = 3, description = "Test Case 3: Validate Round-trip and One-way radio buttons" )
    public void validateFlightTypeRadioButtons(){
        driver.get("https://www.united.com/en/us");
        Assert.assertTrue(homePage.roundTripRadioButton.isDisplayed());
        Assert.assertTrue(homePage.roundTripRadioButton.isEnabled());
        Assert.assertTrue(homePage.roundTripRadioButton.isSelected());

        Assert.assertTrue(homePage.oneWayTripRadioButton.isDisplayed());
        Assert.assertTrue(homePage.oneWayTripRadioButton.isEnabled());
        Assert.assertFalse(homePage.oneWayTripRadioButton.isSelected());

        homePage.oneWayTripRadioButton.click();
        Assert.assertFalse(homePage.roundTripRadioButton.isSelected());
        Assert.assertTrue(homePage.oneWayTripRadioButton.isSelected());

    }
    @Test(priority = 4, description = "Test Case 4: Validate Book with miles and Flexible dates checkboxes")
    public void validateCheckBoxes() {
        driver.get("https://www.united.com/en/us");
        Assert.assertTrue(homePage.bookWithMilesCheckBox.isDisplayed());
        Assert.assertTrue(homePage.bookWithMilesCheckBox.isEnabled());
        Assert.assertFalse(homePage.bookWithMilesCheckBox.isSelected());

        Assert.assertTrue(homePage.flexibleDatesCheckBox.isDisplayed());
        Assert.assertTrue(homePage.flexibleDatesCheckBox.isEnabled());
        Assert.assertFalse(homePage.flexibleDatesCheckBox.isSelected());

        homePage.bookWithMilesCheckBox.click();
        Assert.assertTrue(homePage.bookWithMilesCheckBox.isSelected());

        homePage.flexibleDatesCheckBox.click();
        Assert.assertTrue(homePage.flexibleDatesCheckBox.isSelected());

        homePage.bookWithMilesCheckBox.click();
        Assert.assertFalse(homePage.bookWithMilesCheckBox.isSelected());

        homePage.flexibleDatesCheckBox.click();
        Assert.assertFalse(homePage.flexibleDatesCheckBox.isSelected());

    }
    @Test(priority = 5, description = "Test Case 5: Validate One-way ticket search results from Chicago, IL, US (ORD) to Miami, FL, US (MIA)")
    public void validateOneWayTicketSearch(){
        driver.get("https://www.united.com/en/us");
        homePage.oneWayTripRadioButton.click();
        homePage.fromInputBox.clear();
        homePage.fromInputBox.sendKeys("Chicago, IL, US (ORD)" + Keys.ENTER);
        homePage.toInputBox.clear();
        homePage.toInputBox.sendKeys("Miami, FL, US (MIA)" + Keys.ENTER);
        homePage.dateInputBox.clear();
        homePage.dateInputBox.click();
        homePage.dateInputBox.sendKeys("01/30/2023" + Keys.ENTER);
        homePage.travelerInputBox.click();
        homePage.adultTravellerPlusButton.click();
        homePage.travelerInfoCloseButton.click();
        homePage.cabinTypeInputBox.click();
        homePage.cabinDropdown.get(2).click();

        homePage.findFlightsButton.click();
        Assert.assertEquals(departureInformationPage.departure.getText(), "Chicago, IL, US to Miami, FL, US");

    }

}
