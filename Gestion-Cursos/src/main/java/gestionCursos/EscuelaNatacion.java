package gestionCursos;

import gestionCursos.Curso.Curso;
import gestionCursos.Docente.Docente;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EscuelaNatacion implements Escuela{

    Set<Curso> cursos;
    BigDecimal ingresoMensual = BigDecimal.valueOf(0);

    public EscuelaNatacion(Set<Curso> cursos) {
        this.cursos = cursos;
    }


    @Override
    public BigDecimal getIngresoMensual() {
        return ingresoMensual;
    }
    @Override
    public void recaudarIngresoMensual(){

    }



    @Override
    public Set<Curso> cursosConEstilo(Estilo estilo) {
        Stream<Curso> cursosConEstilo = cursos.stream().filter(curso -> curso.alguienDomina(estilo));
        return  cursosConEstilo.collect(Collectors.toSet());
    }

    @Override
    public Set<Curso> cursosInfantiles() {
        Stream<Curso> cursosInfantiles =  cursos.stream().filter(Curso::todosMisInscriptosSonMenores);
        return cursosInfantiles.collect(Collectors.toSet());
    }

    @Override
    public Set<Docente> docentesInfantiles() {
        Stream<Docente> docentesInfantiles= this.cursosInfantiles().stream().map(Curso::getDocenteAsignado);
        return docentesInfantiles.collect(Collectors.toSet());
    }

    public Set<Curso> getCursos() {
        return new HashSet<>(cursos);
    }

    public BigDecimal recaudacionMensual(){
        return cursos.stream().map(Curso::recaudacion).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
