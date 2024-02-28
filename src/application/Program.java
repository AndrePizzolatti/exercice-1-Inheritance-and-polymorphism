package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> productsList = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int numberOfProducts = sc.nextInt();
        sc.nextLine();

        for (int i=1; i<=numberOfProducts; i++) {
            System.out.println("Product #" + i + " data:");

            System.out.print("Common, used or imported (c/u/i)? ");
            char typeOfProduct = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            switch (typeOfProduct) {
                case 'c':
                    productsList.add(new Product(name, price));
                    break;

                case 'i':
                    System.out.print("Customs fee: ");
                    double customsFee = sc.nextDouble();
                    productsList.add(new ImportedProduct(name, price, customsFee));
                    break;

                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    String manufactureDate = sc.next();
                    productsList.add(new UsedProduct(name, price, manufactureDate));
                    break;

                default:
                    System.out.print("Product type does not exist!");
                    break;
            }
        }

        sc.close();

        System.out.println();
        System.out.println("PRICE TAGS:");

        for (Product product : productsList) {
            System.out.println(product.priceTag());
        }
    }
}
