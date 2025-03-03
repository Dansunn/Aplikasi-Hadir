package com.aplikasihadir.steps.posisi;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.LoginPages;
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

public class posisidefinition {
    private WebDriver driver;
    private LoginPages loginPages;
    private posisipage posisiPages;

    public posisidefinition() throws InterruptedException {
        this.driver= DriverSingleton.getDriver(BrowserType.CHROME);
        posisiPages = new posisipage(driver);
        loginPages = new LoginPages(driver);

    }

    @Given("pengguna4 login dengan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }

    @And("Admin klik menu management")
    public void step01() throws InterruptedException{
        posisiPages.btnManagement();
    }

    @And("Admin klik sub menu posisi")
    public void step02() throws InterruptedException{
        posisiPages.klikbtnPosisi();
    }

    @When("Admin menekan tombol tambahkan")
    public void step03() throws InterruptedException{
        posisiPages.btnTambahkan();
    }

    @And("Admin mengisi posisi Admin 1")
    public void step04() throws InterruptedException{
        posisiPages.isiPosition();
    }

    @And("Admin memilih pilihan departement Credit Card")
    public void step05() throws InterruptedException{
        posisiPages.pilihData();
    }

    @And("Admin menekan tombol tambah")
    public void step06() throws InterruptedException{
        posisiPages.klikbtnTambah();
    }

    @Then("Posisi berhasil ditambahkan")
    public void step07() throws InterruptedException{
        Thread.sleep(3000);
        WebElement txtAdmin1 = driver.findElement(By.xpath("//input[@id = 'name' and @name = 'name' and @placeholder = 'Nama Position' and @type = 'text']"));
        Assert.assertTrue(txtAdmin1.isDisplayed(), "Element Tidak Ditemukan");
    }
}
