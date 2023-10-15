package Pages;

import Pagebase.PageBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SokResultatFC24 extends PageBase {
    Page page;
    public Locator cookies;
    public Locator filterFunction;
    public Locator sortByBetyg;

    public SokResultatFC24(Page page){
        this.page = page;
        this.filterFunction = page.locator("label[for='product-sorting']:has-text('Sortera på: Mest sålda')");
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Okej, jag förstår"));
        this.sortByBetyg = page.locator("span.list-label:has-text('Betyg')");
    }

    public void openSokResultatFC24(){
        String sokResultatFC24Url = "https://www.webhallen.com/se/search?searchString=FC24";
        page.navigate(sokResultatFC24Url);
    }

    public void acceptCookies(){
        if (cookies.isVisible()) {
            cookies.click();
        }
    }

    public void filterByScore(){
        filterFunction.click();
        sortByBetyg.click();
    }
}
