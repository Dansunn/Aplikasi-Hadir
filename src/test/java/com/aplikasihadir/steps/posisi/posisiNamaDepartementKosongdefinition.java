package com.aplikasihadir.steps.posisi;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.LoginPages;
import com.aplikasihadir.pages.posisiNamaDepartementKosongpage;
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

public class posisiNamaDepartementKosongdefinition {
    private WebDriver driver;
    private posisiNamaDepartementKosongpage posisiNamaDepartementKosongPages;
    private LoginPages loginPages;

    public posisiNamaDepartementKosongdefinition() throws InterruptedException {
        this.driver= DriverSingleton.getDriver(BrowserType.CHROME);
        posisiNamaDepartementKosongPages = new posisiNamaDepartementKosongpage(driver);
        loginPages = new LoginPages(driver);
    }

    @Given("pengguna6 login dengan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }

    @And("pengguna tekan menu management")
    public void step01() throws InterruptedException{
        posisiNamaDepartementKosongPages.btnManagement();
    }

    @And("tekan sub menu posisi")
    public void step02() throws InterruptedException{
        posisiNamaDepartementKosongPages.klikbtnPosisi();
    }

    @When("menekan tombol tambahkan")
    public void step03() throws InterruptedException{
        posisiNamaDepartementKosongPages.btnTambahkan();
    }

    @And("mengisi posisi Admin 1")
    public void step04() throws InterruptedException{
        posisiNamaDepartementKosongPages.isiPosition();
    }

    @And("menekan tombol tambah")
    public void step05() throws InterruptedException{
        posisiNamaDepartementKosongPages.klikbtnTambah();
    }

    @Then("Data gagal ditambahkan")
    public void step06() throws InterruptedException{
        Thread.sleep(3000);
        WebElement txtAdmin1 = driver.findElement(By.xpath("//h6[contains(.,'Admin 1')]"));
        Assert.assertTrue(txtAdmin1.isDisplayed(), "Element Tidak Ditemukan");
    }
}
