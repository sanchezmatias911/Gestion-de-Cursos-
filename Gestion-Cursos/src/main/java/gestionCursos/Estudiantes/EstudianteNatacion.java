package gestionCursos.Estudiantes;


import gestionCursos.Curso.Curso;
import gestionCursos.Estilo;

import java.util.HashSet;
import java.util.Set;

public class EstudianteNatacion implements Estudiante{

    Set<Estilo> estilosQueDomina;

    int edad;

    public int getEdad() {
        return edad;
    }



    public Set<Estilo> getEstilosQueDomina() {
        return new HashSet<>(estilosQueDomina);
    }


    @Override
    public boolean domina(Estilo estilo) {
        return this.getEstilosQueDomina().contains(estilo);
    }

    @Override
    public boolean esMenor() {
        return this.getEdad()<13;
    }

    @Override
    public boolean sepuedeInscribir(Curso curso) {
        return curso.sePuedeInscribir(this);

    }

    @Override
    public void inscribir(Curso curso) {

    }

    @Override
    public boolean dominaAlgunEstilo() {
        return !estilosQueDomina.isEmpty();
    }

    @Override
    public boolean dominaAlgunEstiloRelajante() {
        return estilosQueDomina.stream().anyMatch(Estilo::esRelajante);
    }
}
