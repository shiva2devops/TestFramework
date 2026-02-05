package com.qa.Utility;

import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AllureUtils {

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public static byte[] attachScreenshot(Page page){
        SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yy_HH-mm-ss");   //Used to get the date format
        Date date=new Date();   //Used to get the today's date
        String newDate=dateformat.format(date);

        byte[] arr=page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("Screenshots/"+newDate+".png")));
        return arr;
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

