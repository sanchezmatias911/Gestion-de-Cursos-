package gestionCursos.Curso;

import gestionCursos.Estudiantes.Estudiante;

import java.math.BigDecimal;
import java.util.Set;

public interface Curso {
    boolean sePuedeInscribir(Estudiante estudiante);
    void inscribir(Estudiante estudiante) throws Exception;
    boolean hayVacante();
    boolean seCumplenRequisitosAdicionales(Estudiante estudiante);
    int cantMenores();
    Set<Estudiante> alumnosInscriptos();
    BigDecimal recaudacion();

    BigDecimal recaudacionBruta();
    int cantInscriptos();
}
