package dea;

public class WrongStatus extends Exception {
    public WrongStatus(){
        super();
    }

    public WrongStatus(String message){
        super(message);
    }
}
