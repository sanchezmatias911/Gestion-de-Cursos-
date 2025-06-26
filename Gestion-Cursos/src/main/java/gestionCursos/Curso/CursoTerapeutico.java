package gestionCursos.Curso;

import gestionCursos.Estudiantes.Estudiante;

public class CursoTerapeutico extends CursoBase{

    @Override
    public boolean seCumplenRequisitosAdicionales(Estudiante estudiante){
        return estudiante.dominaAlgunEstiloRelajante();
    }
}
