package com.aplikasihadir.steps.KoreksiAbsenDefinition;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.koreksiAbsen.KoreksiAbsenPage;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class KoreksiAbsenPageNegativeTestNoInputDefinition {
    private WebDriver driver;
    private KoreksiAbsenPage koreksiAbsenPage;
    private WebDriverWait wait;

    public KoreksiAbsenPageNegativeTestNoInputDefinition(){
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        koreksiAbsenPage = new KoreksiAbsenPage(driver);
    }

    @Given("Pengguna2 menekan tombol Ajukan Koreksi")
    public void clickAjukanKoreksiButton() throws InterruptedException {
        koreksiAbsenPage.clickButtonAjukanKoreksi();
        Thread.sleep(2000);
    }

    @When("Pengguna2 menekan tombol Ajukan")
    public void clickAjukanButton() throws InterruptedException {
        koreksiAbsenPage.clickButtonAjukan();
    }

    @Then("Pengguna2 akan melihat alert {string}")
    public void verifyElement(String expected){
        Assert.assertEquals(koreksiAbsenPage.getTextErrorEmptyField(), expected);
    }
}
