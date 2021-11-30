package Observer;

import Model.SaiEstoque;
import java.util.Date;

public abstract class NotaListener {

    private String Nota;

    EventNota eventNota = new EventNota() {

        @Override
        public String notifyNota(SaiEstoque saidaEstoque, Date dataSaida) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    };

    public String getNota(SaiEstoque saiEstoque, Date dataSaida) {
        return Nota;
    }

    ;
}
