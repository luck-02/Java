package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setup() {
        cart = new ShoppingCart();
    }

    @Test
    void creation_panier_vide(){
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void ajout_produit() {
        Product stylo = new Product("Stylo", 1.5);
        cart.addProduct(stylo);
        assertEquals(1, cart.getItemCount());
        assertEquals(1.5, cart.getTotalPrice());
    }

    @Test
    void total_panier(){
        Product livre = new Product("Livre", 20.0);
        Product cahier = new Product("Cahier", 5.0);
        cart.addProduct(livre);
        cart.addProduct(cahier);
        assertEquals(2, cart.getItemCount());
        assertEquals(25.0, cart.getTotalPrice());
    }

    @Test
    void produit_null() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addProduct(null);
        });
    }

    @Test
    void produit_prix_negatif() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("Tasse", -10.0);
        });
    }

    @Test
    void panier_vide() {
        cart.addProduct(new Product("Clavier", 30.0));
        cart.clearCart();
        assertEquals(0, cart.getItemCount());
    }
}
