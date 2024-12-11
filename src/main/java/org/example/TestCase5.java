package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestCase5 {
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


            boolean taskExists = page.isVisible("//h3[contains(text(),'Offline mode')]");
            if (taskExists) {
                System.out.println("'Offline mode' task is in the 'In Progress' column");
                boolean hasFeatureTag = page.isVisible("(//span[@class='px-2 py-1 rounded-full text-xs font-medium bg-blue-100 text-blue-800'][normalize-space()='Feature'])[2]");
                boolean hasHighPriorityTag = page.isVisible("(//span[@class='px-2 py-1 rounded-full text-xs font-medium bg-orange-100 text-orange-800'])[1]");

                if (hasFeatureTag && hasHighPriorityTag) {
                    System.out.println("Tags 'Feature' and 'High Priority' are correctly assigned");
                } else {
                    System.out.println("Tags are incorrect or missing");
                }
            } else {
                System.out.println("'Offline mode' task not found in the 'In Progress' column");
            }

            browser.close();
        }
    }
}
