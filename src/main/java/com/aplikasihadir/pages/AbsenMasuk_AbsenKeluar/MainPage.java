package com.aplikasihadir.pages.AbsenMasuk_AbsenKeluar;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium css-ctijcz']")
    private WebElement btnAbsenMasuk;

    @FindBy(xpath = "//input[@name=\"notes\"]")
    private WebElement fieldNotes;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement btnAbsenMasukSetelahNotes;

    @FindBy(xpath = "//div[contains(text(), 'Anda berhasil melakukan absen hari ini')]")
    private WebElement txtBerhasilAbsen;

    @FindBy(xpath = "//p[contains(.,'Keluar')]")
    private WebElement btnKeluar;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnAbsenKeluar;

    @FindBy(xpath = "//textarea[@name='notes']")
    private WebElement fieldNotesKeluar;

    @FindBy(css = ".feather-camera")
    private WebElement btnCamera;

    @FindBy(css=".MuiModal-backdrop")
    private WebElement backdrop;

    @FindBy(xpath = "//p[normalize-space()='History Absensi']")
    private WebElement historyAbsensi;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void pilihTipeAbsen(String tipeAbsen) throws InterruptedException {
        try {
            WebElement dropdown = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='combobox']")));
            dropdown.click();

            WebElement options = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), '" + tipeAbsen + "')]")));
            options.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Gagal Memilih Kategori : " + e.getMessage());
        }
        Thread.sleep(1000);
    }

    public void clickBtnKamera() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         WebElement waitBtnCamera = wait.until(ExpectedConditions.elementToBeClickable(btnCamera));
         Actions actions = new Actions(driver);
         actions.moveToElement(waitBtnCamera).click().perform();
         Thread.sleep(1000);
    }

    public void clickBtnAbsenMasuk() throws InterruptedException {
        btnAbsenMasuk.click();
    }

    public void fillNotes(String notes) throws InterruptedException {
        fieldNotes.sendKeys(notes);
    }

    public void clickBtnAbsenMasukSetelahNotes() throws InterruptedException {
        btnAbsenMasukSetelahNotes.click();
    }

    public String getTxtBerhasilAbsen() throws InterruptedException {
        return txtBerhasilAbsen.getText();
    }

    public void clickBtnKeluar() throws InterruptedException {
        btnKeluar.click();
    }

    public void clickBtnAbsenKeluar() throws InterruptedException {
        btnAbsenKeluar.click();
    }

    public void fillNotesKeluar(String notes) throws InterruptedException {
        fieldNotesKeluar.sendKeys(notes);
    }

    public String getTxtTanggalAbsen(String tanggal) throws InterruptedException {
        Thread.sleep(1000);
        WebElement txtTanggalAbsen = driver.findElement(By.xpath("//p[contains(.,'" + tanggal + "')]"));
        return txtTanggalAbsen.getText();
    }

    public void scrollToBottom(boolean isButtonMasuk) throws InterruptedException {
        if (isButtonMasuk) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnAbsenMasukSetelahNotes);
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnAbsenKeluar);
        }
    }

    public void scrollDown() throws InterruptedException  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", historyAbsensi);
//        ((JavascriptExecutor) driver).executeScript("window.scroll({top: 1500})");
    }

    public void scrollUp() throws InterruptedException  {
        ((JavascriptExecutor) driver).executeScript("window.scroll({top: 0, behavior: 'smooth'})");
    }

    public void onEscape() throws InterruptedException {
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
    }

    public void noteKeluarOnFocus() {
        new Actions(driver).moveToElement(fieldNotesKeluar).perform();
    }

    public void clickBackdrop() {
        backdrop.click();
    }

    public boolean isBtnKeluarNotDisplayed() {
        return driver.findElements(By.xpath("//p[contains(.,'Keluar')]")).isEmpty();
    }

    public boolean isBtnAbsenMasukNotDisplayed(){
        return driver.findElements(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium css-ctijcz']")).isEmpty();

    }
}
