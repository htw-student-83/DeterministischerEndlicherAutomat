package dea;

public class Deterministischer_Endlicher_Automat implements Idea {

    private DeaZustand currentStatus = null;


    /**
     * Zu Beginn wird der Automat in den Startzustand gebracht, worüber ein Listener-Objekt informiert wird.
     * @return currentStatus
     */
    @Override
    public DeaZustand getStart() {
        IStateMachineListener stateMachineListener = new StateMachineListener();
        stateMachineListener.startStateOfTheMachine();
        this.currentStatus = DeaZustand.Startzustand;
        return this.currentStatus;
    }


    /**
     * Verändert nach dem Einlesen eines gültigen Zeichens den Zustand.
     * @param zustand
     */
    @Override
    public void setStatus(DeaZustand zustand){
        this.currentStatus = zustand;
    }


    /**
     * Gibt den aktuellen Zustand wieder, in dem sich der Automat befindet.
     * @return currentStatus
     */
    @Override
    public DeaZustand getZustand() {
        return this.currentStatus;
    }


    /**
     * Wechsel des Zustandes unter der Prüfung der Eingabe eines Zeichens.
     * @param zeichen
     * @throws Exception
     */
    @Override
    public void readSign(String zeichen)throws Exception{
        IStateMachineListener stateMachineListener = new StateMachineListener();

        if(getZustand()==null){
            throw new WrongStatus("Automat wurde noch nicht gestartet, um Zeichen einzulesen.");
        }
        if ((getZustand() == DeaZustand.Startzustand || getZustand() == DeaZustand.Zwischenzustand) &&
                !zeichen.equals("A") && !zeichen.equals("0") && !zeichen.equals("B")){
            throw new WrongSign("Das eingebene Zeichen ist ungültig.");
        }else{
            if(getZustand() == DeaZustand.Startzustand && (zeichen.equals("A") || zeichen.equals("0"))){
                setStatus(DeaZustand.Zwischenzustand);
                stateMachineListener.currentStateOfTheMachine(getZustand());
            }else if(getZustand() == DeaZustand.Zwischenzustand && (zeichen.equals("A") || zeichen.equals("0"))){
                setStatus(DeaZustand.Zwischenzustand);
                stateMachineListener.currentStateOfTheMachine(getZustand());
            }else if(getZustand() == DeaZustand.Startzustand || getZustand() == DeaZustand.Zwischenzustand &&
                    ((zeichen.equals("B") || zeichen.equals("0")))){
                setStatus(DeaZustand.Endzustand);
                stateMachineListener.finalStateOfTheMachine();
            }
        }
    }
}
