package designpattern.sturucturalpattern;

interface Pizza{
    double getCost();
}

//concreate component
class PlainPizza implements Pizza{
    @Override
    public double getCost() {
        return 40.0;
    }
}

//abstract decorator class
abstract class PizzaDecorator implements Pizza{
    protected Pizza pizza;
    public PizzaDecorator(Pizza pizza){
        this.pizza=pizza;
    }
}

//concreate class
class ExtraCheeze extends PizzaDecorator{
    public ExtraCheeze(Pizza pizza){
        super(pizza);
    }

    @Override
    public double getCost() {
        return pizza.getCost()+0.5;
    }
}

class ExtraOlive extends PizzaDecorator{
    public ExtraOlive(Pizza pizza){
        super(pizza);
    }

    @Override
    public double getCost() {
        return pizza.getCost()+1;
    }
}



public class DecoratorPattern {
    public static void main(String[] args) {
        Pizza ExtraCheezepizza=new ExtraCheeze(new PlainPizza());
        System.out.println(ExtraCheezepizza.getCost());

        Pizza extraOliveAndCheeze=new ExtraOlive(ExtraCheezepizza);
        System.out.println(extraOliveAndCheeze.getCost());
    }
}
