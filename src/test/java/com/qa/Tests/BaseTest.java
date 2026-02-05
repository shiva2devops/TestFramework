package com.qa.Tests;

import com.microsoft.playwright.Page;
import com.qa.Browserfactory.playwrightfactory;
import com.qa.Pages.Homepage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {
    playwrightfactory pf;
    protected Homepage hp;
    protected Properties prop;
    public Page page;
    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void browser_init(String browserName){
        pf=new playwrightfactory();
        prop=pf.init_prop();
        if(browserName!=null){
            prop.setProperty("browser",browserName);
        }
        page=pf.setup(prop);
        hp=new Homepage(page);

    }
    @AfterTest(alwaysRun = true)
    public void teardown(){
       if(page!=null) {
           page.context().browser().close();
       }
    }
}
