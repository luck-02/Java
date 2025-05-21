import model.Product;
import model.ShoppingCart;

import java.util.Scanner;

public class ShoppingCartConsole {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Panier");

        while (true) {
            System.out.println("\n1. Ajouter un produit");
            System.out.println("2. Voir le total");
            System.out.println("3. Vider le panier");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // flush

            switch (choix) {
                case 1:
                    System.out.print("Nom du produit : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    try {
                        cart.addProduct(new Product(nom, prix));
                        System.out.println("Produit ajouté");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erreur : " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Total : " + cart.getTotalPrice() + " €");
                    break;
                case 3:
                    cart.clearCart();
                    System.out.println("Panier vidé !");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }
}
