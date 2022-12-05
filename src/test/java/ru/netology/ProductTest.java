package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {


    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product product1 = new Book(1, "Книга 1", 500, "Автор1");
    Product product2 = new Smartphone(2, "Смартфон 1", 10_000, "производитель1");
    Product product3 = new Book(3, "Книга 1", 1_000, "Автор2");
    Product product4 = new Smartphone(2, "Смартфон 2", 100_000, "производитель2");



    @Test
    public void add() {

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);


        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void addWhenAlreadyExist() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);


        Assertions.assertThrows(AlreadyExistsException.class,
             () -> repo.add(product4));
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

    public void removeByIdWhenNotFound() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);


        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(5));
    }

}