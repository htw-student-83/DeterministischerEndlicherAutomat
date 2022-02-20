package dea;

public interface IStateMachineListener {


    /**
     * Informiert, dass der Automat gestartet wurde.
     */
    void startStateOfTheMachine();


    /**
     * Informiert, dass der Automat seinen Zustand geändert hat.
     * @param currentZustand
     */
    void currentStateOfTheMachine(DeaZustand currentZustand);


    /**
     * Informiert, dass der Automat den Endzustand erreicht hat.
     */
    void finalStateOfTheMachine();
}
