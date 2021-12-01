package desingPatterns.template;

public class LocalStorePurchase extends TemplatePurchase {
    @Override
    protected void getItemsFromCart() {
        System.out.println("Getting items and putting them on the counter");
    }

    @Override
    protected void calculatePricesWithDiscounts() {
        System.out.println("Discounted four items");
    }

    @Override
    protected void createReceipt() {
        System.out.println("Printing receipt");
    }

    @Override
    protected void payOrder() {
        System.out.println("Paying with cash");
    }

    @Override
    protected void notifyClient() {
        System.out.println("Say done to client and goodbye");
    }
}
