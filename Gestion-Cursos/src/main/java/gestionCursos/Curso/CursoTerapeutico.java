package gestionCursos.Curso;

import gestionCursos.Estudiantes.Estudiante;

import java.math.BigDecimal;

public class CursoTerapeutico extends CursoBase{

    BigDecimal recaudacionBruta;

    @Override
    public boolean seCumplenRequisitosAdicionales(Estudiante estudiante){
        return estudiante.dominaAlgunEstiloRelajante();
    }
    @Override
    BigDecimal recaudacionBruta(){
        return recaudacionBruta;
    }
}
