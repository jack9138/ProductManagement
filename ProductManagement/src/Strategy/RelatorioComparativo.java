package Strategy;

import Model.Produto;
import Model.Relatorio;
import java.util.Date;

public class RelatorioComparativo extends RelatorioStrategy {

    private Relatorio relatorio;

    @Override
    public Relatorio calcularValEntEstoque(Date dataIncio, Date dataFim) {
        return this.relatorio;
    }

    @Override
    public Relatorio calcularValSaiEstoque(Date dataIncio, Date dataFim) {
        return this.relatorio;
    }
}
