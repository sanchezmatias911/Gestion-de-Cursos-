package gestionCursos.Curso;

import gestionCursos.Docente.Docente;
import gestionCursos.Estudiantes.Estudiante;

import java.math.BigDecimal;

public class CursoTerapeutico extends CursoBase{

    BigDecimal recaudacionBruta;

    public CursoTerapeutico(Docente docenteAsignado, int cupoMaximo) {
        super(docenteAsignado, cupoMaximo);
    }

    @Override
    public boolean seCumplenRequisitosAdicionales(Estudiante estudiante){
        return estudiante.dominaAlgunEstiloRelajante();
    }
    @Override
    public BigDecimal recaudacionBruta(){
        return recaudacionBruta;
    }
}
