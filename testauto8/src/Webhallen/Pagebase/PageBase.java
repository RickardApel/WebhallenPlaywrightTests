package Pagebase;

import com.microsoft.playwright.Page;

public class PageBase {

    Page page;

    public PageBase() {
    }

    public PageBase(Page page) {
        this.page = page;
    }

}