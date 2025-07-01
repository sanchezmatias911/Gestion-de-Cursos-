package gestionCursos.Curso;

import gestionCursos.Docente.Docente;
import gestionCursos.Estudiantes.Estudiante;

import java.math.BigDecimal;

public class CursoTerapeutico extends CursoBase{

    BigDecimal recaudacionBruta;

    public CursoTerapeutico(Docente docenteAsignado, int cupoMaximo,BigDecimal recaudacionBruta) {
        super(docenteAsignado, cupoMaximo);
        this.recaudacionBruta = recaudacionBruta;
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
