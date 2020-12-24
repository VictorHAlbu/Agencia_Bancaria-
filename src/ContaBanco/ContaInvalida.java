package ContaBanco;

public class ContaInvalida extends Exception {

    public ContaInvalida() {
    }

    public ContaInvalida(String msg) {
        super(msg);
    }
}


