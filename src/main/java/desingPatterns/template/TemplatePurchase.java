package desingPatterns.template;

public abstract class TemplatePurchase {

    public final void purchaseOrder() {
        getItemsFromCart();
        calculatePricesWithDiscounts();
        createReceipt();
        payOrder();
        notifyClient();
    }

    protected abstract void getItemsFromCart();
    protected abstract void calculatePricesWithDiscounts();
    protected abstract void createReceipt();
    protected abstract void payOrder();
    protected abstract void notifyClient();




}
