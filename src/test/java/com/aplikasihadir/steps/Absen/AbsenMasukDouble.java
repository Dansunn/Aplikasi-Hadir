package com.aplikasihadir.steps.Absen;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.AbsenMasuk_AbsenKeluar.LoginMobilePages;
import com.aplikasihadir.pages.AbsenMasuk_AbsenKeluar.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AbsenMasukDouble {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginMobilePages loginMobilePages;

    public AbsenMasukDouble(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPage = new MainPage(driver);
        loginMobilePages = new LoginMobilePages(driver);
    }

    @Given("User melakukan login dengan email {string} dan password {string}")
    public void login(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/absen/login");
        loginMobilePages.fillEmail(email);
        loginMobilePages.fillPassword(password);
        loginMobilePages.clickBtnMasuk();
    }

    @Then("User mencoba mencari tombol masuk dan tombol masuk sudah tidak ada")
    public void verifyBtnAbsenMasuk() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(mainPage.isBtnAbsenMasukNotDisplayed(), "Button Absen Masuk masih ada !!");
    }
}
