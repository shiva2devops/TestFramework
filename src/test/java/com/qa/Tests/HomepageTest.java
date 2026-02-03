package com.qa.Tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.qa.pages.Homepage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomepageTest extends BaseTest{

    @Test
    public void check_title(){
        String title= hp.getTitle();
        Assert.assertEquals(title,"Automation Testing Practice");
    }

    @Test
    public void get_url(){
        String getUrl=hp.getURL();
        Assert.assertEquals(getUrl,prop.getProperty("url"));
    }

}
