package com.aplikasihadir.steps.posisi;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.LoginPages;
import com.aplikasihadir.pages.posisiNamaPosisiKosongpage;
import com.aplikasihadir.pages.posisipage;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class posisiNamaPosisiKosongdefinition {
    private WebDriver driver;
    private LoginPages loginPages;
    private posisiNamaPosisiKosongpage posisiNamaPosisiKosongPages;

    public posisiNamaPosisiKosongdefinition() throws InterruptedException {
        this.driver= DriverSingleton.getDriver(BrowserType.CHROME);
        posisiNamaPosisiKosongPages = new posisiNamaPosisiKosongpage(driver);
        loginPages = new LoginPages(driver);
    }

    @Given("pengguna5 login dengan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }

    @And("klik menu management.")
    public void step01() throws InterruptedException{
        posisiNamaPosisiKosongPages.btnManagement();
    }

    @And("Admin tekan sub menu posisi")
    public void step02() throws InterruptedException{
        posisiNamaPosisiKosongPages.klikbtnPosisi();
    }

    @When("tekan tombol tambahkan")
    public void step03() throws InterruptedException{
        posisiNamaPosisiKosongPages.btnTambahkan();
    }

    @And("Admin pilih pilihan departement Credit Card")
    public void step04() throws InterruptedException{
        posisiNamaPosisiKosongPages.pilihData();
    }

    @And("tekan tombol tambah")
    public void step05() throws InterruptedException{
        posisiNamaPosisiKosongPages.klikbtnTambah();
    }

    @Then("Posisi gagal ditambahkan")
    public void step06() throws InterruptedException{
        Thread.sleep(3000);
        WebElement txtgagalkosongan = driver.findElement(By.xpath("//*[@id=\"alert-slide-description\"]/div[2]/div"));
        Assert.assertTrue(txtgagalkosongan.isDisplayed(), "Element Tidak Ditemukan");
    }
}
