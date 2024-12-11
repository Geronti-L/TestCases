package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Login {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://animated-gingersnap-8cf7f2.netlify.app/");
            page.fill("input[id='username']", "admin");
            page.fill("input[type='password']", "password123");
            page.click("button[type='submit']");
            System.out.println("Test completed");
            browser.close();
        }






    }
}