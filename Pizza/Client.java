package Pizza;

import Pizza.enms.PizzaType;
import Pizza.enms.Topping;

public class Client {

    PizzaType pizzaTypes;
    Topping toppingTypes;


    public Client(PizzaType pizzaTypes, Topping toppingTypes) {
        this.pizzaTypes = pizzaTypes;
        this.toppingTypes = toppingTypes;
    }

    public void order() {
        System.out.println("Ordered pizza");
        PizzaFactory.instance().createPizza(pizzaTypes);
    }

    public void notifyy() {
        System.out.println("Your pizza is done!");
    }
}
