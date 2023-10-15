package Pages;

import Pagebase.PageBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ProduktsidaScooter extends PageBase {
    Page page;
    public Locator scooterToCart;
    public Locator cookies;
    public Locator varukorg;
    public Locator cartPopup;
    public Locator cartTotal;
    public Locator cartAddOneButton;
    public Locator cartDeleteOneButton;
    public Locator cartDeleteAllButton;




    public ProduktsidaScooter(Page page){
        this.page = page;
        this.scooterToCart = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Lägg i varukorg"));
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Okej, jag förstår"));
        this.varukorg = page.locator("label[for=\"cart-41\"]").first();
        this.cartPopup = page.locator("xpath=//h3[@class='level-two-heading mt-5']").first();
        this.cartTotal = page.locator
                ("input[pattern='[0-9]*'][inputmode='numeric'][novalidate='novalidate'][type='number'].input-number._tiny.hide-spinner");
        this.cartAddOneButton = page.locator("button[aria-label='Lägg till en'].btn-add-one._tiny");
        this.cartDeleteOneButton = page.locator("button[aria-label='Ta bort en'].btn-remove-one._tiny");
        this.cartDeleteAllButton = page.locator("button[aria-label='Ta bort'].btn-remove-item._tiny");
    }

    public void openProduktSida() {
        String produktSidaUrl = "https://www.webhallen.com/se/product/362382-Xiaomi-Electric-Scooter-4-Lite-NE-Svart";
        page.navigate(produktSidaUrl);
    }

    public void acceptCookies(){
        if (cookies.isVisible()) {
            cookies.click();
        }
    }

    public void addScooterToCart(){
        scooterToCart.click();
    }

    public void openVarukorg(){
        varukorg.click();
    }

    public void cartPlusOne(){
        cartAddOneButton.click();
    }
    public void cartMinusOne(){
        cartDeleteOneButton.click();
    }
    public void cartDeleteAll(){
        cartDeleteAllButton.click();
    }

}
