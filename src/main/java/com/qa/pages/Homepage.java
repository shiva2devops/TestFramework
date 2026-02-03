package com.qa.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class Homepage {
 private Page page;

 private String dropdown_click="#country";
 private String country="select#country:has-text('India')";
 private String simple_Alert= "#alertBtn";
 private String alertConfirmText="#demo";

 private String promptbtn="button[onclick='myFunctionPrompt()']";



    public Homepage(Page page){
        this.page=page;
    }
    public String getTitle(){
        String title= page.title();
        System.out.println("page title is :"+title);
        return title;
    }

    public String getURL(){
        String url= page.url();
        System.out.println("page url is :"+url);
        return url;
    }

    public String selectCountry(String selectcountry){
        page.click(dropdown_click);
        Locator lc=page.locator(country);
        List<String> countrylist=lc.allInnerTexts();
        System.out.println(countrylist);
        for(String s:countrylist) {
            if (s.contains(selectcountry)) {
                lc.click();
            }
        }
        return selectcountry;

    }

    public void clickAlert(){
        page.onDialog(dailog->{
            String text=dailog.message();
            System.out.println(text);
            dailog.accept();
        });
        page.click(simple_Alert);
    }
    public String PromptAlert(String name){
        page.onDialog(dailog->{
            String text=dailog.message();
            System.out.println(text);
            dailog.accept(name);
        });
        page.click(promptbtn);
        String text=page.textContent(alertConfirmText);

        return text;
    }


}
