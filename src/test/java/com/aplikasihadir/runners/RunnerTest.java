package com.aplikasihadir.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/00_Absen.feature",
                "src/test/resources/features/01_KoreksiAbsen.feature",
                "src/test/resources/features/02_IzinTerlambat.feature",
                "src/test/resources/features/03_IzinPulangCepat.feature",
                "src/test/resources/features/04_IzinOff.feature",
                "src/test/resources/features/05_ImportStatus.feature",
                "src/test/resources/features/06_TambahDepartementsSetting.feature",
                "src/test/resources/features/07_TambahDepartementSettingDataKosong.feature",
                "src/test/resources/features/08_TambahDepartementSettingDataDuplikat.feature",
                "src/test/resources/features/09_HapusDepartementSetting.feature",
                "src/test/resources/features/10_TambahPosisi.feature",
                "src/test/resources/features/11_TambahPosisiNamaPosisiKosong.feature",
                "src/test/resources/features/12_TambahPosisiNamaDepartementKosong.feature",
                "src/test/resources/features/13_TambahPosisiNamaPosisiDanDepartementKosong.feature",
                "src/test/resources/features/14_TambahPosisiDataDuplikat.feature",
                "src/test/resources/features/15_EditPosisi.feature",
                "src/test/resources/features/16_EditPosisiNamaPosisiKosong.feature",
                "src/test/resources/features/17_HapusPosisi.feature",
                "src/test/resources/features/18_SearchPosisi.feature",
        },
        glue = {
                "com.aplikasihadir.hooks",
                "com.aplikasihadir.steps",
        },
        plugin = {
                "pretty",
                "html:target/cucumber-reporting/reports.html",
                "json:target/cucumber-reporting/reports.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        },
        tags = ""
)

public class RunnerTest extends AbstractTestNGCucumberTests {
}
