package gestionCursos.Curso;

import gestionCursos.Docente.Docente;
import gestionCursos.Estudiantes.Estudiante;

import java.math.BigDecimal;

public class CursoEscuelaNinios extends CursoBase{

    public CursoEscuelaNinios(Docente docenteAsignado, int cupoMaximo) {
        super(docenteAsignado, cupoMaximo);
    }

    @Override
    public boolean seCumplenRequisitosAdicionales(Estudiante estudiante){
        return super.seCumplenRequisitosAdicionales(estudiante) && estudiante.esMenor();
    }
    @Override
    public BigDecimal recaudacionBruta(){
        return super.recaudacionBruta().add(this.incentivoMunicipal());
    }

    BigDecimal incentivoMunicipal(){
        return BigDecimal.valueOf(500);
    }

}
