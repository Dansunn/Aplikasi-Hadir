package com.aplikasihadir.steps.importStatus;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.ImportStatus.ImportStatusPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;
import java.util.regex.Pattern;

public class ImportStatusDownloadTemplate {

    private WebDriver driver;
    private ImportStatusPages importStatusPages;
    private final String downloadPath = System.getProperty("user.home") + "/Downloads";
    private final String filePattern = "DATA_STATUS_USER.xlsx";

    public ImportStatusDownloadTemplate(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        importStatusPages = new ImportStatusPages(driver);
    }

    public boolean isFileDownloadedRegex(String downloadPath, String filePattern, int timeout) throws InterruptedException {
        File folder = new File(downloadPath);
        Pattern pattern = Pattern.compile(filePattern);
        int elapsedTime = 0;

        while (elapsedTime < timeout) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (pattern.matcher(file.getName()).matches()) {
                        return true; // File ditemukan
                    }
                }
            }
            Thread.sleep(1000); // Tunggu 1 detik
            elapsedTime += 1000;
        }
        return false; // Timeout, file tidak ditemukan
    }

    @Given("Pengguna menekan tombol download template")
    public void clickBtnDownloadTemplate() throws InterruptedException {
        importStatusPages.clickBtnTemplate();
    }

    @Then("Pengguna berhasil mendownload file template")
    public void verifyDownloadTemplate() throws InterruptedException {
        boolean isDownloaded = isFileDownloadedRegex(downloadPath, filePattern, 30000);
        Assert.assertTrue(isDownloaded, "Tidak ada File yang di Download !!");
    }
}
