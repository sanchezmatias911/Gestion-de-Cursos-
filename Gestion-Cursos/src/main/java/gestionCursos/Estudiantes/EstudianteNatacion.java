package gestionCursos.Estudiantes;


import gestionCursos.Curso.Curso;
import gestionCursos.Estilo;

import java.util.Set;

public class EstudianteNatacion implements Estudiante{

    Set<Estilo> estilosQueDomina;

    int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Set<Estilo> getEstilosQueDomina() {
        return estilosQueDomina;
    }


    @Override
    public boolean domina(Estilo estilo) {
        return estilosQueDomina.contains(estilo);
    }

    @Override
    public boolean esMenor() {
        return edad<13;
    }

    @Override
    public boolean sepuedeInscribir(Curso curso) {
        return curso.sePuedeInscribir(this);

    }

    @Override
    public void inscribir(Curso curso) {

    }
}
