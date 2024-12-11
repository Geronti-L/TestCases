package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestCase1 {
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
            boolean taskExists = page.isVisible("h3.font-medium.text-gray-900.mb-2");
            if (taskExists) {
                System.out.println("'Implement user authentication' task is in the 'To Do' column");
            } else {
                System.out.println("'Implement user authentication' task not found in 'To Do' column");
            }
            boolean featureExists = page.isVisible("span:has-text('Feature')");
            boolean highpriorityExists = page.isVisible("span:has-text('High Priority')");
            if(featureExists && highpriorityExists){
                System.out.println("tag Feature tag exists");
                System.out.println("tag High Priority exists");
            }else{
                System.out.println("The tag Feature tag does not exist");
                System.out.println("The tag High Priority does not exist");
            }
            System.out.println("Test completed");

            browser.close();
        }
    }
}
