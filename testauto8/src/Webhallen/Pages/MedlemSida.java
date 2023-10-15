package Pages;

import Pagebase.PageBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class MedlemSida extends PageBase {
    Page page;
    public Locator bliMedlemButton;
    public Locator cookies;
    public Locator bliMedlemPopup;

    public MedlemSida(Page page) {
        this.page = page;
        this.bliMedlemButton = page.locator("#becomeMember");
        this.cookies = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Okej, jag förstår"));
        this.bliMedlemPopup = page.locator("div.add-to-wislisht-member-form h2:has-text('Skapa konto')");

    }

    public void openMedlemSida() {
        String medlemSidaUrl = "https://www.webhallen.com/se/info/6-Medlem-hos-Webhallen";
        page.navigate(medlemSidaUrl);
    }

    public void acceptCookies(){
        if (cookies.isVisible()) {
            cookies.click();
        }
    }

    public void bliMedlemButtonClick(){
        bliMedlemButton.click();
    }
}
