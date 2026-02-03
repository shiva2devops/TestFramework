package com.qa.pages;

import com.microsoft.playwright.Page;

public class Homepage {
 private Page page;

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

}
