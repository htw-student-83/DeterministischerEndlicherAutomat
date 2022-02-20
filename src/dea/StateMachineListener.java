package dea;

public class StateMachineListener implements IStateMachineListener {

    /**
     * Gibt die Meldung aus, das sich der Automat im Startzustand befindet.
     */
    @Override
    public void startStateOfTheMachine() {
        System.out.println("Der Automat wurde gestartet.");
    }

    /**
     * Gibt die Meldung aus, das der Automat seinen Zustand gewechselt hat.
     */
    @Override
    public void currentStateOfTheMachine(DeaZustand state) {
        System.out.println("Neuer Zustand des Automaten: " + state);
    }


    /**
     * Gibt die Meldung aus, das der Automat im Endzustand nun ist.
     */
    @Override
    public void finalStateOfTheMachine() {
        System.out.println("Endzustand ist erreicht.");
    }
}
