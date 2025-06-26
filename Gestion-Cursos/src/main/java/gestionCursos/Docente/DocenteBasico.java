package gestionCursos.Docente;

import gestionCursos.Curso.Curso;
import gestionCursos.Estudiantes.Estudiante;

public class DocenteBasico implements Docente {

    boolean esGuardavida;
    @Override
    public boolean estaHabilitadoParaDictarClasesA(Estudiante estudiante, Curso curso) {
        return true;
    }

    @Override
    public boolean esProfesionalGuardavida() {
        return esGuardavida;
    }
}
