package Model;

public class MarcaModelo {

    private int idMarca;

    private String nomeMarca;

    private char statusMarca;

    private int idModelo;

    private String nomeModelo;

    private char statusModelo;

    public MarcaModelo() {
    }

    public MarcaModelo(int idMarca, String nomeMarca, char statusMarca, int idModelo, String nomeModelo, char statusModelo) {
        this.idMarca = idMarca;
        this.nomeMarca = nomeMarca;
        this.statusMarca = statusMarca;
        this.idModelo = idModelo;
        this.nomeModelo = nomeModelo;
        this.statusModelo = statusModelo;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getIdMarca() {
        return this.idMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public String getNomeMarca() {
        return this.nomeMarca;
    }

    public void setStatusMarca(char statusMarca) {
        this.statusMarca = statusMarca;
    }

    public char getStatusMarca() {
        return this.statusMarca;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdModelo() {
        return this.idModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public String getNomeModelo() {
        return this.nomeModelo;
    }

    public void setStatusModelo(char statusModelo) {
        this.statusModelo = statusModelo;
    }

    public char getStatusModelo() {
        return this.statusModelo;
    }
}
