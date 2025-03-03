package com.aplikasihadir.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class posisiDataDuplikatpage {
    public WebDriver driver;

    @FindBy(xpath = "//div[@id='__next']/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[4]/div/div/div[2]")
    private WebElement management;

    @FindBy (xpath = "//p[contains(.,'Posisi')]")
    private WebElement posisi;

    @FindBy (xpath = "(//button[@type='button'])[5]")
    private WebElement tambahPosisi;

    @FindBy (xpath = "//input[@id = 'name' and @name = 'name' and @placeholder = 'Nama Position' and @type = 'text']")
    private WebElement txtAdmin1;

    @FindBy (xpath = "//*[@id=\"alert-slide-description\"]/div[2]/div")
    private WebElement txtCreditCard;

    @FindBy (xpath = "//li[contains(.,'Credit Card')]")
    private WebElement pilihanCreditCard;

    @FindBy (xpath = "//*[@id=\"alert-slide-description\"]/div[2]/div")
    private WebElement dropdownTambahkan;

    @FindBy (xpath = "/html/body/div[13]/div[3]/div/form/div[2]/button[1]")
    private WebElement btnTambah;


    public posisiDataDuplikatpage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Thread.sleep(1000);
    }

    public void btnManagement() throws InterruptedException{
        management.click();
        Thread.sleep(1000);
    }

    public void klikbtnPosisi() throws InterruptedException{
        posisi.click();
        Thread.sleep(1000);
    }

    public void btnTambahkan() throws InterruptedException{
        tambahPosisi.click();
        Thread.sleep(1000);
    }

    public void isiPosition() throws InterruptedException{
        txtAdmin1.sendKeys("Admin 1");
        Thread.sleep(1000);
    }

    public void pilihData() throws InterruptedException{
        dropdownTambahkan.click();
        Thread.sleep(1000);
        pilihanCreditCard.click();
        Thread.sleep(1000);
    }

    public void klikbtnTambah() throws InterruptedException{
        btnTambah.click();
        Thread.sleep(1000);
    }
}
