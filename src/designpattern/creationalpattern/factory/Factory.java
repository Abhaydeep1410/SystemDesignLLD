package designpattern.creationalpattern.factory;

interface Logistic{
    void send();
}

class Air implements Logistic{
    @Override
    public void send() {
        System.out.println("sending by air");
    }
}
class Road implements Logistic{
    @Override
    public void send() {
        System.out.println("sending by road");
    }
}

class LogisticFactory {
    static Logistic getLogistic(String mode){
        if(mode.equals("air")){
            return new Air();
        }
        else return new Road();
    }
}

class LogisticService {
    void send(String mode){
        Logistic logistic = LogisticFactory.getLogistic(mode);
        logistic.send();
    }
}

public class Factory {
    public static void main(String[] args) {
        LogisticService logisticService=new LogisticService();
        logisticService.send("air");
        logisticService.send("road");
    }
}
