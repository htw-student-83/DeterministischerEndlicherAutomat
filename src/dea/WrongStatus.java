package dea;

public class WrongStatus extends Throwable {
    public WrongStatus(){
        super();
    }

    public WrongStatus(String message){
        super(message);
    }
}
