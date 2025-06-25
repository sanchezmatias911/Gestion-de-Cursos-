package gestionCursos.Curso;

import gestionCursos.Estudiantes.Estudiante;

public interface Curso {
    boolean sePuedeInscribir(Estudiante estudiante);
    void inscribir(Estudiante estudiante);
    boolean hayVacante();
    boolean seCumplenRequisitosAdicionales(Estudiante estudiante);
    int cantMenores();
}
