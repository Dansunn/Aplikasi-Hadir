package com.aplikasihadir.steps.unitSetting;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.LoginPages;
import com.aplikasihadir.pages.unitSettingDataKosongpage;
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

public class unitsettingdatakosongdefinition {
    private WebDriver driver;
    private LoginPages loginPages;
    private unitSettingDataKosongpage unitSettingDataKosongPages;

    public unitsettingdatakosongdefinition(){
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        unitSettingDataKosongPages = new unitSettingDataKosongpage(driver);
        loginPages = new LoginPages(driver);
    }


    @Given("Pengguna login dengan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }

    @And("klik menu management")
    public void step01() throws InterruptedException {
        unitSettingDataKosongPages.btnManagement();
    }

    @And("Admin tekan sub menu unit setting")
    public void step02() throws InterruptedException {
        unitSettingDataKosongPages.klikbtnUnitSetting();
    }

    @When("Admin klik tombol tambahkan")
    public void step03() throws InterruptedException {
        Thread.sleep(2000);
        unitSettingDataKosongPages.klikbtnTambahkan();
    }

    @And("Admin mengisi dengan data kosong")
    public void step04() throws InterruptedException {
        unitSettingDataKosongPages.klikbtnTambah();
    }

    @And("Admin klik tombol tambah")
    public void step05() throws InterruptedException {
        unitSettingDataKosongPages.klikbtnTambah();
    }

    @Then("Unit setting gagal ditambahkan")
    public void step06(){
        WebElement txtgagalkosongan = driver.findElement(By.xpath("//div[contains(text(),'Gagal Menambahkan Departemens')]"));
        Assert.assertTrue(txtgagalkosongan.isDisplayed(),"Element Tidak Ditemukan");
    }

}
