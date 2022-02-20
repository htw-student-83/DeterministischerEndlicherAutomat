package dea;

public class Deterministischer_Endlicher_Automat implements Idea {

    private DeaZustand currentStatus = null;

    @Override
    public DeaZustand getStart() {
        IStateMachineListener stateMachineListener = new StateMachineListener();
        stateMachineListener.startStateOfTheMachine();
        this.currentStatus = DeaZustand.Startzustand;
        return this.currentStatus;
    }

    public void setStatus(DeaZustand zustand){
        this.currentStatus = zustand;
    }

    @Override
    public DeaZustand getZustand() {
        return this.currentStatus;
    }

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
                stateMachineListener.currentStateOfTheMachine(getZustand());
            }
        }
    }
}
