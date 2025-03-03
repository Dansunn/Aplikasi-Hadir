package com.aplikasihadir.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hapusposisipage {
    public WebDriver driver;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Admin Hadir'])[1]/following::div[69]")
    private WebElement management;

    @FindBy (xpath = "//p[contains(.,'Posisi')]")
    private WebElement posisi;

    @FindBy (xpath = "(//button[@type='button'])[6]")
    private WebElement titiktiga;

    @FindBy (xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Edit'])[1]/following::li[1]")
    private WebElement hapus;

    @FindBy (xpath = "(//button[@type='submit'])[2]")
    private WebElement btnYa;

    public hapusposisipage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Thread.sleep(1000);
    }

    public void btnManagement() throws InterruptedException{
        management.click();
        Thread.sleep(2000);
    }

    public void klikbtnPosisi() throws InterruptedException{
        posisi.click();
        Thread.sleep(3000);
    }

    public void kliktitiktiga() throws InterruptedException{



        // Gunakan JavaScript Executor untuk scroll ke elemen titik tiga
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", titiktiga);

        // Tambahkan aksi hover jika perlu
        // Actions actions = new Actions(driver);
        //actions.moveToElement(titiktiga).perform();
        titiktiga.click();
        Thread.sleep(5000);

    }
    public void klikhapus() throws InterruptedException{
        hapus.click();
        Thread.sleep(5000);
    }

    public void ya() throws InterruptedException{
        btnYa.click();
        Thread.sleep(1000);
    }


}
