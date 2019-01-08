package CheckSizeOfArray;

public class MyArrayDataException extends Exception {

    private int i;
    private int j;

    public MyArrayDataException(String msg, int i, int j) {
        super(msg);
        this.i = i;
        this.j = j;
    }
}
