package gestionCursos.Estudiantes;

import gestionCursos.Curso.Curso;
import gestionCursos.Estilo;

import java.math.BigDecimal;
import java.util.Set;

public interface Estudiante {

    boolean domina(Estilo estilo);

    boolean esMenor();
    boolean sepuedeInscribir(Curso curso);
    void inscribir(Curso curso);
    boolean dominaAlgunEstilo();
    boolean dominaAlgunEstiloRelajante();
    BigDecimal descuentosEstilos();


}
