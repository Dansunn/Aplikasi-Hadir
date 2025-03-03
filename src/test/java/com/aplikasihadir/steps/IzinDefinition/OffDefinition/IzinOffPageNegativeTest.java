package com.aplikasihadir.steps.IzinDefinition.OffDefinition;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.Izin.IzinOffPage;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IzinOffPageNegativeTest {
    private WebDriver driver;
    private IzinOffPage izinOffPage;
    private WebDriverWait wait;

    public IzinOffPageNegativeTest() {
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        izinOffPage = new IzinOffPage(driver);
    }

    @Given("Pengguna1 menekan tombol ajukan izin off")
    public void clickAjukanIzinOffButton() throws InterruptedException {
        izinOffPage.clickBtnAjukanIzinOff();
    }

    @When("Pengguna1 langsung menekan tombol ajukan")
    public void clickAjukanButton() throws InterruptedException {
        izinOffPage.clickBtnAjukan();
    }

    @Then("Muncul pesan error {string}, {string}")
    public void verifyElementText (String expectedMsg1, String expectedMsg2){
        // Ambil teks dari notifikasi yang muncul
        String actualMsg1 = izinOffPage.getTextErrorTanggalIzinOff();
        String actualMsg2 = izinOffPage.getTextErrorAlasanIzinOff();

        // Lakukan verifikasi
        Assert.assertEquals(actualMsg1, expectedMsg1, "Notifikasi pertama tidak sesuai");
        Assert.assertEquals(actualMsg2, expectedMsg2, "Notifikasi kedua tidak sesuai");
    }

    @And("Pengguna1 merefresh halaman izin off")
    public void refresh() throws InterruptedException {
        izinOffPage.refreshHalamanIzinOff();
    }
}
