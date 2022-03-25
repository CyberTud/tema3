
package Pizza;


import Pizza.enms.PizzaType;
import Pizza.enms.Topping;
import Pizza.pizzas.*;

import java.util.Observable;
import java.util.Observer;

public class PizzaFactory implements Observer, Command{

    private static PizzaFactory uniqueInstance;
    PizzaType pizzaTypes;
    Topping toppingTypes;
    public Observer observer;
    Client client;
    private PizzaFactory() {

    }

    public static PizzaFactory instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new PizzaFactory();
        }
        return uniqueInstance;
    }

    public Pizza createPizza(PizzaType type) {
        switch (type) {
            case CAPRICIOSA:
                return new Capriciosa();
            case PROSCIUTTO_FUNGHI:
                return new ProsciuttoFunghi();
            case QUATRO_STAGIONI:
                return new QuatroStagioni();
            case MARGUERITA:
                return new Marguerita();
        }
        return null;
    }

    @Override
    public void update(Observable o, Object arg) {
       client.notifyy();
    }

    @Override
    public void execute() {
        client.order();
    }
}

class PizzaDecorator extends Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

class ToppingDecorator extends PizzaDecorator {
    public ToppingDecorator(Pizza pizza) {
        super(pizza);
    }
}
