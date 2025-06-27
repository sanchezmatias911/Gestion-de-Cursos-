package gestionCursos;

import gestionCursos.Curso.Curso;

import java.math.BigDecimal;
import java.util.Set;

public interface Escuela {

     BigDecimal getIngresoMensual();

     void recaudarIngresoMensual();

     Set<Curso> cursosConEstilo();

    Set<Curso> cursosInfantiles();

    Set<Curso> docentesInfantiles();



}


