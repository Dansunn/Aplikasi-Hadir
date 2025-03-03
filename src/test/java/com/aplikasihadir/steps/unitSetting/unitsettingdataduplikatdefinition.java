package com.aplikasihadir.steps.unitSetting;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.LoginPages;
import com.aplikasihadir.pages.unitSettingDataDuplikatpage;
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

public class unitsettingdataduplikatdefinition {
    private WebDriver driver;
    private LoginPages loginPages;
    private unitSettingDataDuplikatpage unitSettingDataDuplikatPages;

    public unitsettingdataduplikatdefinition() {
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        unitSettingDataDuplikatPages = new unitSettingDataDuplikatpage(driver);
        loginPages = new LoginPages(driver);
    }

    @Given("login dengan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }

    @And("tekan menu management")
        public void step01() throws InterruptedException {
            unitSettingDataDuplikatPages.btnManagement();
        }

    @And("tekan sub menu unit setting")
    public void step02() throws InterruptedException {
        unitSettingDataDuplikatPages.klikbtnUnitSetting();
    }

    @When("klik tombol tambahkan")
    public void step03() throws InterruptedException {
        unitSettingDataDuplikatPages.klikbtnTambahkan();
    }

    @And("pilih pilihan Credit Card")
    public void step04() throws InterruptedException {
        unitSettingDataDuplikatPages.pilihData();

    }

    @And("klik tombol tambah")
    public void step05() throws InterruptedException {
        unitSettingDataDuplikatPages.klikbtnTambah();
    }

    @Then("gagal ditambahkan")
    public void step06(){
        WebElement txtCreditCard = driver.findElement(By.xpath("//h6[contains(.,'Credit Card')]"));
        Assert.assertTrue(txtCreditCard.isDisplayed(),"Element Tidak Ditemukan");
    }
}
