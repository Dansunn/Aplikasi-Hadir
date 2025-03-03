package com.aplikasihadir.steps.IzinDefinition.PulangCepatDefinition;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.Izin.PulangCepatPage;
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

public class IzinPulangCepatPagePositiveTest {
    private WebDriver driver;
    private PulangCepatPage pulangCepatPage;
    private WebDriverWait wait;

    public IzinPulangCepatPagePositiveTest(){
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        pulangCepatPage = new PulangCepatPage(driver);
    }


    @Given("Pengguna1 klik tombol pulang cepat dihalaman izin")
    public void  clickMenuPulangCepatButton() throws InterruptedException {
        pulangCepatPage.clickBtnMenuPulangCepat();
    }

    @When("Pengguna1 klik tombol ajukan izin pulang cepat")
    public void  clickAjukanIzinPulangCepatButton() throws InterruptedException {
        pulangCepatPage.clickBtnAjukanPulangCepat();
    }

    @And("Pengguna1 isi field tanggal")
    public void clickTanggalPulangCepatButton() throws InterruptedException {
        pulangCepatPage.clickBtnKalender();
        pulangCepatPage.clickBtnTanggalPulangCepatSaatIni();
    }

    @And("Pengguna1 isi field Jam")
    public void clickJamPulangCepatButton() throws InterruptedException {
        pulangCepatPage.clickBtnJam();
        pulangCepatPage.clickBtnJam15();
        pulangCepatPage.clickBtnMenit15();
    }

    @And("Pengguna1 isi field keterangan")
    public void fillKeteranganPulangCepat() throws InterruptedException {
        pulangCepatPage.fillTxtAreaKeterangan();
    }

    @And("Klik tombol ajukan")
    public void clickTombolAjukanPulangCepat() throws InterruptedException {
        pulangCepatPage.clickbtnAjukan();
    }

    @Then("Text Total akan bertambah")
    public void verifyElement(){
        WebElement totalElement = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Pulang Cepat'])[1]/following::p[2]"));
        int txtTotalSebelum = pulangCepatPage.totalSebelumTxt();
        int txtTotalSesudah = Integer.parseInt(totalElement.getText().replaceAll("[^0-9]", ""));
        Assert.assertNotEquals("Total Tidak bertambah ketika berhasil melakukan pengajuan", txtTotalSesudah > txtTotalSebelum);
        System.out.println("✅ Verifikasi sukses! Jumlah List Total Bertambah " + txtTotalSebelum + " menjadi " + txtTotalSesudah);
    }

}
