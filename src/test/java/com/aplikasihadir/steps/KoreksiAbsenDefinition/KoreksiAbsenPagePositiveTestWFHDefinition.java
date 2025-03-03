package com.aplikasihadir.steps.KoreksiAbsenDefinition;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.koreksiAbsen.KoreksiAbsenPage;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class KoreksiAbsenPagePositiveTestWFHDefinition {
    private WebDriver driver;
    private KoreksiAbsenPage koreksiAbsenPage;
    private WebDriverWait wait;

    public KoreksiAbsenPagePositiveTestWFHDefinition(){
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        koreksiAbsenPage = new KoreksiAbsenPage(driver);
    }

    @Given("Pengguna1 menekan tombol Ajukan Koreksi")
    public void clickAjukanKoreksiButton() throws InterruptedException {
        koreksiAbsenPage.clickButtonAjukanKoreksi();
    }

    @When("Pengguna1 menekan  field Jam Masuk")
    public void  clickJamMasukButton() throws InterruptedException {
        koreksiAbsenPage.clickButtonJamMasuk();
    }

    @And("Pengguna1 memilih Tahun, Bulan, Tanggal")
    public void clickTahun_Bulan_tanggal() throws InterruptedException {
        koreksiAbsenPage.clickButtonDropTahun();
        koreksiAbsenPage.clickTahun2024();
        koreksiAbsenPage.clickNextBulan();
        koreksiAbsenPage.clickTgl19Feb();
    }

    @And("Pengguna1 memilih Jam dan Menit")
    public void clickJam_Menit() throws InterruptedException {
        koreksiAbsenPage.clickJam07();
        koreksiAbsenPage.clickMenit15();
    }

    @And("Pengguna1 memilih field Jam Keluar")
    public void clickFieldJamKeluar() throws InterruptedException {
        koreksiAbsenPage.clickJamKeluar();
    }

    @And("Pengguna1 memilih Tahun, Bulan, Tanggal Jam Keluar")
    public void clickTahun_Bulan_TanggalJamKeluar() throws InterruptedException {
        koreksiAbsenPage.clickButtonDropTahun();
        koreksiAbsenPage.clickTahun2024JamKeluar();
        koreksiAbsenPage.clickTgl19Feb();
    }

    @And("Pengguna1 memilih Jam dan Menit Jam Keluar")
    public void clickJam_MenitKeluar() throws InterruptedException {
        koreksiAbsenPage.clickJam16();
        koreksiAbsenPage.clickMenit30();
    }

    @And("Pengguna1 menekan field  Tipe Absen")
    public void clickFieldTipeAbsen() throws InterruptedException {
        koreksiAbsenPage.clickButtonFieldTipeAbsen();
    }

    @And("Pengguna1 memilih WFH")
    public void clickWFHButton() throws InterruptedException {
        koreksiAbsenPage.clickWFH();
    }

    @And("Pengguna1 menekan tombol Ajukan")
    public void clickAjukanButton() throws InterruptedException {
        koreksiAbsenPage.clickButtonAjukan();
    }

    @Then("Pengguna1 akan melihat text Total akan bertambah")
    public void verifyElement(){
        WebElement saldoElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[1]/p[2]"));
        int txtTotalSebelum = koreksiAbsenPage.totalSebelumTxt();
        int txtTotalSesudah = Integer.parseInt(saldoElement.getText().replaceAll("[^0-9]", ""));
        Assert.assertNotEquals("Saldo tidak bertambah setelah transaksi!", txtTotalSesudah > txtTotalSebelum);
        System.out.println("✅ Verifikasi sukses! Jumlah List Total Bertambah " + txtTotalSebelum + " menjadi " + txtTotalSesudah);
    }


}
