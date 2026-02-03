package com.qa.Tests;

import com.microsoft.playwright.Page;
import com.qa.browserfactory.playwrightfactory;
import com.qa.pages.Homepage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
    playwrightfactory pf;
    protected Homepage hp;
    protected Properties prop;
    Page page;
    @Parameters({"browser"})
    @BeforeTest
    public void browser_init(String browserName){
        pf=new playwrightfactory();
        prop=pf.init_prop();
        if(browserName!=null){
            prop.setProperty("browser",browserName);
        }
        page=pf.setup(prop);
        hp=new Homepage(page);

    }
    @AfterTest
    public void teardown(){
       page.context().browser().close();
    }
}
