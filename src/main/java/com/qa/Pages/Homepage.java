package com.qa.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class Homepage {
 private Page page;

 private String dropdown_click="#country";
 private String country="select#country:has-text('India')";
 private String simple_Alert= "#alertBtn";
 private String alertConfirmText="#demo";
 private String name="#name";
 private String email="#email";
 private String phone="#phone";
 private String address="#textare";
 private String popup="#PopUp";
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

    public void enterdetails(String Name,String Email, String Phone, String Address){
        page.fill(name,Name);
        page.fill(email,Email);
        page.fill(phone,Phone);
        page.fill(address,Address);
    }

    public void selectCountry(String selectcountry){
        Locator dropdown = page.locator(dropdown_click);
        dropdown.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        dropdown.selectOption(selectcountry);
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
    public String popwindow(){
        Page newPage = page.context().waitForPage(() -> {
            page.click(popup);
        });

        newPage.waitForLoadState();
        String title=newPage.title();
        page.bringToFront();

        return title;
    }


}
