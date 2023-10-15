package Pages;

import Pagebase.PageBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Startsida extends PageBase {

    Page page;
    public Locator searchField;
    public Locator searchButton;
    public Locator cookies;
    public Locator varukorg;
    public Locator dropdown;
    public Locator cartPopup;
    public Locator exklusiveMoms;
    public Locator categorySpel;
    public Locator cartTotal;

    public Startsida(Page page) {
        this.page = page;
        this.searchField = page.getByPlaceholder("Sök bland över 16 000 produkter");
        this.searchButton = page.getByLabel("search-button");
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Okej, jag förstår"));
        this.varukorg = page.locator("label[for=\"cart-41\"]").first();
        this.dropdown = page.locator(".dropdown-select");
        this.cartPopup = page.locator("xpath=//h3[@class='level-two-heading mt-5']").first();
        this.exklusiveMoms = page.locator(".list-label:has-text('Visa priser exklusive moms')");
        this.categorySpel = page.locator("div[aria-label='campaign-icon']").first();
        this.cartTotal = page.locator(".sum-ex-inkvat").first();
    }

    public void openStartsida() {
        String startsidaUrl = "https://www.webhallen.com/";
        page.navigate(startsidaUrl);
    }

    public void acceptCookies(){
        if (cookies.isVisible()) {
            cookies.click();
        }
    }

    public void searchFC24(){
    searchField.click();
    searchField.fill("FC24");
    searchButton.click();
}

     public void cartClick(){
        varukorg.click();
}

      public void dropdownClickExklusive(){
        dropdown.click();
        exklusiveMoms.click();
}
      public void chooseCategorySpel(){
        categorySpel.click();
      }

}
