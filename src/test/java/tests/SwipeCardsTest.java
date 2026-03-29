package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MenuPage;
import pages.SwipePage;

/**
 * Clase de prueba para validar los gestos de deslizamiento (Swipe)
 * horizontal y vertical en la aplicación.
 */
public class SwipeCardsTest extends BaseTest {

    @Test
    public void testSwipeGestures() {
        MenuPage menuPage = new MenuPage(driver);
        SwipePage swipePage = new SwipePage(driver);

        System.out.println("1. Navegando a la sección de Swipe...");
        menuPage.tapOnSwipe();
        Assert.assertTrue(swipePage.isSwipeScreenVisible(), "Error: No estamos en la pantalla Swipe.");

        System.out.println("2. Deslizando una vez para ocultar la primera tarjeta...");
        swipePage.swipeToNextCard();

        Assert.assertTrue(swipePage.isFirstCardHidden(), "Error: La primera tarjeta sigue visible.");

        System.out.println("3. Deslizando hasta la última tarjeta...");
        int maxSwipes = 10;
        while (!swipePage.isLastCardVisible() && maxSwipes > 0) {
            swipePage.swipeToNextCard();

            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            maxSwipes--;
        }
        Assert.assertTrue(swipePage.isLastCardVisible(), "Error: No se pudo encontrar la última tarjeta.");

        System.out.println("4. Haciendo scroll vertical hacia abajo...");
        swipePage.scrollToHiddenText();

        Assert.assertTrue(swipePage.isHiddenTextVisible(), "Error: El texto 'You found me!!!' no apareció.");

        System.out.println("Prueba de swipe terminada");
    }
}