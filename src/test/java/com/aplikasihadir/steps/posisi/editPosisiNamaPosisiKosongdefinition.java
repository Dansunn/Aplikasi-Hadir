package com.aplikasihadir.steps.posisi;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.LoginPages;
import com.aplikasihadir.pages.editposisiNamaPosisiKosongpage;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class editPosisiNamaPosisiKosongdefinition {
    private WebDriver driver;
    private LoginPages loginPages;
    private editposisiNamaPosisiKosongpage editposisiNamaPosisiKosongPages;

    public editPosisiNamaPosisiKosongdefinition() throws InterruptedException {
        this.driver= DriverSingleton.getDriver(BrowserType.CHROME);
        editposisiNamaPosisiKosongPages = new editposisiNamaPosisiKosongpage(driver);
        loginPages = new LoginPages(driver);
    }

    @Given("pengguna10 login dengan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }

    @And("klik menu management!")
    public void step01() throws InterruptedException{
        editposisiNamaPosisiKosongPages.btnManagement();
    }
    @And("Pengguna klik sub menu posisi.")
    public void step02() throws InterruptedException{
        editposisiNamaPosisiKosongPages.klikbtnPosisi();
        // editposisiPages.scrollToTop();
    }
    @When("Admin tekan titik tiga pada posisi yang akan diedit")
    public void step03() throws InterruptedException{
        editposisiNamaPosisiKosongPages.kliktitiktiga();
    }
    @And("Admin tekan edit")
    public void step04() throws InterruptedException{
        editposisiNamaPosisiKosongPages.klikedit();
    }
    @And("Admin mengosongkan nama posisi")
    public void step05() throws InterruptedException{
        editposisiNamaPosisiKosongPages.editposisi();
    }
    @And("Admin klik tombol simpan")
    public void step06() throws InterruptedException{
        editposisiNamaPosisiKosongPages.simpan();
    }
    @Then("Posisi gagal diedit")
    public void step07() throws InterruptedException{
        Thread.sleep(3000);
        WebElement txtAdmin1 = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        Assert.assertTrue(txtAdmin1.isDisplayed(), "Element Tidak Ditemukan");
    }
}
