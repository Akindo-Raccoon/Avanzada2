package Modelo;

/**
 *
 * @author manol
 */
public class ExcepcionFormatoEntrada extends Exception {

    private int Nro;
    private String msj;

    public ExcepcionFormatoEntrada(int Nro) {
        this.Nro = Nro;
        switch (Nro) {
            case 101:
                msj = "No se admiten valores nulos.";
                break;
            case 102:
                msj = "No se admiten valores numericos.";
                break;
            case 103:
                msj = "No se admiten valores alfabeticos.";
            default:
                throw new AssertionError();
        }
        this.Nro = Nro;
    }

    public ExcepcionFormatoEntrada(int Nro, String dato) {
        this.Nro = Nro;
        switch (Nro) {
            case 101:
                msj = "No se admiten valores nulos...";
                break;
            case 102:
                msj = "No se admiten valores numericos. Generado por: '" + dato + "'";
                break;
            case 103:
                msj = "No se admiten valores alfabeticos. Generado por: '" + dato + "'";
                break;
            case 104:
                msj = "";
                break;
            case 105:
                msj = "";
                break;
            default:
                throw new AssertionError();
        }
    }

    public int getNro() {
        return Nro;
    }

    public void setNro(int Nro) {
        this.Nro = Nro;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    @Override
    public String toString() {
        return "ExcepcionFormatoEntrada: " + Nro + ": " + msj;
    }

    @Override
    public String getMessage() {
        return "Error " + Nro + ": " + msj;
    }

}
