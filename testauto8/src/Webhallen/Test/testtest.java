package Test;

import Pages.*;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class testtest extends Webhallen.Testbase.Testbase {

    @Test
    void SearchTest() {
        Startsida startsida = new Startsida(page);
        startsida.openStartsida();
        startsida.acceptCookies();
        startsida.searchFC24();
        assertThat(page).hasURL("https://www.webhallen.com/se/search?searchString=FC24");
    }

    @Test
    void EmptyCartTest() {
        Startsida startsida = new Startsida(page);
        startsida.openStartsida();
        startsida.acceptCookies();
        startsida.cartClick();
        assertThat(startsida.cartPopup).hasText("Din varukorg är tom");

    }

    @Test
    void DropdownTest() {
        Startsida startsida = new Startsida(page);
        startsida.openStartsida();
        startsida.acceptCookies();
        startsida.dropdownClickExklusive();
        assertThat(startsida.dropdown).containsText("exklusive");

    }

    @Test
    void CategoryNavigateTest() {
        Startsida startsida = new Startsida(page);
        startsida.openStartsida();
        startsida.acceptCookies();
        startsida.chooseCategorySpel();
        assertThat(page).hasURL("https://www.webhallen.com/se/section/1-Spel");
    }

    @Test
    void CartTest() {
        ProduktsidaScooter produktsidaScooter = new ProduktsidaScooter(page);
        produktsidaScooter.openProduktSida();
        produktsidaScooter.acceptCookies();
        produktsidaScooter.addScooterToCart();
        produktsidaScooter.openVarukorg();
        assertThat(produktsidaScooter.cartTotal).hasValue("1");
    }

    @Test
    void presentkortButtonTest() {
        PresentkortSida presentkortSida = new PresentkortSida(page);
        presentkortSida.openPresentkortSida();
        presentkortSida.acceptCookies();
        presentkortSida.addThree();
        assertThat(presentkortSida.antalPresentkort).hasValue("4");
    }

    @Test
    void cartAddAndDeleteTest(){
        ProduktsidaScooter produktsidaScooter = new ProduktsidaScooter(page);
        produktsidaScooter.openProduktSida();
        produktsidaScooter.acceptCookies();
        produktsidaScooter.addScooterToCart();
        produktsidaScooter.openVarukorg();
        produktsidaScooter.cartPlusOne();
        produktsidaScooter.cartPlusOne();
        produktsidaScooter.cartPlusOne();
        produktsidaScooter.cartMinusOne();
        produktsidaScooter.cartMinusOne();
        assertThat(produktsidaScooter.cartTotal).hasValue("2");
    }

    @Test
    void cartDeleteAllFromCart(){
        ProduktsidaScooter produktsidaScooter = new ProduktsidaScooter(page);
        produktsidaScooter.openProduktSida();
        produktsidaScooter.acceptCookies();
        produktsidaScooter.addScooterToCart();
        produktsidaScooter.openVarukorg();
        produktsidaScooter.cartPlusOne();
        produktsidaScooter.cartDeleteAll();
        assertThat(produktsidaScooter.cartPopup).hasText("Din varukorg är tom");
    }

    @Test
    void bliMedlemButtonTest(){
        MedlemSida medlemSida = new MedlemSida(page);
        medlemSida.openMedlemSida();
        medlemSida.acceptCookies();
        medlemSida.bliMedlemButtonClick();
        assertThat(medlemSida.bliMedlemPopup).hasText("Skapa konto");
    }

    @Test
    public void filterTest(){
        SokResultatFC24 sokResultatFC24 = new SokResultatFC24(page);
        sokResultatFC24.openSokResultatFC24();
        sokResultatFC24.acceptCookies();
        sokResultatFC24.filterByScore();
        assertThat(page).hasURL("https://www.webhallen.com/se/search?searchString=FC24&sortBy=reviewScore");
    }

    @Test
    public void anvandaOlikaPagesTest(){
        Startsida startsida = new Startsida(page);
        startsida.openStartsida();
        startsida.acceptCookies();
        startsida.searchFC24();
        SokResultatFC24 sokResultatFC24 = new SokResultatFC24(page);
        sokResultatFC24.filterByScore();
        assertThat(page).hasURL("https://www.webhallen.com/se/search?searchString=FC24&sortBy=reviewScore");
    }

}


