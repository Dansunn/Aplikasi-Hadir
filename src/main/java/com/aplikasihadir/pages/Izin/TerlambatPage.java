package com.aplikasihadir.pages.Izin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TerlambatPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Jam'])[1]/following::p[1]")
    WebElement txtJamHarusDiisi;

    @FindBy(xpath = "//*/text()[normalize-space(.)='Tanggal Harus diisi!']/parent::*")
    WebElement txtTanggalHarusdiisi;

    @FindBy(xpath = "//p[@id='notes-helper-text']")
    WebElement txtKeteranganHarusDiisi;

    @FindBy(xpath = "//*[@id='__next']/div/div/div[1]/div[3]/div/div/div[3]/div/div/a/div")
    WebElement btnMenuIzinElement;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    WebElement btnAjukanIzinTerlambatElement;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    WebElement btnPilihTanggalElement;

    @FindBy(xpath = "//button[@aria-current='date' and contains(@class, 'MuiPickersDay-root')]\n")
    WebElement btnTanggalSaatIniElement;

    @FindBy(xpath = "(//button[@type='button'])[7]")
    WebElement btnPilihJamEelement;

    @FindBy(xpath = "//span[@aria-label='7 hours']")
    WebElement btnJam7Element;

    @FindBy(xpath = "//span[@aria-label='15 minutes']")
    WebElement btnMenit15Element;

    @FindBy(xpath = "//textarea[@id='notes']")
    WebElement fieldKeteranganElement;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnAjukanElement;

    @FindBy(xpath = "//div[contains(text(),'Permintaan izin terlambat sebelumnya belum di approve')]")
    WebElement alertIzinTerlambatElement;

    public TerlambatPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBtnMenuIzin() throws InterruptedException {
        btnMenuIzinElement.click();
        Thread.sleep(2000);
    }

    public void clickBtnAjukanIzinTerlambat() throws InterruptedException {
        btnAjukanIzinTerlambatElement.click();
        Thread.sleep(2000);
    }

    public void clickBtnTanggal() throws InterruptedException {
        btnPilihTanggalElement.click();
        Thread.sleep(2000);
    }

    public void clickBtnTanggalSaatIni() throws InterruptedException {
        btnTanggalSaatIniElement.click();
        Thread.sleep(2000);
    }

    public void clickBtnJam() throws InterruptedException {
        btnPilihJamEelement.click();
        Thread.sleep(2000);
    }

    public void clickBtnJam7() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnJam7Element).click().perform();
        Thread.sleep(2000);
    }

    public void clickBtnMenit15() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnMenit15Element).click().perform();
        Thread.sleep(2000);
    }

    public void fillTextAreaKeterangan(){
        fieldKeteranganElement.sendKeys("Hujan");
    }

    public void clickbtnAjukan() throws InterruptedException {
        btnAjukanElement.click();
        Thread.sleep(2000);
    }

    public void waitForAlertIzinTerlambat() throws InterruptedException {
        By locator = By.xpath("//div[contains(text(),'Permintaan izin terlambat sebelumnya belum di approve')]");
        Thread.sleep(3000);
    }

    public String getTextAlertIzinTerlambat() throws InterruptedException {
        waitForAlertIzinTerlambat();
        return alertIzinTerlambatElement.getText();
    }

    public void scroll() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy({top: 300})");
        Thread.sleep(3000);
    }

    public void waitForTxtJamHarusDiisi() {
        By locator = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jam'])[1]/following::p[1]");
    }

    public void waitForTxtTanggalHarusDiisi(){
        By locator = By.xpath("((.//*[normalize-space(text()) and normalize-space(.)='\u200B]'])[1]/following::p[1]");
    }

    public void waitForTxtKeteranganHarusDiisi(){
        By locator = By.xpath("//p[@id='notes-helper-text']");
    }

    public String getTextErrorJamHarusDiisi() {
        waitForTxtJamHarusDiisi();
        return txtJamHarusDiisi.getText();
    }

    public String getTextErrorTanggalHarusDiisi() {
        waitForTxtTanggalHarusDiisi();
        return txtTanggalHarusdiisi.getText();
    }

    public String getTextErrorKeteranganHarusDiisi() {
        waitForTxtKeteranganHarusDiisi();
        return txtKeteranganHarusDiisi.getText();
    }

    public void refreshBrowser(){
        driver.navigate().refresh();
    }

}
