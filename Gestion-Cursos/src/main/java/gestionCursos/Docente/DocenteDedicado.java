package gestionCursos.Docente;

import gestionCursos.Curso.Curso;
import gestionCursos.Estilo;
import gestionCursos.Estudiantes.Estudiante;

import java.math.BigDecimal;

public class DocenteDedicado extends DocenteBasico{

    Estilo estiloDocente;

    public DocenteDedicado(boolean esGuardavida, Estilo estiloDocente) {
        super(esGuardavida);
        this.estiloDocente = estiloDocente;
    }

    @Override
    public boolean estaHabilitadoParaDictarClasesA(Estudiante estudiante, Curso curso) {
        return estudiante.domina(estiloDocente);
    }

    @Override
    public BigDecimal porcentaje(){return BigDecimal.valueOf(0.15);}



}
