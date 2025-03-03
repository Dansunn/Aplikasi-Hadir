package com.aplikasihadir.steps.posisi;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.LoginPages;
import com.aplikasihadir.pages.posisiNamaPosisiDanDepartementKosongpage;
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

public class posisiNamaPosisiDanDepartementKosongdefinition {
    private WebDriver driver;
    private LoginPages loginPages;
    private posisiNamaPosisiDanDepartementKosongpage posisiNamaPosisiDanDepartementKosongPages;

    public posisiNamaPosisiDanDepartementKosongdefinition() throws InterruptedException {
        this.driver= DriverSingleton.getDriver(BrowserType.CHROME);
        posisiNamaPosisiDanDepartementKosongPages = new posisiNamaPosisiDanDepartementKosongpage(driver);
        loginPages = new LoginPages(driver);
    }

    @Given("pengguna7 login dengan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }

    @And("pengguna klik menu management")
    public void step01() throws InterruptedException{
        posisiNamaPosisiDanDepartementKosongPages.btnManagement();
    }
    @And("pengguna tekan sub menu posisi")
    public void step02() throws InterruptedException{
        posisiNamaPosisiDanDepartementKosongPages.klikbtnPosisi();
    }
    @When("pengguna menekan tombol tambahkan")
    public void step03() throws InterruptedException{
        posisiNamaPosisiDanDepartementKosongPages.btnTambahkan();
    }
    @And("pengguna menekan tombol tambah")
    public void step04() throws InterruptedException{
        posisiNamaPosisiDanDepartementKosongPages.klikbtnTambah();
    }
    @Then("pengguna gagal menambahkan data")
    public void step05() throws InterruptedException{
        Thread.sleep(3000);
        WebElement txtgagalkosongan = driver.findElement(By.xpath("//*[@id=\"alert-slide-description\"]/div[2]/div"));
        Assert.assertTrue(txtgagalkosongan.isDisplayed(), "Element Tidak Ditemukan");
    }
}
