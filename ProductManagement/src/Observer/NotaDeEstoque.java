package Observer;

import Model.SaiEstoque;

public class NotaDeEstoque extends NotaListener {

    private SaiEstoque Nota;

    public void getNota(SaiEstoque nota) {
        this.Nota = nota;
        this.getNota(Nota);
    }
}
