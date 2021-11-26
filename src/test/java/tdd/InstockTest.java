package tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {
    private ProductStock stock;

    @Before
    public void setUp() {
        this.stock = new Instock();
    }

    @Test
    public void testContainsShouldReturnFalseWhenProductIsAbsentAntThenTrueWhenAdded() {
        Product product = new Product("test_product", 9.99, 1);

        // Those assertions will confirm that both add and contains work as expected
        assertFalse(stock.contains(product));
        stock.add(product);
        assertTrue(stock.contains(product));
    }

    @Test
    public void testCountShouldReturnZeroWhenEmptyAndNoneZeroWhenProductsAreAdded() {
        assertEquals(0, this.stock.getCount());

        createAndAddProducts(this.stock);

        assertEquals(4, this.stock.getCount());
    }

    @Test
    public void testFindShouldReturnTheCorrectNthElement() {
        Product[] addedProducts = createAndAddProducts(this.stock);
        int index = addedProducts.length - 2;

        Product product = this.stock.find(index);
        assertNotNull(product);
        assertEquals(addedProducts[index].getLabel(), product.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldFailWhenIndexIsGreater() {
        int firstGreaterIndex = createAndAddProducts(this.stock).length;
        this.stock.find(firstGreaterIndex);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldFailWhenIndexIsNegative() {
        createAndAddProducts(this.stock);
        this.stock.find(-1);
    }

    @Test
    public void testChangeQuantityShouldUpdateTheCorrectItemInStock() {
        Product[] addedProducts = createAndAddProducts(this.stock);
        Product product = addedProducts[1];

        int newQuantity = product.getQuantity() + 13;
        this.stock.changeQuantity(product.getLabel(), newQuantity);
        assertEquals(newQuantity, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldFailWhenNoSuchProductInStock() {
        createAndAddProducts(this.stock);
        Product notAddedProduct = new Product("not_added_test_product", 9.99, 1);
        this.stock.changeQuantity(notAddedProduct.getLabel(), notAddedProduct.getQuantity() + 13);
    }

    @Test
    public void testGetByLabelShouldReturnTheCorrectProduct() {
        Product[] addedProducts = createAndAddProducts(this.stock);
        String expected = addedProducts[2].getLabel();

        Product product = this.stock.findByLabel(expected);
        assertNotNull(product);
        String actual = product.getLabel();
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByLabelShouldShouldFailWhenNoSuchProductInStock() {
        createAndAddProducts(this.stock);
        this.stock.findByLabel("not_added_test_product");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnTheCorrectNumberOfProducts() {
        Product[] addedProducts = createAndAddProducts(this.stock);
        this.stock.add(new Product("not_returned_test_product", 9.99, 1));

        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(addedProducts.length);

        int count = assertAndExtract(iterable).size();

        assertEquals(addedProducts.length, count);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnInTheCorrectOrder() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(addedProducts.length);

        List<String> actualProducts = assertAndExtract(iterable, Product::getLabel);

        List<String> expectedProducts = Arrays.stream(addedProducts)
                .map(Product::getLabel)
                .sorted()
                .collect(Collectors.toList());

        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionWhenOutOfRange() {
        Product[] addedProducts = createAndAddProducts(this.stock);

        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(addedProducts.length + 1);

        List<Product> products = assertAndExtract(iterable);
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindAllInRangeShouldReturnTheCorrectRange() {
        Product[] addedProducts = createAndAddProducts(this.stock);
        double start = addedProducts[0].getPrice();
        double end = addedProducts[2].getPrice();

        Iterable<Product> iterable = this.stock.findAllInRange(start, end);

        List<Double> returnedPrices = assertAndExtract(iterable, Product::getPrice);

        double actual = returnedPrices.get(0);

        assertEquals(1, returnedPrices.size());
        assertEquals(end, actual, 0.00);
    }

    @Test
    public void testFindAllInRangeShouldReturnTheCorrectRangeAndInCorrectOrder() {
        Product[] addedProducts = createAndAddProducts(this.stock);
        double start = addedProducts[1].getPrice();
        double end = addedProducts[3].getPrice();

        Iterable<Product> iterable = this.stock.findAllInRange(start, end);

        List<Double> returnedPrices = assertAndExtract(iterable, Product::getPrice);

        List<Double> expected = Arrays.stream(addedProducts)
                .map(Product::getPrice)
                .filter(p -> p > start && p <= end)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        assertEquals(expected, returnedPrices);
    }

    @Test
    public void testFindAllInRangeShouldReturnEmptyCollectionWhenNoneMatch() {
        createAndAddProducts(this.stock);
        double start = -10;
        double end = -5;

        Iterable<Product> iterable = this.stock.findAllInRange(start, end);

        List<Double> returnedPrices = assertAndExtract(iterable, Product::getPrice);

        assertTrue(returnedPrices.isEmpty());
    }

    @Test
    public void testFindAllByPriceShouldReturnTheCorrectProducts() {
        Product[] addedProducts = createAndAddProducts(this.stock);
        double expectedPrice = addedProducts[3].getPrice();

        Iterable<Product> iterable = this.stock.findAllByPrice(expectedPrice);

        List<Double> returnedPrices = assertAndExtract(iterable, Product::getPrice);

        assertEquals(1, returnedPrices.size());

        double actual = returnedPrices.get(0);

        assertEquals(expectedPrice, actual, 0.00);
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyWhenNoneMatch() {
        Product[] addedProducts = createAndAddProducts(this.stock);
        double expectedPrice = 1.99;

        Iterable<Product> iterable = this.stock.findAllByPrice(expectedPrice);

        List<Double> returnedPrices = assertAndExtract(iterable, Product::getPrice);

        assertTrue(returnedPrices.isEmpty());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnFirstThreeMostExpensive() {
        List<Double> expected = Arrays.stream(createAndAddProducts(this.stock))
                .map(Product::getPrice)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        double previous = Double.MAX_VALUE;

        for (double val : expected) {
            assertTrue(previous > val);
            previous = val;
        }

        Iterable<Product> iterable = this.stock.findFirstMostExpensiveProducts(3);

        List<Double> actual = assertAndExtract(iterable, Product::getPrice);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldFailWhenLessProductsAreInStock() {
        Product[] addedProducts = createAndAddProducts(this.stock);
        this.stock.findFirstMostExpensiveProducts(addedProducts.length + 1);
    }

    @Test
    public void testFindAllByQuantityShouldReturnAllProductsWithTheSameQuantity() {
        createAndAddProducts(this.stock);

        int expected = 13;

        Iterable<Product> iterable = this.stock.findAllByQuantity(expected);

        List<Integer> actual = assertAndExtract(iterable, Product::getQuantity);

        assertTrue(actual.stream().allMatch(q -> q == expected));
    }

    @Test
    public void testFindAllByQuantityShouldReturnEmptyCollectionIfNoneMatch() {
        createAndAddProducts(this.stock);

        int expected = -10;

        Iterable<Product> iterable = this.stock.findAllByQuantity(expected);

        List<Integer> actual = assertAndExtract(iterable, Product::getQuantity);

        assertTrue(actual.isEmpty());
    }

    @Test
    public void testIteratorShouldReturnAllProducts() {
        List<Product> expectedProducts = Arrays.asList(createAndAddProducts(this.stock));

        Iterator<Product> iterator = this.stock.iterator();
        assertNotNull(iterator);

        List<Product> actualProducts = new ArrayList<>();

        while (iterator.hasNext()) {
            Product p = iterator.next();
            actualProducts.add(p);
        }

        assertEquals(expectedProducts, actualProducts);
    }

    private static Product[] createAndAddProducts(ProductStock stock) {
        Product[] products = createProducts();

        for (Product product : products) {
            stock.add(product);
        }

        return products;
    }

    private static Product[] createProducts() {
        return new Product[]{
                new Product("test_product_4", 10.00, 13),
                new Product("test_product_2", 9.99, 42),
                new Product("test_product_3", 50.00, 13),
                new Product("test_product_1", 50.99, 79)
        };
    }

    private static List<Product> assertAndExtract(Iterable<Product> iterable) {
        return assertAndExtract(iterable, p -> p);
    }

    private static <T> List<T> assertAndExtract(Iterable<Product> iterable, Function<Product, T> mapper) {
        assertNotNull(iterable);

        List<T> result = new ArrayList<>();

        for (Product p : iterable) {
            result.add(mapper.apply(p));
        }

        return result;
    }
}