package Observer;

import Model.SaiEstoque;
import java.util.Date;

public interface EventNota {

    public String notifyNota(SaiEstoque saidaEstoque, Date dataSaida);
}
