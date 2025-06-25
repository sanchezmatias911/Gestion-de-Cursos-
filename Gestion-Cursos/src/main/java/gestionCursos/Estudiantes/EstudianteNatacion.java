package gestionCursos.Estudiantes;


import gestionCursos.Curso.Curso;
import gestionCursos.Estilo;

import java.util.Set;

public class Estudiante {

    Set<Estilo> estiloQueDomina;

    int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Set<Estilo> getEstiloQueDomina() {
        return estiloQueDomina;
    }

    private boolean sePuedeInscribir(Curso curso){
        
    }



}
