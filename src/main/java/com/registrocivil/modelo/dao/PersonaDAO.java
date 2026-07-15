package com.registrocivil.modelo.dao;

import com.registrocivil.modelo.entities.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    private static List<Persona> personas = new ArrayList<>();

    public void create(Persona p){
        personas.add(p);
    }

    public void update(Persona p) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getId().equals(p.getId())) {
                personas.set(i, p);
                return;
            }
        }
    }

    public void delete(int id) {
        personas.removeIf(p -> p.getId() != null && p.getId() == id);
    }

    public Persona getByCedula(String c) {
        for (Persona p : personas) {
            if (p.getCedula() != null && p.getCedula().equals(c)) {
                return p;
            }
        }
        return null;
    }

    public List<Persona> getAll() {
        if (personas.isEmpty()) {
            personas.add(new Persona(1, "Ruben Cuenca", "1726329699",22));
            personas.add(new Persona(2, "Sara Aparicio", "1728795865",23 ));
        }
        return personas;
    }
}
