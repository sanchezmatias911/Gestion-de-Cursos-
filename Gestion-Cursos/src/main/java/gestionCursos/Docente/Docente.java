package gestionCursos.Docente;

import gestionCursos.Curso.Curso;
import gestionCursos.Estudiantes.Estudiante;

public interface Docente {

    boolean estaHabilitadoParaDictarClasesA(Estudiante estudiante, Curso curso);
    boolean esProfesionalGuardavida();
    double loQueCobraPor(Curso curso);
}
