package gestionCursos;

import gestionCursos.Curso.Curso;
import gestionCursos.Docente.Docente;

import java.math.BigDecimal;
import java.util.Set;

public interface Escuela {

     BigDecimal getIngresoMensual();

     void recaudarIngresoMensual();

     Set<Curso> cursosConEstilo(Estilo estilo);

    Set<Curso> cursosInfantiles();

    Set<Docente> docentesInfantiles();



}


