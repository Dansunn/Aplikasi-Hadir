package com.aplikasihadir.steps.unitSetting;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.LoginPages;
import com.aplikasihadir.pages.unitSettingHapuspage;
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

public class unitsettinghapusdefinition {
    private WebDriver driver;
    private LoginPages loginPages;
    private unitSettingHapuspage unitSettingHapusPages;

    public unitsettinghapusdefinition(){
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        unitSettingHapusPages = new unitSettingHapuspage(driver);
        loginPages = new LoginPages(driver);
    }


    @Given("pengguna3 login dengan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }

    @And("tekan menu management.")
    public void step01() throws InterruptedException {
        unitSettingHapusPages.btnManagement();
    }

    @And("klik sub menu unit setting")
    public void step02() throws InterruptedException {
        unitSettingHapusPages.klikbtnUnitSetting();
    }

    @When("Admin tekan tombol hapus pada data yang akan dihapus")
    public void step03() throws InterruptedException {
        unitSettingHapusPages.btnHapus();
    }

    @Then("Unit setting berhasil dihapus")
    public void step06(){
        WebElement BtnHapus = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr[1]/td[5]/button"));
        Assert.assertTrue(BtnHapus.isDisplayed(),"Element Tidak Ditemukan");
    }
}
