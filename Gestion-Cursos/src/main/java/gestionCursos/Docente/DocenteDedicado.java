package gestionCursos.Docente;

import gestionCursos.Curso.Curso;
import gestionCursos.Estilo;
import gestionCursos.Estudiantes.Estudiante;

import java.math.BigDecimal;

public class DocenteDedicado extends DocenteBasico{

    Estilo estiloDocente;
    
    @Override
    public boolean estaHabilitadoParaDictarClasesA(Estudiante estudiante, Curso curso) {
        return estudiante.domina(estiloDocente);
    }



}
