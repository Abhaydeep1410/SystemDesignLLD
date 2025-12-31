package designpattern.creationalpattern.builder;

class Burger{
    String bun;
    String patty;
    Boolean hasCheeze;
    Boolean hasPaneer;

    private Burger(BurgerBuilder builder){
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.hasCheeze = builder.hasCheeze;
        this.hasPaneer = builder.hasPaneer;
    }

    static class BurgerBuilder{
        //mandatory
        String bun;
        String patty;
        // optional
        Boolean hasCheeze;
        Boolean hasPaneer;

        BurgerBuilder(String bun, String patty){
            this.bun = bun;
            this.patty = patty;
        }
        BurgerBuilder hasCheeze(boolean hasCheeze){
            this.hasCheeze = hasCheeze;
            return this;
        }
        BurgerBuilder hasPaneer(boolean hasPaneer){
            this.hasPaneer = hasPaneer;
            return this;
        }

        Burger build(){
            return new Burger(this);
        }
    }
}


public class Builder {
    public static void main(String[] args) {
        Burger burger=new Burger.BurgerBuilder("wheat","veg").hasCheeze(true).build();
        Burger burger2=new Burger.BurgerBuilder("wheat","veg").hasPaneer(false).hasCheeze(true).build();
    }
}
