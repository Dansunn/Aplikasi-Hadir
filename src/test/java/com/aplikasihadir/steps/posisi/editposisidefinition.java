package com.aplikasihadir.steps.posisi;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.LoginPages;
import com.aplikasihadir.pages.editposisipage;
import com.aplikasihadir.pages.posisipage;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class editposisidefinition {
    private WebDriver driver;
    private editposisipage editposisiPages;
    private LoginPages loginPages;

    public editposisidefinition() throws InterruptedException {
        this.driver= DriverSingleton.getDriver(BrowserType.CHROME);
        editposisiPages = new editposisipage(driver);
        loginPages = new LoginPages(driver);
    }

    @Given("pengguna9 login dengan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }

    @And("Tekan klik menu management")
    public void step01() throws InterruptedException{
        editposisiPages.btnManagement();
    }
    @And("Pengguna tekan sub menu posisi")
    public void step02() throws InterruptedException{
        editposisiPages.klikbtnPosisi();
       // editposisiPages.scrollToTop();
    }
    @When("Admin klik titik tiga pada posisi yang akan diedit")
    public void step03() throws InterruptedException{
        editposisiPages.kliktitiktiga();
    }
    @And("Admin klik edit")
    public void step04() throws InterruptedException{
        editposisiPages.klikedit();
    }
    @And("Admin mengedit Admin 1 menjadi Admin 2")
    public void step05() throws InterruptedException{
        editposisiPages.editposisi();
    }
    @And("Admin menekan tombol simpan")
    public void step06() throws InterruptedException{
        editposisiPages.simpan();
    }
    @Then("List yang diperbaharui menjadi {string}")
    public void step07(String expected) throws InterruptedException {
        editposisiPages.scrollToTop();
        Assert.assertEquals(editposisiPages.verify(), expected);
    }
}
