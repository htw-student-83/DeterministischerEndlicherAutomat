package dea;

public class StateMachineListener implements IStateMachineListener {

    /**
     * Der Automat hat den Startzustand erreicht.
     */
    @Override
    public void startStateOfTheMachine() {
        System.out.println("Der Automat wurde gestartet.");
    }

    /**
     * Der Automat hat seinen Zustand geändert.
     */
    @Override
    public void currentStateOfTheMachine(DeaZustand state) {
        System.out.println("Neuer Zustand des Automaten: " + state);
    }


    /**
     * Der Automat ist nun im Endzustand angekommen.
     */
    @Override
    public void finalStateOfTheMachine() {
        System.out.println("Endzustand ist erreicht.");
    }
}
