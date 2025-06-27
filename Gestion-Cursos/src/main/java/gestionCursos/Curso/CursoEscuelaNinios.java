package gestionCursos.Curso;

import gestionCursos.Estudiantes.Estudiante;

import java.math.BigDecimal;

public class CursoEscuelaNinios extends CursoBase{

    @Override
    public boolean seCumplenRequisitosAdicionales(Estudiante estudiante){
        return super.seCumplenRequisitosAdicionales(estudiante) && estudiante.esMenor();
    }
    @Override
    BigDecimal recaudacionBruta(){
        return super.recaudacionBruta().add(this.incentivoMunicipal());
    }

    BigDecimal incentivoMunicipal(){
        return BigDecimal.valueOf(500);
    }

}
