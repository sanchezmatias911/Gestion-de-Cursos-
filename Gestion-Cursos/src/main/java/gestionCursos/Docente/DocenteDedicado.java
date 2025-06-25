package gestionCursos.Docente;

import gestionCursos.Curso.Curso;
import gestionCursos.Estilo;
import gestionCursos.Estudiantes.Estudiante;

public class DocenteDedicado implements Docente{

    Estilo estiloDocente;
    
    @Override
    public boolean estaHabilitadoParaDictarClasesA(Estudiante estudiante, Curso curso) {
        return estudiante.domina(estiloDocente);
    }
}
