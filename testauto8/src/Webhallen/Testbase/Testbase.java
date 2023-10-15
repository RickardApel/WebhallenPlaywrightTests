package Webhallen.Testbase;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class Testbase {
    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static public void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

    }

    @BeforeEach
    public void createContextAndPage(){
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    public void closeContext() {
        page.close();
        context.close();
    }
    @AfterAll
    static public void closeBrowser(){
        browser.close();
        playwright.close();
    }
}
