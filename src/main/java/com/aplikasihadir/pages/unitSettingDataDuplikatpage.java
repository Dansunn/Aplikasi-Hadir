package com.aplikasihadir.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class unitSettingDataDuplikatpage {
    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, \"sidebar__item\")]/p[contains(text(), \"Management\")]")
    private WebElement management;

    @FindBy(xpath = "//div[contains(@class, \"MuiBox-root\")]/p[contains(text(), \"Unit Setting\")]")
    private WebElement unitSetting;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div[1]/div/div/div/div[1]/button")
    private WebElement tambahUnitSetting;

    @FindBy(xpath = "//h6[contains(.,'Credit Card')]")
    private  WebElement txtCreditCard;


    @FindBy(xpath = "//li[contains(text(), 'Credit Card')]")
    private WebElement pilihanCreditCard;

    @FindBy(xpath = "//div[contains(@class, \"MuiSelect-select MuiSelect\")]")
    private WebElement dropDownTambahkan;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnTambah;

    public unitSettingDataDuplikatpage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void btnManagement() throws InterruptedException{
        management.click();
        Thread.sleep(1000);
    }

    public void klikbtnUnitSetting() throws InterruptedException{
        unitSetting.click();
        Thread.sleep(1000);
    }
    public void klikbtnTambahkan() throws InterruptedException {
        tambahUnitSetting.click();
        Thread.sleep(1000);
    }
    public void pilihData() throws InterruptedException {
        dropDownTambahkan.click();
        Thread.sleep(1000);
        pilihanCreditCard.click();
        Thread.sleep(1000);
    }
    public void klikbtnTambah() throws InterruptedException {
        btnTambah.click();
        Thread.sleep(2000);
    }


}
