package com.qa.Tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.qa.pages.Homepage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomepageTest extends BaseTest{

    @Test(enabled = false, groups = "regression")
    public void check_title(){
        String title= hp.getTitle();
        Assert.assertEquals(title,"Automation Testing Practice");
    }
    @Test(enabled = false,groups = "regression")
    public void get_url(){
        String getUrl=hp.getURL();
        Assert.assertEquals(getUrl,prop.getProperty("url"));
    }
    @Test(groups = "regression")
    public void selectCountryDropdown(){
        hp.selectCountry("India");
    }
    @Test(enabled = false,groups = "sanity")
    public void clickAlert(){
        hp.clickAlert();
    }
    @Test(enabled = false,groups = "regression")
    public void getPromptAlert(){
        String actual=hp.PromptAlert("Shiva");
        System.out.println(actual);
    }
}
