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

public class IzinTerlambatPagePositiveTest {
    private WebDriver driver;
    private TerlambatPage terlambatPage;
    private WebDriverWait wait;

    public IzinTerlambatPagePositiveTest(){
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        terlambatPage = new TerlambatPage(driver);
    }


    @Given("Pengguna melakukan scroll mengarah ke menu izin")
    public void  scrollToMenuIzin() throws InterruptedException {
        terlambatPage.scroll();
    }

    @And("Pengguna klik menu izin")
    public void  clickMenuIzinButton() throws InterruptedException {
        terlambatPage.clickBtnMenuIzin();
    }

    @When("Pengguna klik tombol ajukan izin terlambat")
    public void clickAjukanIzinTerlambatButton() throws InterruptedException {
        terlambatPage.clickBtnAjukanIzinTerlambat();
    }

    @And("Pengguna isi field tanggal")
    public void clickTanggalButton() throws InterruptedException {
        terlambatPage.clickBtnTanggal();
        terlambatPage.clickBtnTanggalSaatIni();
    }

    @And("Pengguna isi field Jam")
    public void clickJamButton() throws InterruptedException {
        terlambatPage.clickBtnJam();
        terlambatPage.clickBtnJam7();
        terlambatPage.clickBtnMenit15();
    }

    @And("Pengguna isi field keterangan")
    public void fillKeteranganTextArea(){
        terlambatPage.fillTextAreaKeterangan();
    }

    @And("Pengguna klik tombol ajukan")
    public void clickAjukanButton() throws InterruptedException {
        terlambatPage.clickbtnAjukan();
    }


    @Then("Muncul notifikasi {string}")
    public void verifyElement(String expected) throws InterruptedException {
        Assert.assertEquals(terlambatPage.getTextAlertIzinTerlambat(), expected);
    }

    @And("Pengguna merefresh halaman")
    public void refreshBrowser(){
        terlambatPage.refreshBrowser();
    }

}
