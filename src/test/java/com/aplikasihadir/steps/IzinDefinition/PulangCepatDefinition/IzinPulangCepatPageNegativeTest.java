package com.aplikasihadir.steps.IzinDefinition.PulangCepatDefinition;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.Izin.PulangCepatPage;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IzinPulangCepatPageNegativeTest {
    private WebDriver driver;
    private PulangCepatPage pulangCepatPage;
    private WebDriverWait wait;

    public IzinPulangCepatPageNegativeTest(){
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        pulangCepatPage = new PulangCepatPage(driver);
    }


    @Given("Pengguna2 klik tombol ajukan izin pulang cepat")
    public void  clickAjukanIzinPulangCepat() throws InterruptedException {
        pulangCepatPage.clickBtnAjukanPulangCepat();
    }

    @When("Pengguna2 klik tombol ajukan")
    public void  clickAnjukanPulangCepatButton() throws InterruptedException {
        pulangCepatPage.clickbtnAjukan();
    }

    @Then("Muncul pesan error {string}, {string}, {string}")
    public void verifyElementText (String expectedMsg1, String expectedMsg2, String expectedMsg3){
        // Ambil teks dari notifikasi yang muncul
        String actualMsg1 = pulangCepatPage.getTextErrorTanggalHarusDiisi();
        String actualMsg2 = pulangCepatPage.getTextErrorJamHarusDiisi();
        String actualMsg3 = pulangCepatPage.getTextErrorKeteranganHarusDiisi();

        // Lakukan verifikasi
        Assert.assertEquals(actualMsg1, expectedMsg1, "Notifikasi pertama tidak sesuai");
        Assert.assertEquals(actualMsg2, expectedMsg2, "Notifikasi kedua tidak sesuai");
        Assert.assertEquals(actualMsg3, expectedMsg3, "Notifikasi ketiga tidak sesuai");
    }

    @And("Pengguna2 merefresh halaman")
    public void refresh(){
        pulangCepatPage.refreshHalamanIzinPulangPage();
    }
}
