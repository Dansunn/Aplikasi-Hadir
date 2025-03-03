package com.aplikasihadir.steps.unitSetting;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.LoginPages;
import com.aplikasihadir.pages.login;
import com.aplikasihadir.pages.unitSettingpage;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class unitsettingdefinition {
    private WebDriver driver;
    private LoginPages loginPages;
    private unitSettingpage unitSettingPages;

    public unitsettingdefinition(){
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        unitSettingPages = new unitSettingpage(driver);
        loginPages = new LoginPages(driver);

    }

    @Given("Pengguna memasukkan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }
    @And ("Admin tekan menu management")
    public void step01() throws InterruptedException {
        unitSettingPages.btnManagement();
    }

    @And("Admin klik sub menu unit setting")
    public void step02() throws InterruptedException {
        unitSettingPages.klikbtnUnitSetting();
    }

    @When("Admin tekan tombol tambahkan")
    public void step03() throws InterruptedException {
        unitSettingPages.klikbtnTambahkan();
    }

    @And("Admin memilih pilihan Credit Card")
    public void step04() throws InterruptedException {

        unitSettingPages.pilihData();

    }

    @And("Admin tekan tombol tambah")
    public void step05() throws InterruptedException {
        unitSettingPages.klikbtnTambah();
    }

    @Then("Unit setting berhasil ditambahkan")
    public void step06(){
        WebElement txtCreditCard = driver.findElement(By.xpath("//h6[contains(.,'Credit Card')]"));
        Assert.assertTrue(txtCreditCard.isDisplayed(),"Element Tidak Ditemukan");
    }
}
