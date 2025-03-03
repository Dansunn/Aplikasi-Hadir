package com.aplikasihadir.steps.importStatus;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.ImportStatus.ImportStatusPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ImportStatusKosongan {

    private WebDriver driver;
    private ImportStatusPages importStatusPages;

    public ImportStatusKosongan(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        importStatusPages = new ImportStatusPages(driver);
    }

    @Given("Pengguna2 menekan tombol menu Import di bagian kiri menu")
    public void clickMenuImport() throws InterruptedException {
        importStatusPages.clickDropdownImport();
    }

    @And("Pengguna2 menekan tombol submenu Import Status Aktif")
    public void clickSubMenuStatusAktif() throws InterruptedException {
        importStatusPages.clickDropdownStatusAktif();
    }

    @When("Pengguna2 menekan tombol choose file dan memilih file excel kosongan")
    public void clickBtnChooseFile() throws InterruptedException {
        importStatusPages.inputFileExcelKosong();
    }

    @And("Pengguna2 menekan tombol import")
    public void clickBtnImport() throws InterruptedException {
        importStatusPages.clickBtnImport();
    }

    @Then("Muncul alert {string}")
    public void verifyImportExcel(String expected) throws InterruptedException {
        Thread.sleep(1000);
        WebElement AlertKosongan = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div[1]/div/div/div[1]/div"));
        String actual = AlertKosongan.getText();
        Assert.assertEquals(expected, actual);
    }
}
