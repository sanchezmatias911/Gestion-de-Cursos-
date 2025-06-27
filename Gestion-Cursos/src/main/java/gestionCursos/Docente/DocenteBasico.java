package gestionCursos.Docente;

import gestionCursos.Curso.Curso;
import gestionCursos.Estudiantes.Estudiante;

import java.math.BigDecimal;

public class DocenteBasico implements Docente {

    boolean esGuardavida;

    public DocenteBasico(boolean esGuardavida) {
        this.esGuardavida = esGuardavida;
    }

    @Override
    public boolean estaHabilitadoParaDictarClasesA(Estudiante estudiante, Curso curso) {
        return true;
    }

    @Override
    public boolean esProfesionalGuardavida() {
        return esGuardavida;
    }

    @Override
    public BigDecimal loQueCobraPor(Curso curso) {
        BigDecimal base = this.cobroBase();
        BigDecimal extraCurso = curso.recaudacionBruta().multiply(this.porcentaje());

        return base.add(extraCurso);
    }

    public BigDecimal cobroBase() { return BigDecimal.valueOf(20);}

    public BigDecimal porcentaje(){return BigDecimal.valueOf(0.1);}
}
