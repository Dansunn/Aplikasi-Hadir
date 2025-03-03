package com.aplikasihadir.steps.Absen;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.AbsenMasuk_AbsenKeluar.LoginMobilePages;
import com.aplikasihadir.pages.AbsenMasuk_AbsenKeluar.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AbsenKeluarDouble {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginMobilePages loginMobilePages;

    public AbsenKeluarDouble(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPage = new MainPage(driver);
        loginMobilePages = new LoginMobilePages(driver);
    }

    @Given("User mencoba mencari tombol keluar")
    public void ScrollToKeluar(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 1500);");
    }

    @Then("Ternyata tombol keluar sudah tidak ada")
    public void verifyTombolKeluar() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(mainPage.isBtnKeluarNotDisplayed(), "Button Keluar masih ada !!");
    }
}
