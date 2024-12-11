package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestCase4 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://animated-gingersnap-8cf7f2.netlify.app/");
            page.fill("input[id='username']", "admin");
            page.fill("input[type='password']", "password123");
            page.click("button[type='submit']");

            page.click("text=Mobile Application");

            boolean toDoIsVisible = page.isVisible("h2:has-text('To Do')");
            boolean pushIsVisible = page.isVisible("h3:has-text('Push notification system')");
            boolean featureTag = page.isVisible("span:has-text('Feature')");
            if (toDoIsVisible&&pushIsVisible){
                System.out.println("To do is visible");
                System.out.println("Push notification system is visible");
                System.out.println("'Feature' is visible");
            }else{
                System.out.println("To Do is not visible");
            }






        }
    }
}
