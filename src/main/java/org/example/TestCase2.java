package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestCase2 {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://animated-gingersnap-8cf7f2.netlify.app/");
            page.fill("input[id='username']", "admin");
            page.fill("input[type='password']", "password123");
            page.click("button[type='submit']");
            page.click("text=Web Application");
            System.out.println("Navigated to 'Web Application'");
            boolean featureExists = page.isVisible("h3:has-text('Fix navigation bug')");
            boolean highpriorityExists = page.isVisible("span:has-text('Bug')");
            if(featureExists && highpriorityExists){
                System.out.println("The tag 'Bug' tag exists");

            }else{
                System.out.println("The tag 'Bug'  does not exist");

            }
            System.out.println("Test completed");

            browser.close();
        }


    }
}