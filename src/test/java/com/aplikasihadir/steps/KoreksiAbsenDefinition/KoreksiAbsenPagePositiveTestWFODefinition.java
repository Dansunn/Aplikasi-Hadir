package com.aplikasihadir.steps.KoreksiAbsenDefinition;

import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.AbsenMasuk_AbsenKeluar.LoginMobilePages;
import com.aplikasihadir.pages.LoginPages;
import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.koreksiAbsen.KoreksiAbsenPage;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class KoreksiAbsenPagePositiveTestWFODefinition {
    private WebDriver driver;
    private KoreksiAbsenPage koreksiAbsenPage;
    private LoginMobilePages loginMobilePages;
    private WebDriverWait wait;

    public KoreksiAbsenPagePositiveTestWFODefinition(){
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        koreksiAbsenPage = new KoreksiAbsenPage(driver);
        loginMobilePages = new LoginMobilePages(driver);
    }

    @Given("Pengguna Login menggunakan email {string} dan password {string}")
    public void doLogin(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/absen/login");
        loginMobilePages.fillEmail(email);
        loginMobilePages.fillPassword(password);
        loginMobilePages.clickBtnMasuk();
    }

    @And("Pengguna melakukan scroll mengarah ke menu koreksi absen")
    public void scrollToMenuKoreksiAbsen() throws InterruptedException {
        koreksiAbsenPage.scrollToTop();
    }

    @And("Pengguna menekan menu Koreksi Absen")
    public void clickMenuKoreksiAbsen() throws InterruptedException {
        koreksiAbsenPage.clickButtonMenuKoreksiAbsen();
    }

    @When("Pengguna menekan tombol Ajukan Koreksi")
    public void clickAjukanKoreksiButton() throws InterruptedException {
        koreksiAbsenPage.clickButtonAjukanKoreksi();
    }

    @And("Pengguna menekan  field Jam Masuk")
    public void  clickJamMasukButton() throws InterruptedException {
        koreksiAbsenPage.clickButtonJamMasuk();
    }

    @And("Pengguna memilih Tahun, Bulan, Tanggal")
    public void clickTahun_Bulan_tanggal() throws InterruptedException {
        koreksiAbsenPage.clickButtonDropTahun();
        koreksiAbsenPage.clickTahun2024();
        koreksiAbsenPage.clickNextBulan();
        koreksiAbsenPage.clickTgl19Feb();
    }

    @And("Pengguna memilih Jam dan Menit")
    public void clickJam_Menit() throws InterruptedException {
        koreksiAbsenPage.clickJam07();
        koreksiAbsenPage.clickMenit15();
    }

    @And("Pengguna memilih field Jam Keluar")
    public void clickFieldJamKeluar() throws InterruptedException {
        koreksiAbsenPage.clickJamKeluar();
    }

    @And("Pengguna memilih Tahun, Bulan, Tanggal Jam Keluar")
    public void clickTahun_Bulan_TanggalJamKeluar() throws InterruptedException {
        koreksiAbsenPage.clickButtonDropTahun();
        koreksiAbsenPage.clickTahun2024JamKeluar();
        koreksiAbsenPage.clickTgl19Feb();
    }

    @And("Pengguna memilih Jam dan Menit Jam Keluar")
    public void clickJam_MenitKeluar() throws InterruptedException {
        koreksiAbsenPage.clickJam16();
        koreksiAbsenPage.clickMenit30();
    }

    @And("Pengguna menekan field  Tipe Absen")
    public void clickFieldTipeAbsen() throws InterruptedException {
        koreksiAbsenPage.clickButtonFieldTipeAbsen();
    }

    @And("Pengguna memilih WFO")
    public void clickWFHButton() throws InterruptedException {
        koreksiAbsenPage.clickWFO();
    }

    @And("Pengguna menekan tombol Ajukan")
    public void clickAjukanButton() throws InterruptedException {
        koreksiAbsenPage.clickButtonAjukan();
    }

    @Then("Pengguna akan melihat text Total akan bertambah")
    public void verifyElement(){
        WebElement saldoElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[1]/p[2]"));
        int txtTotalSebelum = koreksiAbsenPage.totalSebelumTxt();
        int txtTotalSesudah = Integer.parseInt(saldoElement.getText().replaceAll("[^0-9]", ""));
        Assert.assertNotEquals("Saldo tidak bertambah setelah transaksi!", txtTotalSesudah > txtTotalSebelum);
        System.out.println("✅ Verifikasi sukses! Jumlah List Total Bertambah " + txtTotalSebelum + " menjadi " + txtTotalSesudah);
    }
}
