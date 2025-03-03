package com.aplikasihadir.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cariposisipage {
    public WebDriver driver;

    @FindBy(xpath = "//div[@id='__next']/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div[2]/div[4]/div/div/div[2]")
    private WebElement management;

    @FindBy (xpath = "//p[contains(.,'Posisi')]")
    private WebElement posisi;

    @FindBy (xpath = "//input[@id='search']")
    private WebElement cari;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement search;

    public cariposisipage (WebDriver driver) throws InterruptedException {
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

    public void textcari() throws InterruptedException{
        cari.sendKeys("Admin 2");
        Thread.sleep(1000);
    }

    public void  kliksearch() throws InterruptedException{
        search.click();
        Thread.sleep(1000);
    }

}
