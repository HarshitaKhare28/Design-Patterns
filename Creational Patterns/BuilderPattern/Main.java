// Main.java

class Pizza {
    // Required parameter
    private final String size;

    // Optional parameters
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean extraSauce;

    // Private constructor
    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.extraSauce = builder.extraSauce;
    }

    // Static nested Builder class
    public static class Builder {
        private final String size;
        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean extraSauce = false;

        public Builder(String size) {
            this.size = size;
        }

        public Builder addCheese() {
            this.cheese = true;
            return this;
        }

        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public Builder addExtraSauce() {
            this.extraSauce = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    public void displayPizza() {
        System.out.println("Pizza size: " + size);
        System.out.println("Cheese: " + cheese);
        System.out.println("Pepperoni: " + pepperoni);
        System.out.println("Extra Sauce: " + extraSauce);
    }
}

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder("Large")
                            .addCheese()
                            .addPepperoni()
                            .build();

        pizza.displayPizza();
    }
}
