package dea;

public interface IStateMachineListener {
    void startStateOfTheMachine();
    void currentStateOfTheMachine(DeaZustand currentZustand);
    void finalStateOfTheMachine();
}
