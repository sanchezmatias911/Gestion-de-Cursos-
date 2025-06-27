package gestionCursos.Curso;

import gestionCursos.Docente.Docente;
import gestionCursos.Estilo;
import gestionCursos.Estudiantes.Estudiante;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CursoBase implements Curso{
    Set<Estudiante> inscriptos = new HashSet<>();

    Docente docenteAsignado;

    public Docente getDocenteAsignado() {
        return docenteAsignado;
    }

   int cupoMaximo;

    public CursoBase(Docente docenteAsignado, int cupoMaximo) {
        this.docenteAsignado = docenteAsignado;
        this.cupoMaximo = cupoMaximo;
    }

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
         BigDecimal recaudacionBruta = this.recaudacionBruta();
         BigDecimal loQueCobraDocente = this.docenteAsignado.loQueCobraPor(this);
        return  recaudacionBruta.subtract(loQueCobraDocente);
    }

    public BigDecimal recaudacionBruta(){
        return this.baseCurso().add(this.sumDescuentosEstudiantes()); // recaudacion base + descuentos estudiantes
    }

    @Override
    public int cantInscriptos() {
        return inscriptos.size();
    }

    @Override
    public boolean alguienDomina(Estilo estilo) {
        return inscriptos.stream().anyMatch(estudiante -> estudiante.domina(estilo));
    }

    @Override
    public boolean todosMisInscriptosSonMenores() {
        return inscriptos.stream().anyMatch(Estudiante::esMenor);
    }
    // IMPLEMENTAR

    public BigDecimal sumDescuentosEstudiantes(){
        return this.descuentosEstiloEstudiantes().reduce(BigDecimal.ZERO,BigDecimal::add);
    }
    public Stream<BigDecimal> descuentosEstiloEstudiantes(){return  this.alumnosInscriptos().stream().map(Estudiante::descuentosEstilos);}

    public BigDecimal baseCurso() {return BigDecimal.valueOf(20);}

}

