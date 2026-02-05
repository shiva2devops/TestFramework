package com.qa.Utility;

import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import static com.qa.Browserfactory.playwrightfactory.getPage;

public class AllureUtils {

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public static byte[] attachScreenshot(Page page){
        SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yy_HH-mm-ss");   //Used to get the date format
        Date date=new Date();   //Used to get the today's date
        String newDate=dateformat.format(date);

        byte[] arr=page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshots/"+newDate+".png")));
        return arr;
    }
    @Attachment(value = "Screenshot on failure", type = "image/png")
    public static String takescreenshot(Page page){
        String path=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";

        byte[] buffer=getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        String base64Path = Base64.getEncoder().encodeToString(buffer);
        return base64Path;
    }

    @Attachment(value = "Log", type = "text/plain")
    public static String attachlog(String message){
        return message;
    }
    @Attachment(value = "Page Source", type = "text/html")
    public static String attachPageSource(String html){
        return html;
    }


}

