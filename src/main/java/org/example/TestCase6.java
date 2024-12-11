package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestCase6 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            page.navigate("https://animated-gingersnap-8cf7f2.netlify.app/");
            page.fill("input[id='username']", "admin");
            page.fill("input[type='password']", "password123");
            page.click("button[type='submit']");

            page.click("text=Mobile Application");
            System.out.println("Navigated to 'Mobile Application'");

            boolean doneExists = page.isVisible("//h3[normalize-space()='App icon design']");
            if (doneExists){

                boolean hasFeatureTag = page.isVisible("span:has-text('Design')");
                if (hasFeatureTag){
                System.out.println("Tag 'Design' is correctly assigned");
                }else{
                    System.out.println("Tag 'Design; is not present");
                }

            }else{
                System.out.println("'Offline mode' task not found in the 'In Progress' column");
            }
            browser.close();

        }
    }
}
