package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test()
    public void check_title(){
        String title= hp.getTitle();
        Assert.assertEquals(title,"Automation Testing Practice");
    }
    @Test()
    public void get_url(){
        String getUrl=hp.getURL();
        Assert.assertEquals(getUrl,prop.getProperty("url"));
    }
    @Test()
    public void EnterDetails(){
        hp.enterdetails("shiva","shiva@gmail.com","548778845","Hyd");
    }
    @Test()
    public void selectCountryDropdown(){
        hp.selectCountry("India");
    }
    @Test()
    public void clickAlert(){
        hp.clickAlert();
    }
    @Test()
    public void getPromptAlert(){
        String actual=hp.PromptAlert("Shiva");
        System.out.println(actual);
    }
    @Test()
    public void PopWindow(){
        String actual=hp.popwindow();
        System.out.println(actual);
    }
}
