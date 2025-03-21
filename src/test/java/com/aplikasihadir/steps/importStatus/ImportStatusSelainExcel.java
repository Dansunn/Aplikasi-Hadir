package com.aplikasihadir.steps.importStatus;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.ImportStatus.ImportStatusPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ImportStatusSelainExcel {

    private WebDriver driver;
    private ImportStatusPages importStatusPages;

    public ImportStatusSelainExcel(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        importStatusPages = new ImportStatusPages(driver);
    }

    @Given("Pengguna menekan tombol choose file dan memilih file bukan excel")
    public void importFileBukanExcel() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(3000);
        importStatusPages.setInputFileExcelSalah();
    }

    @And("Pengguna menekan tombol import lagi")
    public void clickBtnImport() throws InterruptedException {
        importStatusPages.clickBtnImport();
        Thread.sleep(1000);
    }

    @Then("Muncul notifikasi error {string}")
    public void verifyImportFile(String expected){
        String actual = importStatusPages.getTextGagalImport();
        Assert.assertEquals(expected, actual);
    }
}
