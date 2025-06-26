package gestionCursos.Curso;

import gestionCursos.Estudiantes.Estudiante;

public class CursoEscuelaNinios extends CursoBase{

    @Override
    public boolean seCumplenRequisitosAdicionales(Estudiante estudiante){
        return super.seCumplenRequisitosAdicionales(estudiante) && estudiante.esMenor();
    }
}
