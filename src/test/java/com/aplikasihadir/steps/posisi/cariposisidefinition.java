package com.aplikasihadir.steps.posisi;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.LoginPages;
import com.aplikasihadir.pages.cariposisipage;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.editposisipage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class cariposisidefinition {
    private WebDriver driver;
    private cariposisipage cariposisiPages;
    private LoginPages loginPages;

    public cariposisidefinition() throws InterruptedException {
        this.driver= DriverSingleton.getDriver(BrowserType.CHROME);
        cariposisiPages = new cariposisipage(driver);
        loginPages = new LoginPages(driver);
    }

    @Given("pengguna12 login dengan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }

    @And("Admin tekan menu management,")
    public void step01() throws InterruptedException{
        cariposisiPages.btnManagement();
    }

    @And("Pengguna tekan sub menu posisi.")
    public void step02() throws InterruptedException{
        cariposisiPages.klikbtnPosisi();
    }

    @When("Ketik nama Admin 2")
    public void step03() throws InterruptedException{
        cariposisiPages.textcari();
    }

    @And("Klik tombol search")
    public void step04() throws InterruptedException{
        cariposisiPages.kliksearch();
    }

    @Then("Data Ditemukan")
    public void step05() throws InterruptedException{
        Thread.sleep(3000);
        WebElement cari = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(cari.isDisplayed(), "Element Tidak Ditemukan");
    }
}
