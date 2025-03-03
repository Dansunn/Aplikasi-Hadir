package com.aplikasihadir.steps.posisi;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.pages.LoginPages;
import com.aplikasihadir.pages.hapusposisipage;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class hapusposisidefinition {
    private WebDriver driver;
    private LoginPages loginPages;
    private hapusposisipage hapusposisiPages;

    public hapusposisidefinition() throws InterruptedException {
        this.driver= DriverSingleton.getDriver(BrowserType.CHROME);
        hapusposisiPages = new hapusposisipage(driver);
        loginPages = new LoginPages(driver);

    }

    @Given("pengguna11 login dengan email {string} dan password {string}")
    public void loginHadir(String email, String password) throws InterruptedException {
        driver.get("https://magang.dikahadir.com/authentication/login");
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
        loginPages.clickBtnMasuk();
    }

    @And("tekan menu management,")
    public void step01() throws InterruptedException{
        hapusposisiPages.btnManagement();
    }
    @And("Pengguna tekan sub menu posisi,")
    public void step02() throws InterruptedException{
        hapusposisiPages.klikbtnPosisi();
        // editposisiPages.scrollToTop();
    }
    @When("Admin klik titik tiga pada posisi yang akan dihapus,")
    public void step03() throws InterruptedException{
        hapusposisiPages.kliktitiktiga();
    }
    @And("Admin klik hapus")
    public void step04() throws InterruptedException{
        hapusposisiPages.klikhapus();
    }

    @And("Admin klik tombol ya")
    public void step05() throws InterruptedException{
        hapusposisiPages.ya();
    }

    @Then("Data terhapus")
    public void step06(){
        WebElement hapus = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Edit'])[1]/following::li[1]"));
        Assert.assertNotEquals(hapus.isDisplayed(),"Element Tidak Ditemukan");
    }
}
