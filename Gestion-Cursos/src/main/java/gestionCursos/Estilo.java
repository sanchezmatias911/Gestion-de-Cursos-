package gestionCursos;

public class Estilo {
    boolean esRelajante;
    double descuento;

    public Estilo(boolean esRelajante, double descuento) {
        this.esRelajante = esRelajante;
        this.descuento = descuento;
    }

    public boolean esRelajante() {return esRelajante;}
    public double getDescuento(){return descuento;}

}
