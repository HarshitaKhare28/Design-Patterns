// State interface that defines the common behavior
interface VendingMachineState {
    void insertCoin();
    void ejectCoin();
    void turnCrank();
    void dispense();
}

// Context class
class VendingMachine {
    private VendingMachineState currentState;
    private VendingMachineState noCoinState;
    private VendingMachineState hasCoinState;
    private VendingMachineState soldOutState;

    public VendingMachine() {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldOutState = new SoldOutState(this);
        currentState = noCoinState; // Initially no coin inserted
    }

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void ejectCoin() {
        currentState.ejectCoin();
    }

    public void turnCrank() {
        currentState.turnCrank();
        currentState.dispense();
    }

    public VendingMachineState getNoCoinState() {
        return noCoinState;
    }

    public VendingMachineState getHasCoinState() {
        return hasCoinState;
    }

    public VendingMachineState getSoldOutState() {
        return soldOutState;
    }
}

// Concrete States
class NoCoinState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public NoCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted.");
        vendingMachine.setState(vendingMachine.getHasCoinState());
    }

    @Override
    public void ejectCoin() {
        System.out.println("No coin to eject.");
    }

    @Override
    public void turnCrank() {
        System.out.println("Please insert a coin first.");
    }

    @Override
    public void dispense() {
        System.out.println("No item dispensed.");
    }
}

class HasCoinState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public HasCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You already inserted a coin.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Coin returned.");
        vendingMachine.setState(vendingMachine.getNoCoinState());
    }

    @Override
    public void turnCrank() {
        System.out.println("Crank turned. Dispensing item...");
        vendingMachine.setState(vendingMachine.getNoCoinState()); // Item is dispensed, reset to no coin state.
    }

    @Override
    public void dispense() {
        System.out.println("Item dispensed.");
    }
}

class SoldOutState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public SoldOutState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Sold out! Coin returned.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("No coin to eject.");
    }

    @Override
    public void turnCrank() {
        System.out.println("Sold out! Cannot turn crank.");
    }

    @Override
    public void dispense() {
        System.out.println("Sold out! No item dispensed.");
    }
}

// Main class to test the State pattern
public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        // Test NoCoin state
        machine.insertCoin();
        machine.turnCrank();
        System.out.println();

        // Test HasCoin state
        machine.insertCoin();  // Already inserted
        machine.ejectCoin();
        machine.turnCrank();
        System.out.println();

        // Test SoldOut state
        machine.setState(machine.getSoldOutState());
        machine.insertCoin();
        machine.turnCrank();
    }
}
