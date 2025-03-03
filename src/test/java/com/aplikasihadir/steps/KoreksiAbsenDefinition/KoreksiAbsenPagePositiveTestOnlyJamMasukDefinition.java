package com.aplikasihadir.steps.KoreksiAbsenDefinition;

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

public class KoreksiAbsenPagePositiveTestOnlyJamMasukDefinition {
    private WebDriver driver;
    private KoreksiAbsenPage koreksiAbsenPage;
    private WebDriverWait wait;

    public KoreksiAbsenPagePositiveTestOnlyJamMasukDefinition(){
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        koreksiAbsenPage = new KoreksiAbsenPage(driver);
    }


    @Given("Pengguna3 menekan  field Jam Masuk")
    public void  clickJamMasukButton() throws InterruptedException {
        koreksiAbsenPage.clickButtonJamMasuk();
    }

    @When("Pengguna3 memilih Tahun, Bulan, Tanggal")
    public void clickTahun_Bulan_tanggal() throws InterruptedException {
        koreksiAbsenPage.clickButtonDropTahun();
        koreksiAbsenPage.clickTahun2024();
        koreksiAbsenPage.clickNextBulan();
        koreksiAbsenPage.clickTgl19Feb();
    }

    @And("Pengguna3 memilih Jam dan Menit")
    public void clickJam_Menit() throws InterruptedException {
        koreksiAbsenPage.clickJam07();
        koreksiAbsenPage.clickMenit15();
    }

    @And("Pengguna3 menekan tombol Ajukan")
    public void clickAjukanButton() throws InterruptedException {
        koreksiAbsenPage.clickButtonAjukan();
    }

    @Then("Pengguna3 akan melihat text Total akan bertambah")
    public void verifyElement(){
        WebElement saldoElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[1]/p[2]"));
        int txtTotalSebelum = koreksiAbsenPage.totalSebelumTxt();
        int txtTotalSesudah = Integer.parseInt(saldoElement.getText().replaceAll("[^0-9]", ""));
        Assert.assertNotEquals("Saldo tidak bertambah setelah transaksi!", txtTotalSesudah > txtTotalSebelum);
        System.out.println("✅ Verifikasi sukses! Jumlah List Total Bertambah " + txtTotalSebelum + " menjadi " + txtTotalSesudah);
    }

    @And("Pengguna 3 keluar dari halaman koreksi absen")
    public void clickBackButton() throws InterruptedException {
        koreksiAbsenPage.clickButtonBack();
    }
}
