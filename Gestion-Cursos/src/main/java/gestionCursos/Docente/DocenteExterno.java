package gestionCursos.Docente;

import gestionCursos.Curso.Curso;
import gestionCursos.Estudiantes.Estudiante;

import java.math.BigDecimal;

public class DocenteExterno extends DocenteBasico {

    int limiteMenores;
    @Override
    public boolean estaHabilitadoParaDictarClasesA(Estudiante estudiante, Curso curso) {
        return this.hayVacanteMenores(estudiante,curso) || (!estudiante.esMenor());
    }

    public boolean hayVacanteMenores(Estudiante estudiante, Curso curso){
        return estudiante.esMenor() && this.tengoEspacioEn(curso);
    }

    public boolean tengoEspacioEn(Curso curso){return curso.cantMenores()< limiteMenores;}

    @Override
    public BigDecimal loQueCobraPor(Curso curso) {
        return super.loQueCobraPor(curso).add(this.extraPorInscriptos(curso))
    }

    public BigDecimal extraPorInscriptos(Curso curso){
       return BigDecimal.valueOf(3L *curso.cantInscriptos());

    }


}
