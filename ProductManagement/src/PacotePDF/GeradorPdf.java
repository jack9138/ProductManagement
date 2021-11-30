package PacotePDF;

import Model.Relatorio;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class GeradorPdf {

    private Document document;

    private String nomeRelatorio;

    private List<Relatorio> listDadosRel = new ArrayList();

    public void gerarRelatorioSimples(List<Relatorio> relatorio) {
        document = new Document();
        listDadosRel.addAll(relatorio);
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\jaque\\Documents\\LPIII\\PJInterdisciplinar\\Relatorio.pdf"));
            document.open();
            document.addTitle(nomeRelatorio);
            PdfPTable tabela = new PdfPTable(7);
            tabela.addCell("Nome Produto");
            tabela.addCell("Marca");
            tabela.addCell("Modelo");
            tabela.addCell("Preco.Unid");
            tabela.addCell("Quantidade Estoque");
            tabela.addCell("Valor Total");
            tabela.addCell("Data");
            for (Iterator<Relatorio> it = listDadosRel.iterator(); it.hasNext(); ) {
                Object r = it.next();
               //reimplementar
            }
            document.add(tabela);
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }
        document.close();
    }

    public void gerarRelatorioComparativo(List<Relatorio> relatorio) {
        document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\jaque\\Documents\\LPIII\\PJInterdisciplinar\\Relatorio.pdf"));
            document.open();
            document.addTitle(nomeRelatorio);
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
    }
}
