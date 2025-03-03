package com.aplikasihadir.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class unitSettingDataKosongpage {
        private WebDriver driver;

        @FindBy(xpath = "//div[(text() = 'Management' or . = 'Management')]")
        private WebElement management;

        @FindBy(xpath = "//div[contains(@class, \"MuiBox-root\")]/p[contains(text(), \"Unit Setting\")]")
        private WebElement unitSetting;

        @FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div[1]/div/div/div/div[1]/button")
        private WebElement tambahUnitSetting;

        @FindBy(xpath = "//button[@type='submit']")
        private WebElement btnTambah;

        public unitSettingDataKosongpage(WebDriver driver){
                this.driver = driver;
                PageFactory.initElements(driver, this);
        }

        public void btnManagement() throws InterruptedException{
                management.click();
                Thread.sleep(1000);
        }

        public void klikbtnUnitSetting() throws InterruptedException {
                unitSetting.click();
                Thread.sleep(1000);
        }

        public void klikbtnTambahkan() throws InterruptedException {
                tambahUnitSetting.click();
                Thread.sleep(1000);
        }

        public void klikbtnTambah() throws InterruptedException {
                btnTambah.click();
                Thread.sleep(2000);
        }

}
