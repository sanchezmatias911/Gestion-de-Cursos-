package gestionCursos.Curso;

import gestionCursos.Docente.Docente;
import gestionCursos.Estudiantes.Estudiante;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CursoBase implements Curso{
    Set<Estudiante> inscriptos = new HashSet<>();
    Docente docenteAsignado;
   int cupoMaximo;

    @Override
    public boolean sePuedeInscribir(Estudiante estudiante) {
        return (!this.estaInscripto(estudiante)) &&
                this.hayVacante() &&
                docenteAsignado.estaHabilitadoParaDictarClasesA(estudiante,this) &&
                this.seCumplenRequisitosAdicionales(estudiante);

    }

    public boolean seCumplenRequisitosAdicionales(Estudiante estudiante){

        return estudiante.dominaAlgunEstilo() || docenteAsignado.esProfesionalGuardavida(); // IMPLEMENTAR
    }

    @Override
    public int cantMenores() {
       return  this.menoresInscriptos().size();
    }

    @Override
    public Set<Estudiante> alumnosInscriptos() {
        return new HashSet<>(inscriptos);
    }



    public Set<Estudiante> menoresInscriptos() {
        return inscriptos.stream()
                .filter(Estudiante::esMenor)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean hayVacante(){return cupoMaximo> this.cantidadInscriptos(); }

    public int cantidadInscriptos(){return inscriptos.size();}

    public boolean estaInscripto(Estudiante estudiante){
        return inscriptos.contains(estudiante);
    }



    @Override
    public void inscribir(Estudiante estudiante) throws Exception {
        this.validarInscripcion(estudiante);
        inscriptos.add(estudiante);
    }

    private void validarInscripcion(Estudiante estudiante) throws Exception {
        if(!this.sePuedeInscribir(estudiante)){
            throw new InscripcionInvalidaException("El estudiante no puede inscribirse");
        }

    }

    @Override
    public BigDecimal recaudacion() {
        return this.recaudacionBruta() - this.docenteAsignado.loQueCobraPor(this); // SEGUIR AQUI
    }

    BigDecimal recaudacionBruta(){
        return this.baseCurso() + this.descuentosEstudiantes()
    }
    // IMPLEMENTAR

    public double descuentosEstudiantes(){
        return inscriptos.stream().mapToDouble(Estudiante::descuentosEstilos).sum();
    }

    public int baseCurso() {return 20;}

}

