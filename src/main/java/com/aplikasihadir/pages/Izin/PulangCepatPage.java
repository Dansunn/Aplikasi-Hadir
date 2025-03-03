package com.aplikasihadir.pages.Izin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PulangCepatPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    WebElement btnPulangCepatElement;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    WebElement btnAjukanPulangCepatElement;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    WebElement btnKalenderElement;

    @FindBy(xpath = "//button[@aria-current='date' and contains(@class, 'MuiPickersDay-root')]\n")
    WebElement btnTanggalPulangCepatSaatIniElement;

    @FindBy(xpath = "(//button[@type='button'])[7]")
    WebElement btnJamElement;

    @FindBy(xpath = "//span[@aria-label='15 hours']")
    WebElement btnJam15Element;

    @FindBy(xpath = "//span[@aria-label='15 minutes']")
    WebElement btnMenit15Element;

    @FindBy(xpath = "//textarea[@id='notes']")
    WebElement txtAreaNotesElement;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnAjukanElement;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Pulang Cepat'])[1]/following::p[2]")
    WebElement txtTotalPulangCepatElement;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Jam'])[1]/following::p[1]")
    WebElement txtJamPulangCepatHarusDiisi;

    @FindBy(xpath = "//*/text()[normalize-space(.)='Tanggal Harus diisi!']/parent::*")
    WebElement txtTanggalPulangCepatHarusdiisi;

    @FindBy(xpath = "//p[@id='notes-helper-text']")
    WebElement txtKeteranganPulangCepatHarusDiisi;

    public PulangCepatPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBtnMenuPulangCepat() throws InterruptedException {
        btnPulangCepatElement.click();
        Thread.sleep(1000);
    }

    public void clickBtnAjukanPulangCepat() throws InterruptedException {
        btnAjukanPulangCepatElement.click();
        Thread.sleep(1000);
    }

    public void clickBtnKalender() throws InterruptedException {
        btnKalenderElement.click();
        Thread.sleep(1000);
    }

    public void clickBtnTanggalPulangCepatSaatIni() throws InterruptedException {
        btnTanggalPulangCepatSaatIniElement.click();
        Thread.sleep(1000);
    }

    public void clickBtnJam() throws InterruptedException {
        btnJamElement.click();
        Thread.sleep(2000);
    }

    public void clickBtnJam15() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnJam15Element).click().perform();
        Thread.sleep(2000);
    }

    public void clickBtnMenit15() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnMenit15Element).click().perform();
        Thread.sleep(2000);
    }

    public void fillTxtAreaKeterangan(){
        txtAreaNotesElement.sendKeys("Urusan Keluarga");
    }

    public void clickbtnAjukan() throws InterruptedException {
        btnAjukanElement.click();
        Thread.sleep(2000);
    }

    public int totalSebelumTxt(){
        int txtTotalSebelum = Integer.parseInt(txtTotalPulangCepatElement.getText().replaceAll("[^0-9]",""));
        return txtTotalSebelum;
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
        return txtJamPulangCepatHarusDiisi.getText();
    }

    public String getTextErrorTanggalHarusDiisi() {
        waitForTxtTanggalHarusDiisi();
        return txtTanggalPulangCepatHarusdiisi.getText();
    }

    public String getTextErrorKeteranganHarusDiisi() {
        waitForTxtKeteranganHarusDiisi();
        return txtKeteranganPulangCepatHarusDiisi.getText();
    }

    public void refreshHalamanIzinPulangPage(){
        driver.navigate().refresh();
    }



}
