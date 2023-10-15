package Pages;

import Pagebase.PageBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PresentkortSida extends PageBase {

    Page page;
    public Locator cookies;
    public Locator epost;
    public Locator laggIVarukorgButton;
    public Locator plusOne;
    public Locator varukorg;
    public Locator cartPopup;
    public Locator cartTotal;
    public Locator antalPresentkort;


    public PresentkortSida(Page page){
        this.page = page;
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Okej, jag förstår"));
        this.epost = page.locator("label:has-text('Mottagarens e-postadress')");
        this.plusOne = page.getByLabel("Lägg till en");
        this.laggIVarukorgButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lägg i varukorg"));
        this.varukorg = page.locator("label[for=\"cart-41\"]").first();
        this.cartPopup = page.locator("xpath=//h3[@class='level-two-heading mt-5']").first();
        this.cartTotal = page.locator(".sum-ex-inkvat").first();
        this.antalPresentkort = page.locator("input[pattern='[0-9]*'][inputmode='numeric'][novalidate='novalidate'][type='number'].input-number.hide-spinner");

    }

    public void openPresentkortSida() {
        String presentkortSidaUrl = "https://www.webhallen.com/se/info/28-Kop-presentkort";
        page.navigate(presentkortSidaUrl);
    }

    public void acceptCookies(){
        if (cookies.isVisible()) {
            cookies.click();
        }
    }
    public void addThree(){

        plusOne.click();
        plusOne.click();
        plusOne.click();
    }
    public void fillEpost(){
        epost.click();
        epost.fill("test@test.se");
    }
    public void addPresentkortToCart(){
        laggIVarukorgButton.click();
    }
    public void openVarukorg(){
        varukorg.click();
    }
}
