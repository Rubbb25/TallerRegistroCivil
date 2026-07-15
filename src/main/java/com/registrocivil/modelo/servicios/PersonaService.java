package com.registrocivil.modelo.servicios;

import com.registrocivil.modelo.dao.PersonaDAO;
import com.registrocivil.modelo.entities.Persona;


public class PersonaService {

    private PersonaDAO personaDAO;

    public PersonaService() {
        this.personaDAO = new PersonaDAO();
    }

    public Persona buscarPorCedula(String cedula) {
        return personaDAO.getByCedula(cedula);
    }

    public void agregarCiudadano(Persona p) {
        personaDAO.create(p);
    }

    public void actualizarRegistro(Persona p) {
        personaDAO.update(p);
    }

    public void darDeBaja(int id) {
        personaDAO.delete(id);
    }

    public boolean aplicaCredito(String cedula) {
        Persona p = personaDAO.getByCedula(cedula);
        if (p == null) {
            return false;
        }
        return p.getEdad() >= 18;
    }
}
