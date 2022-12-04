package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {


    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product product1 = new Book(1, "Книга 1", 500, "Автор1");
    Product product2 = new Smartphone(2, "Смартфон 1", 10_000, "производитель1");
    Product product3 = new Book(3, "Книга 1", 1_000, "Автор2");



    @Test
    public void add() {

        repo.add(product1);
        repo.add(product2);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void search() {


        manager.add(product1);
        manager.add(product2);
        manager.add(product3);


        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Смартфон 1");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void removeById() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        repo.removeById(product2.getId());

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void searchNull() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);


        Product[] expected = {};
        Product[] actual = manager.searchBy("Книга10");


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void searchTwoResult() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = {product1, product3};
        Product[] actual = manager.searchBy("Книга 1");


        Assertions.assertArrayEquals(expected, actual);

        }

}