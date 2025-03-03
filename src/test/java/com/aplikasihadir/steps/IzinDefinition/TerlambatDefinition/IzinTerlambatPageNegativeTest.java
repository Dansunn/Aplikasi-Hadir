package com.aplikasihadir.steps.IzinDefinition.TerlambatDefinition;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.Izin.TerlambatPage;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IzinTerlambatPageNegativeTest {
    private WebDriver driver;
    private TerlambatPage terlambatPage;
    private WebDriverWait wait;

    public IzinTerlambatPageNegativeTest(){
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        terlambatPage = new TerlambatPage(driver);
    }


    @Given("Pengguna1 klik tombol ajukan izin terlambat")
    public void  clickTombolAjukanIzinTerlambat() throws InterruptedException {
        terlambatPage.clickBtnAjukanIzinTerlambat();
    }

    @When("Pengguna1 klik tombol ajukan")
    public void  clickTombolAjukan() throws InterruptedException {
        terlambatPage.clickbtnAjukan();
    }

    @Then("Muncul notifikasi {string}, {string}, {string}")
        public void verifyElementText (String expectedMsg1, String expectedMsg2, String expectedMsg3){
            // Ambil teks dari notifikasi yang muncul
            String actualMsg1 = terlambatPage.getTextErrorTanggalHarusDiisi();
            String actualMsg2 = terlambatPage.getTextErrorJamHarusDiisi();
            String actualMsg3 = terlambatPage.getTextErrorKeteranganHarusDiisi();

            // Lakukan verifikasi
            Assert.assertEquals(actualMsg1, expectedMsg1, "Notifikasi pertama tidak sesuai");
            Assert.assertEquals(actualMsg2, expectedMsg2, "Notifikasi kedua tidak sesuai");
            Assert.assertEquals(actualMsg3, expectedMsg3, "Notifikasi ketiga tidak sesuai");
        }

    @And("Pengguna1 merefresh halaman")
    public void refreshBrowser(){
        terlambatPage.refreshBrowser();
    }

}
