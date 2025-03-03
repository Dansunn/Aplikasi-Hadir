package com.aplikasihadir.pages.Izin;

import com.aplikasihadir.drivers.utils.TimeDuration;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IzinOffPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "(//button[@type='button'])[4]")
    WebElement btnIzinOffElement;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    WebElement btnAjukanIzinOffElement;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    WebElement btnKalenderIzinOffElement;

    @FindBy(xpath = "//button[@aria-current='date' and contains(@class, 'MuiPickersDay-root')]\n")
    WebElement btnTanggalIzinOffSaatIniElement;

    @FindBy(xpath = "//textarea[@id='reason']")
    WebElement txtAreaAlesanOffElement;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnAjukanElement;

    @FindBy(xpath = "//div[contains(text(),'Permintaan dalam proses')]")
    WebElement alertPermintaanDalamProses;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Tanggal Off'])[1]/following::p[1]")
    WebElement alertPilihTanggalIzinOff;

    @FindBy(xpath = "//p[@id='reason-helper-text']")
    WebElement alertAlasanMengambilIzinOff;

    public IzinOffPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TimeDuration.FIVE));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeDuration.TEN));
        PageFactory.initElements(driver, this);
    }

    public void clickBtnMenuIzinOff() throws InterruptedException {
        btnIzinOffElement.click();
        Thread.sleep(1000);
    }

    public void clickBtnAjukanIzinOff() throws InterruptedException {
        btnAjukanIzinOffElement.click();
        Thread.sleep(1000);
    }

    public void clickBtnKalender() throws InterruptedException {
        btnKalenderIzinOffElement.click();
        Thread.sleep(1000);
    }

    public void clickBtnTanggalIzinOffSaatIni() throws InterruptedException {
        btnTanggalIzinOffSaatIniElement.click();
        Thread.sleep(1000);
    }

    public void fillTxtAreaAlasanIzinOff() throws InterruptedException {
        txtAreaAlesanOffElement.sendKeys("Masih dalam perjalanan dari luar kota");
        Thread.sleep(3000);
    }

    public void clickBtnAjukan() throws InterruptedException {
        btnAjukanElement.click();
        Thread.sleep(2000);
    }

    public void waitForAlertIzinOff() throws InterruptedException {
        By locator = By.xpath("//div[contains(text(),'Permintaan dalam proses')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForTxtPilihTanggalOff(){
        By locator = By.xpath("((.//*[normalize-space(text()) and normalize-space(.)='\u200B]'])[1]/following::p[1]");
    }

    public void waitForTxtAlasanDanMengambilIzinOff(){
        By locator = By.xpath("//p[@id='notes-helper-text']");
    }

    public String getTextAlertIzinOff() throws InterruptedException {
        waitForAlertIzinOff();
        return alertPermintaanDalamProses.getText();
    }

    public String getTextErrorTanggalIzinOff() {
        waitForTxtPilihTanggalOff();
        return alertPilihTanggalIzinOff.getText();
    }

    public String getTextErrorAlasanIzinOff() {
        waitForTxtAlasanDanMengambilIzinOff();
        return alertAlasanMengambilIzinOff.getText();
    }

    public void refreshHalamanIzinOff() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
    }


}
