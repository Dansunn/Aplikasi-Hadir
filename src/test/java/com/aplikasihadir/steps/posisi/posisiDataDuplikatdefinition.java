package com.aplikasihadir.steps.posisi;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.LoginPages;
import com.aplikasihadir.pages.posisiDataDuplikatpage;
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

public class posisiDataDuplikatdefinition {
    private WebDriver driver;
    private LoginPages loginPages;
    private posisiDataDuplikatpage posisiDataDuplikatPages;

    public posisiDataDuplikatdefinition() throws InterruptedException {
        this.driver= DriverSingleton.getDriver(BrowserType.CHROME);
        posisiDataDuplikatPages = new posisiDataDuplikatpage(driver);
        loginPages = new LoginPages(driver);
    }

    @Given("pengguna8 login dengan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }

    @And("Pengguna klik menu management")
    public void step01() throws InterruptedException{
        posisiDataDuplikatPages.btnManagement();
    }

    @And("Pengguna klik sub menu posisi")
    public void step02() throws InterruptedException{
        posisiDataDuplikatPages.klikbtnPosisi();
    }

    @When("Pengguna menekan tombol tambahkan")
    public void step03() throws InterruptedException{
        posisiDataDuplikatPages.btnTambahkan();
    }

    @And("Pengguna mengisi posisi Admin 1")
    public void step04() throws InterruptedException{
        posisiDataDuplikatPages.isiPosition();
    }

    @And("Pengguna memilih pilihan departement Credit Card")
    public void step05() throws InterruptedException{
        posisiDataDuplikatPages.pilihData();
    }

    @And("Pengguna menekan tombol tambah")
    public void step06() throws InterruptedException{
        posisiDataDuplikatPages.klikbtnTambah();
    }

    @Then("Pengguna gagal menambahkan data")
    public void step07() throws InterruptedException{
        Thread.sleep(3000);
        WebElement txtAdmin1 = driver.findElement(By.xpath("//input[@id = 'name' and @name = 'name' and @placeholder = 'Nama Position' and @type = 'text']"));
        Assert.assertTrue(txtAdmin1.isDisplayed(), "Element Tidak Ditemukan");
    }
}
