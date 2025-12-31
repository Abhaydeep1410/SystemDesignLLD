package designpattern.creationalpattern.abstractfactory;
// 1. we have payment gateway with multiple payment options
interface PaymentGateway {
    void createPayment();
}
class PayU implements PaymentGateway {
    @Override
    public void createPayment() {
        System.out.println("paying by payU");
    }
}
class RazorPay implements PaymentGateway {
    @Override
    public void createPayment() {
        System.out.println("paying by RazorPay");
    }
}
class Paypal implements PaymentGateway {
    @Override
    public void createPayment() {
        System.out.println("paying by paypal");
    }
}

// 2. we have multiple invoices
interface Invoice{
    void createInvoice();
}
class GstInvoice implements Invoice{
    @Override
    public void createInvoice() {
        System.out.println("invoicing GstInvoice");
    }
}
class USInvoice implements Invoice{
    @Override
    public void createInvoice() {
        System.out.println("invoicing US Invoice");
    }
}


//3. if we are making a IndianCheckout we had to make a IndianPaymentGatewayFactory and Indian Invoice
// and if we switch to USCheckout we have to again do this
// to avoid this lets make a interface with both functionalities
interface RegionFactory{
    PaymentGateway createPaymentGateway(String gatewayType);
    Invoice createInvoice();
}

// 4. now out IndianFactory and UsFactory will implement this RegionFactory
class IndianFactory implements RegionFactory{

    @Override
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if(gatewayType.equalsIgnoreCase("payU")){
            return new PayU();
        }else if(gatewayType.equalsIgnoreCase("razorPay")){
            return new RazorPay();
        }
        throw new IllegalArgumentException("Unknown gateway type");
    }

    @Override
    public Invoice createInvoice() {
        return new GstInvoice();
    }
}
// now we can similarly create UsFactory  , JapanFactory ...........


//5. create a checkout service
class CheckoutService{
    PaymentGateway paymentGateway;
    Invoice invoice;
    CheckoutService(RegionFactory regionFactory, String gatewayType) {
        this.paymentGateway = regionFactory.createPaymentGateway(gatewayType);
        this.invoice = regionFactory.createInvoice();
    }

    void checkout(){
        paymentGateway.createPayment();
        invoice.createInvoice();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        CheckoutService checkoutService=new CheckoutService(new IndianFactory(), "payu");
        checkoutService.checkout();
    }
}
