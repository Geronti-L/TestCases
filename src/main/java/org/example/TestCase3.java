package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestCase3 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://animated-gingersnap-8cf7f2.netlify.app/");
            page.fill("input[id='username']", "admin");
            page.fill("input[type='password']", "password123");
            page.click("button[type='submit']");

            boolean featureExists = page.isVisible("h3:has-text('Design system updates')");
            if(featureExists){
                System.out.println("Design system updates exists");
            }else{
                System.out.println("Design system updates does not exist");
            }

            boolean designExists = page.isVisible("span:has-text('Design')");
            if(designExists){
                System.out.println("Design exists");
            }else{
                System.out.println("Design does not exist");
            }

            browser.close();

        }

    }
}
