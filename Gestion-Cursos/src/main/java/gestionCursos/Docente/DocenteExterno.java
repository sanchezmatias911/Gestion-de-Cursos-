package gestionCursos.Docente;

import gestionCursos.Curso.Curso;
import gestionCursos.Estudiantes.Estudiante;

public class DocenteExterno implements Docente {

    int limiteMenores;
    @Override
    public boolean estaHabilitadoParaDictarClasesA(Estudiante estudiante, Curso curso) {
        return this.hayVacanteMenores(estudiante,curso) || (!estudiante.esMenor());
    }

    public boolean hayVacanteMenores(Estudiante estudiante, Curso curso){
        return estudiante.esMenor() && this.tengoEspacio(curso);
    }

    public boolean tengoEspacio(Curso curso){return curso.cantMenores()< limiteMenores;}
}
