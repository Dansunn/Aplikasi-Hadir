package com.aplikasihadir.pages.koreksiAbsen;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.windows.ThemeReader;

public class KoreksiAbsenPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@id='__next']/div/div/div/div[3]/div/div/div[2]/div/div/a")
    WebElement spanMenuKoreksiAbsen;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    WebElement btnAjukanKoreksi;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    WebElement btnJamMasuk;

    @FindBy(xpath = "(//button[@type='button'])[6]")
    WebElement btnDropTahun;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[3]/div/div/div[1]/p[2]")
    WebElement txtTotal;

    @FindBy(xpath = "(//button[@type='button'])[133]")
    WebElement btnTahun2024JamMasuk;

    @FindBy(xpath = "(//button[@type='button'])[8]")
    WebElement btnNextBulan;

    @FindBy(xpath = "(//button[@type='button'])[27]")
    WebElement btnTanggal19Feb2024;

    @FindBy(xpath = "//span[@aria-label='7 hours']")
    WebElement btnJam7;

    @FindBy(xpath = "//span[@aria-label='15 minutes']")
    WebElement btnMenit15;

    @FindBy(xpath = "(//button[@type='button'])[4]")
    WebElement btnJamKeluar;

    @FindBy (xpath = "(//button[@type='button'])[9]")
    WebElement btnTahun2024JamKeluar;

    @FindBy(xpath = "//span[@aria-label='16 hours']")
    WebElement btnJam16;

    @FindBy(xpath = "//span[@aria-label='30 minutes']")
    WebElement btnMenit30;

    @FindBy(xpath = "//form/div/div[3]/div/div")
    WebElement btnFieldTipeAbsen;

    @FindBy(xpath = "//ul[contains(@class, 'MuiMenu-list')]//li[2]")
    WebElement btnWFH;
    @FindBy(xpath = "//ul[contains(@class, 'MuiMenu-list')]//li[3]")
    WebElement btnWFO;

    @FindBy(xpath = "//button[.='Ajukan']")
    WebElement btnAjukan;

    @FindBy(xpath = "//p[contains(.,'Salah satu harus diisi!')]")
    WebElement txtEmptyField;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/a/button")
    WebElement btnBack;



    public KoreksiAbsenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scrollToTop() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy({top: 300})");
        Thread.sleep(2000);
    }

    public void clickButtonMenuKoreksiAbsen() throws InterruptedException {
        spanMenuKoreksiAbsen.click();
        Thread.sleep(2000);
    }

    public void clickButtonAjukanKoreksi() throws InterruptedException {
        btnAjukanKoreksi.click();
        Thread.sleep(5000);
    }

    public void clickButtonJamMasuk() throws InterruptedException {
        btnJamMasuk.click();
        Thread.sleep(2000);
    }

    public void clickButtonDropTahun() throws InterruptedException {
        btnDropTahun.click();
        Thread.sleep(1000);
    }

    public void clickTahun2024() throws InterruptedException {
        btnTahun2024JamMasuk.click();
        Thread.sleep(2000);
    }

    public void clickNextBulan() throws InterruptedException {
        btnNextBulan.click();
        Thread.sleep(2000);
    }

    public void clickTgl19Feb() throws InterruptedException {
        btnTanggal19Feb2024.click();
        Thread.sleep(2000);
    }

    public void clickJam07() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnJam7).click().perform();
    }

    public void clickMenit15() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnMenit15).click().perform();
        Thread.sleep(2000);
    }

    public void clickJamKeluar() throws InterruptedException {
        btnJamKeluar.click();
        Thread.sleep(2000);
    }

    public void clickTahun2024JamKeluar(){
        btnTahun2024JamKeluar.click();
    }

    public void clickJam16() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnJam16).click().perform();
        Thread.sleep(2000);
    }

    public void clickMenit30() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(btnMenit30).click().perform();
        Thread.sleep(2000);
    }

    public void clickButtonFieldTipeAbsen() throws InterruptedException {
        btnFieldTipeAbsen.click();
        Thread.sleep(5000);
    }

    public void clickWFH() throws InterruptedException {
        btnWFH.click();
        Thread.sleep(2000);
    }

    public void clickWFO() throws InterruptedException {
        btnWFO.click();
        Thread.sleep(2000);
    }

    public void clickButtonAjukan() throws InterruptedException {
        btnAjukan.click();
        Thread.sleep(3000);
    }

    public void clickButtonBack() throws InterruptedException {
        btnBack.click();
        Thread.sleep(2000);
    }

    public int totalSebelumTxt(){
        int txtTotalSebelum = Integer.parseInt(txtTotal.getText().replaceAll("[^0-9]",""));
        return txtTotalSebelum;
    }

    public void waitForTxtEmptyField() {
        By locator = By.xpath("//p[contains(.,'Salah satu harus diisi!')]");
    }

    public String getTextErrorEmptyField() {
        waitForTxtEmptyField();
        return txtEmptyField.getText();
    }



}
