package designpattern.sturucturalpattern;

class PaymentService{  void pay(){} }

class SeatReservationService{ void reserve(){} }
class NotificationService{ void send(){} }


// so client have to call all the service , in Facade pattern we can make then together

class MovieBookingService{
    private final PaymentService paymentService;
    private final SeatReservationService seatReservationService;
    private final NotificationService notificationService;

    MovieBookingService(){
        this.paymentService=new PaymentService();
        this.seatReservationService=new SeatReservationService();
        this.notificationService=new NotificationService();
    }

    void bookMovie(){
        paymentService.pay();
        seatReservationService.reserve();
        notificationService.send();
    }
}


public class FacadePattern {
    public static void main(String[] args) {
        MovieBookingService movieBookingService=new MovieBookingService();
        movieBookingService.bookMovie();
    }
}
