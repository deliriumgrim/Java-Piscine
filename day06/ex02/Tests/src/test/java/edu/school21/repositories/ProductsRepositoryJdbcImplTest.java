package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ProductsRepositoryJdbcImplTest {

    EmbeddedDatabase dataSource;
    ProductsRepository productsRepository;

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(0L, "Car", 1500L),
            new Product(1L, "Phone", 5500L),
            new Product(2L, "Knife", 6500L),
            new Product(3L, "Notebook", 3500L),
            new Product(4L, "World", 1500L)
    );
    final Product EXPECTED_FIND_BY_ID_PRODUCTS = new Product(3L, "Notebook", 3500L);
    final Product EXPECTED_UPDATED_ID_PRODUCTS = new Product(1L, "Updated Product", 123L);
    final Product EXPECTED_SAVED_PRODUCTS = new Product(5L, "Saved Product", 123L);

    @BeforeEach
    void init() {
        dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        productsRepository = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    void testFindAll() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, productsRepository.findAll());
    }

    @Test
    void testFindByIdProducts() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCTS, productsRepository.findById(3L).get());
    }

    @Test
    void testUpdate() throws SQLException {
        productsRepository.update(new Product(1L, "Updated Product", 123L));
        Assertions.assertEquals(EXPECTED_UPDATED_ID_PRODUCTS, productsRepository.findById(1L).get());
    }

    @Test
    void testSave() throws SQLException {
        productsRepository.save(EXPECTED_SAVED_PRODUCTS);
        Assertions.assertEquals(EXPECTED_SAVED_PRODUCTS, productsRepository.findById(5L).get());
    }

    @Test
    void testDelete() throws SQLException {
        Long expectedSize = productsRepository.findAll().size() - 1L;
        productsRepository.delete(4L);
        Assertions.assertEquals(expectedSize, productsRepository.findAll().size());
    }

    @AfterEach
    void close() {
        dataSource.shutdown();
    }
}
