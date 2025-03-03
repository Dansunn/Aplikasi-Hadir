package com.aplikasihadir.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class editposisiNamaPosisiKosongpage {
    public WebDriver driver;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Admin Hadir'])[1]/following::div[69]")
    private WebElement management;

    @FindBy(xpath = "//p[contains(.,'Posisi')]")
    private WebElement posisi;

    @FindBy(xpath = "(//button[@type='button'])[14]")
    private WebElement titiktiga;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Edit'])[8]/following::li[2]")
    private WebElement edit;

    @FindBy(xpath = "//input[@id = 'name' and @name = 'name' and @type = 'text']")
    private WebElement txtAdmin1;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement btnSimpan;

    public editposisiNamaPosisiKosongpage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Thread.sleep(1000);
    }

    public void btnManagement() throws InterruptedException {
        management.click();
        Thread.sleep(2000);
    }

    public void klikbtnPosisi() throws InterruptedException {
        posisi.click();
        Thread.sleep(1000);
    }

    public void kliktitiktiga() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(titiktiga).click().perform();
        Thread.sleep(2000);
        //  titiktiga.click();
        Thread.sleep(1000);

    }

    public void klikedit() throws InterruptedException {
        edit.click();
        Thread.sleep(1000);
    }

    public void editposisi() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));

        //  txtAdmin1.sendKeys("Admin 2");
        txtAdmin1.clear();
    }

    public void simpan() throws InterruptedException {
        btnSimpan.click();
        Thread.sleep(1000);
    }
//    public void scrollToTop() throws InterruptedException {
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy({top: 300})");
//        Thread.sleep(2000);
//    }

}
