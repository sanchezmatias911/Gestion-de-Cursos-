package gestionCursos.Docente;

import gestionCursos.Curso.Curso;
import gestionCursos.Estudiantes.Estudiante;

import java.math.BigDecimal;

public interface Docente {

    boolean estaHabilitadoParaDictarClasesA(Estudiante estudiante, Curso curso);
    boolean esProfesionalGuardavida();
    BigDecimal loQueCobraPor(Curso curso);
}
