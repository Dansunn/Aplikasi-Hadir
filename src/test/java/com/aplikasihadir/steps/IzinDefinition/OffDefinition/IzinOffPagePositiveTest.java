package com.aplikasihadir.steps.IzinDefinition.OffDefinition;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.Izin.IzinOffPage;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class IzinOffPagePositiveTest {
    private WebDriver driver;
    private IzinOffPage izinOffPage;
    private WebDriverWait wait;

    public IzinOffPagePositiveTest() {
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        izinOffPage = new IzinOffPage(driver);
    }

    @Given("Pengguna klik tombol izin off dihalaman izin")
    public void clickMenuIzinOffButton() throws InterruptedException {
        izinOffPage.clickBtnMenuIzinOff();
    }

    @When("Pengguna klik tombol ajukan izin off")
    public void clickAjukanIzinOffButton() throws InterruptedException {
        izinOffPage.clickBtnAjukanIzinOff();
    }

    @And("Pengguna mengisi tanggal izin off")
    public void clickTanggalIzinOffButton() throws InterruptedException {
        izinOffPage.clickBtnKalender();
        izinOffPage.clickBtnTanggalIzinOffSaatIni();
    }

    @And("Pengguna mengisi field alasan off")
    public void fillAlasanOffTxtArea() throws InterruptedException {
        izinOffPage.fillTxtAreaAlasanIzinOff();
    }

    @And("Klik tombol ajukan setelah mengisi semua field")
    public void clickAjukanButton() throws InterruptedException {
        izinOffPage.clickBtnAjukan();
    }

    @Then("Akan muncul alert {string}")
    public void verifyElementTextIzinOff(String expected) throws InterruptedException {
        Assert.assertEquals(izinOffPage.getTextAlertIzinOff(), expected);
    }

    @And("Pengguna merefresh halaman izin off")
    public void refresh() throws InterruptedException {
        izinOffPage.refreshHalamanIzinOff();
    }
}
