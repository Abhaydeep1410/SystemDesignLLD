package designpattern.sturucturalpattern;

interface PaymentGateway{
    void sendPayment();
}
class PayU implements PaymentGateway{
    @Override
    public void sendPayment() {
        System.out.println("paying by payU");
    }
}

// now if there is another service or region api like paypal which is not implemention PaymentGateway
// we cant use it in our service directly so we make a adaptor
class Paypal {
    public void sendPayment() {
        System.out.println("paying by paypal");
    }
}

class PaypalAdaptor implements PaymentGateway{
    private final Paypal paypal;
    PaypalAdaptor(Paypal paypal){
        this.paypal=paypal;
    }
    @Override
    public void sendPayment() {
        paypal.sendPayment();
    }
}

class CheckoutService{
    PaymentGateway paymentGateway;

    CheckoutService(PaymentGateway paymentGateway){
        this.paymentGateway=paymentGateway;
    }
    void sendPayment(){
        paymentGateway.sendPayment();
    }
}

public class AdaptorPattern {
    public static void main(String[] args) {
        CheckoutService checkoutService=new CheckoutService(new PayU());
        checkoutService.sendPayment();
        CheckoutService checkoutService2=new CheckoutService(new PaypalAdaptor(new Paypal()));
        checkoutService2.sendPayment();

    }

}
