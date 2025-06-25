package gestionCursos.Docente;

import gestionCursos.Curso.Curso;
import gestionCursos.Estudiantes.Estudiante;

public interface Docente {

    boolean estaHabilitadoParaDictarClasesA(Estudiante estudiante, Curso curso);
}
