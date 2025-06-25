package gestionCursos.Curso;

import gestionCursos.Docente.Docente;
import gestionCursos.Estudiantes.Estudiante;

import java.util.Set;

public class CursoNatacion  implements Curso{
    Set<Estudiante> inscriptos;
    Docente docenteAsignado;
   int cupoMaximo;

    @Override
    public boolean sePuedeInscribir(Estudiante estudiante) {
        return (!this.estaInscripto(estudiante)) &&
                this.hayVacante() &&
                docenteAsignado.estaHabilitadoParaDictarClasesA(estudiante,this) &&
                this.seCumplenRequisitosAdicionales();

    }

    public boolean seCumplenRequisitosAdicionales(){
        return; // IMPLEMENTAR
    }
  @Override
    public boolean hayVacante(){return cupoMaximo> this.cantidadInscriptos(); }

    public int cantidadInscriptos(){return inscriptos.size();}

    public boolean estaInscripto(Estudiante estudiante){
        return inscriptos.contains(estudiante);
    }



    @Override
    public void inscribir(Estudiante estudiante) {

    }
}
