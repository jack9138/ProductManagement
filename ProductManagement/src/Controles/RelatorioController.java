package Controles;

import DAO.RelatorioDao;
import Model.Relatorio;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import PacotePDF.GeradorPdf;
import Strategy.RelatorioStra;

public class RelatorioController implements Initializable {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnGerarRelatorio;

    @FXML
    private TextField txtDataDeInicio;

    @FXML
    private TextField txtDataFim;

    private Relatorio relatorio = new Relatorio();

    private RelatorioDao relatDao = new RelatorioDao();

    private GeradorPdf gerarRela = new GeradorPdf();

    private RelatorioStra relatorioStra = new RelatorioStra();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Controller Relatorio inicializado!");
    }

    @FXML
    public void onActionGeraRelatorio() throws ParseException {
        Stage stage;
        Date dataInicio;
        Date dataFim;
        java.sql.Date dataInicioR;
        java.sql.Date dataFimR;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
            stage = (Stage) btnGerarRelatorio.getScene().getWindow();
            dataInicio = formato.parse(formato.format(txtDataDeInicio.getText()));
            dataFim = formato.parse(formato.format(txtDataFim.getText()));
            dataInicioR = new java.sql.Date(dataInicio.getTime());
            dataFimR = new java.sql.Date(dataFim.getTime());
            if ("Relatorio - Entrada de Estoque".equals(stage.getTitle())) {
                gerarRela.gerarRelatorioSimples(relatDao.relatorioEntradaEstoque(dataInicioR, dataFimR));
            } else if ("Relatorio - Retirada de Estoque".equals(stage.getTitle())) {
                gerarRela.gerarRelatorioSimples(relatDao.relatorioSaidaEstoque(dataInicioR, dataFimR));
            } else if ("Relatorio - Comparativo de Estoque".equals(stage.getTitle())) {
                gerarRela.gerarRelatorioComparativo(relatDao.relatorioComparativo(dataInicioR, dataFimR));
            }
        } catch (ParseException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void onActionCancelar() {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
}
