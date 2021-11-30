package Strategy;

import Model.Produto;
import Model.Relatorio;
import java.util.Date;

public abstract class RelatorioStrategy {

    public abstract Relatorio calcularValEntEstoque(Date dataInicio, Date dataFim);

    public abstract Relatorio calcularValSaiEstoque(Date dataInicio, Date dataFim);
}
