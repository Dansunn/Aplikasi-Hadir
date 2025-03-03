package com.aplikasihadir.steps.importStatus;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.ImportStatus.ImportStatusPages;
import com.aplikasihadir.pages.LoginPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ImportStatus {
    private WebDriver driver;
    private ImportStatusPages importStatusPages;
    private LoginPages loginPages;

    public ImportStatus(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        importStatusPages = new ImportStatusPages(driver);
        loginPages = new LoginPages(driver);
    }

    @Given("Pengguna login ke website Hadir dengan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }

    @And("Pengguna menekan tombol menu Import di bagian kiri menu")
    public void clickMenuImport() throws InterruptedException {
        importStatusPages.clickDropdownImport();
    }

    @And("Pengguna menekan tombol submenu Import Status Aktif")
    public void clickSubMenuStatusAktif() throws InterruptedException {
        importStatusPages.clickDropdownStatusAktif();
    }

    @When("Pengguna menekan tombol choose file dan memilih file excel yang diinginkan")
    public void clickBtnChooseFile() throws InterruptedException {
        importStatusPages.setInputFileExcel();
    }

    @And("Pengguna menekan tombol import")
    public void clickBtnImport() throws InterruptedException {
        importStatusPages.clickBtnImport();
    }

    @Then("Muncul sebuah notifikasi {string}")
    public void verifyImportExcel(String expected){
        String actual = importStatusPages.getTextBerhasil();
        Assert.assertEquals(expected, actual);

    }
}
