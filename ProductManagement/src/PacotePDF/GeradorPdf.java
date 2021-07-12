/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author jaque
 */
public class GeradorPdf {
    
    // cria o documento pdf
    private Document document;
    private String nomeRelatorio;
    private List<Relatorio> listDadosRel= new ArrayList();
    
    //gera os relatorios de Entrada e Saida
    public void gerarRelatorioSimples(List<Relatorio> relatorio) {
         document = new Document();
         listDadosRel.addAll(relatorio);
         
          try {
            
           
              
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\jaque\\Documents\\LPIII\\PJInterdisciplinar\\Relatorio.pdf"));
            document.open();
            
            //Montagem do relatorio
            document.addTitle(nomeRelatorio);//Informa o titulo do relatorio
            //Cria a tabela do PDF
            PdfPTable tabela = new PdfPTable(7);
            
            tabela.addCell("Nome Produto");
            tabela.addCell("Marca");
            tabela.addCell("Modelo");
            tabela.addCell("Preco.Unid");
            tabela.addCell("Quantidade Estoque");
            tabela.addCell("Valor Total");
            tabela.addCell("Data");
            
            
             //Passa a lista de registros para adicionar na celula
             for (Iterator<Relatorio> it = listDadosRel.iterator(); it.hasNext();) {
                 Object r = it.next();
                 tabela.addCell(listDadosRel.get((int) r).getNomeProduto());
                 tabela.addCell(listDadosRel.get((int) r).getNomeMarca());
                 tabela.addCell(listDadosRel.get((int) r).getNomeModelo());
                 tabela.addCell(Double.toString(listDadosRel.get((int) r).getPrecoUnid()));
                 tabela.addCell(Integer.toString(listDadosRel.get((int) r).getQtdEstoque()));
                 tabela.addCell(Double.toString(listDadosRel.get((int) r).getValorTotal()));
                 tabela.addCell(listDadosRel.get((int) r).getDataComum().toString());
             }
            
            document.add(tabela);
        }catch(DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }
          
          document.close();
    }
    //Gera o relatorio Comparativo
    public void gerarRelatorioComparativo(List<Relatorio> relatorio) {
         document = new Document();
        
          try {

            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\jaque\\Documents\\LPIII\\PJInterdisciplinar\\Relatorio.pdf"));
            document.open();

            //Montagem do relatorio
            document.addTitle(nomeRelatorio);//Informa o titulo do relatorio
            
            
        }catch(DocumentException de) {
            System.err.println(de.getMessage());
        }catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
          
          document.close();
    }
}
