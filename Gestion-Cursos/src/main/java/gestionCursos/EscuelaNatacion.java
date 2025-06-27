package gestionCursos;

import gestionCursos.Curso.Curso;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class EscuelaNatacion implements Escuela{

    Set<Curso> cursos = new HashSet<>();
    BigDecimal ingresoMensual;
    @Override
    public BigDecimal getIngresoMensual() {
        return ingresoMensual;
    }
    @Override
    public void recaudarIngresoMensual(){

    }

    @Override
    public Set<Curso> cursosConEstilo() {
        return null;
    }

    @Override
    public Set<Curso> cursosInfantiles() {
        return null;
    }

    @Override
    public Set<Curso> docentesInfantiles() {
        return null;
    }

    public Set<Curso> getCursos() {
        return new HashSet<>(cursos);
    }

    public BigDecimal recaudacionMensual(){
        return cursos.stream().map(Curso::recaudacion).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
