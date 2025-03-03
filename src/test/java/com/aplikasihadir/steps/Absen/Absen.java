package com.aplikasihadir.steps.Absen;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.AbsenMasuk_AbsenKeluar.LoginMobilePages;
import com.aplikasihadir.pages.AbsenMasuk_AbsenKeluar.LogoutMobilePages;
import com.aplikasihadir.pages.AbsenMasuk_AbsenKeluar.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class Absen {
    private WebDriver driver;
    private LoginMobilePages loginMobilePages;
    private MainPage mainPage;
    private LogoutMobilePages logoutMobilePages;

    public Absen() {
        driver = DriverSingleton.getDriver();
        loginMobilePages = new LoginMobilePages(driver);
        mainPage = new MainPage(driver);
        logoutMobilePages = new LogoutMobilePages(driver);
    }

    @Given("User melakukan login dengan {string} dan {string}")
    public void doLogin(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/absen/login");
        loginMobilePages.fillEmail(email);
        loginMobilePages.fillPassword(password);
        loginMobilePages.clickBtnMasuk();
    }

    @And("User klik tombol Absen Masuk")
    public void doClickAbsenMasukButton() throws InterruptedException {
        Thread.sleep(3000);
        mainPage.clickBtnAbsenMasuk();
    }

    @And("User klik tombol Kamera")
    public void doClickCameraButton() throws InterruptedException {
        Thread.sleep(4000);
        mainPage.clickBtnKamera();
    }

    @And("User mengisi form absen masuk dengan {string} dan {string}")
    public void doFillAbsenInForm(String status, String masuk) throws InterruptedException {
        Thread.sleep(4000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage.pilihTipeAbsen(status);
        if (!masuk.isEmpty()) {
            mainPage.fillNotes(masuk);
        }
        mainPage.scrollToBottom(true);
    }

    @And("User klik tombol Absen Masuk untuk submit absen")
    public void doSubmitAbsen() throws InterruptedException {
        mainPage.clickBtnAbsenMasukSetelahNotes();
    }

    @And("User menunggu halaman selesai dimuat ulang")
    public void doWaitPageLoaded() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Then("User melihat tanggal {string} pada history absensi")
    public void doNotSeeAbsenMasukButton(String expected) throws InterruptedException {
        String actual = mainPage.getTxtTanggalAbsen(expected);
        Assert.assertEquals(expected, actual, "Tanggal tidak sesuai !!");
    }

    @And("User menekan tombol keluar pada history absensi")
    public void doClickKeluarButton() throws InterruptedException {
        Thread.sleep(4000);
        mainPage.scrollDown();
        Thread.sleep(4000);
        mainPage.clickBtnKeluar();
    }

    @And("User mengisi {string} pada bagian notes pulang")
    public void doFillAbsenOutForm(String keluar) throws InterruptedException {
        Thread.sleep(4000);
        mainPage.noteKeluarOnFocus();
        if (!keluar.isEmpty()) {
            Thread.sleep(4000);
            mainPage.fillNotesKeluar(keluar);
        }
    }

    @And("User klik tombol Absen Keluar")
    public void doClickAbsenKeluarButton() throws InterruptedException {
        mainPage.clickBtnAbsenKeluar();
    }

    @And("User kembali menunggu halaman selesai dimuat ulang")
    public void doWaitPageLoadedAgain() throws InterruptedException {
        Thread.sleep(2000);
    }

    @And("User tidak lagi melihat tombol keluar")
    public void doNotSeeKeluarButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 1500);");
        Assert.assertTrue(mainPage.isBtnKeluarNotDisplayed(), "Button Keluar masih ada !!");
    }

    @And("User melakukan logout")
    public void doLogout() throws InterruptedException {
        Thread.sleep(4000);
        mainPage.onEscape();
        Thread.sleep(4000);
        mainPage.scrollUp();
        Thread.sleep(4000);
        logoutMobilePages.clickBtnSideMenu();
        Thread.sleep(4000);
        logoutMobilePages.clickBtnLogout();
    }


}
