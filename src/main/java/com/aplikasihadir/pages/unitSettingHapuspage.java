package com.aplikasihadir.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class unitSettingHapuspage {
    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, \"sidebar__item\")]/p[contains(text(), \"Management\")]")
    private WebElement management;

    @FindBy(xpath = "//div[contains(@class, \"MuiBox-root\")]/p[contains(text(), \"Unit Setting\")]")
    private WebElement unitSetting;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr[1]/td[5]/button")
    private WebElement hapus;

    public unitSettingHapuspage(WebDriver driver){
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

    public void btnHapus() throws InterruptedException{
        hapus.click();
        Thread.sleep(1000);
    }

}
