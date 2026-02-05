package com.qa.Browserfactory;

import com.microsoft.playwright.*;

import java.io.InputStream;
import java.util.Properties;

public class playwrightfactory {
    Playwright pw;
    Browser browser;
    BrowserContext context;
    Page page;
    Properties prop;
    private static ThreadLocal<Page> tlpage=new ThreadLocal<>();
    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    public static ThreadLocal<BrowserContext> tlContext = new ThreadLocal<>();
    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    public static Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    public static Browser getBrowser() {
        return tlBrowser.get();
    }

    public static BrowserContext getBrowserContext() {
        return tlContext.get();
    }

    public static Page getPage() {
        return tlpage.get();
    }
    //Intialize the browser and properties
    public Page setup(Properties prop){
        // playwright = Playwright.create();
        tlPlaywright.set(Playwright.create());
       String BrowserName=prop.getProperty("browser").trim();
        System.out.println("browser initiated :"+BrowserName);
       switch (BrowserName.toLowerCase()){
           case "chromium":
               tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000)));
               break;
           case "chrome":
               tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
               break;
           case "firefox":
               tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
               break;
           case "webkit":
               tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
               break;
       }

//       context=browser.newContext();
//       page=context.newPage();
//       page.navigate(prop.getProperty("url"));

        tlContext.set(getBrowser().newContext());
        tlpage.set(getBrowserContext().newPage());
        getPage().navigate(prop.getProperty("url").trim());

        return getPage();

    }

//    public Properties init_prop() {
//        FileInputStream fi= null;
//        try {
//            fi = new FileInputStream("src\\test\\resources\\configproperties\\config.properties");
//            prop=new Properties();
//            prop.load(fi);
//        }  catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return prop;
//
//    }
    public Properties init_prop() {
        Properties prop = new Properties();
        try {
            InputStream ip = getClass()
                    .getClassLoader()
                    .getResourceAsStream("configproperties/config.properties");

            if (ip == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }

            prop.load(ip);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return prop;
    }


}
