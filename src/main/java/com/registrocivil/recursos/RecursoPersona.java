package com.registrocivil.recursos;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import com.registrocivil.modelo.dao.PersonaDAO;
import com.registrocivil.modelo.entities.Persona;
import com.registrocivil.modelo.servicios.PersonaService;

@Path("/personas")
public class RecursoPersona {

    private PersonaService personaService = new PersonaService();
    private PersonaDAO personaDAO = new PersonaDAO();

    @GET
    @Path("/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona buscar(@PathParam("cedula") String cedula) {
        return personaService.buscarPorCedula(cedula);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Persona p) {
        personaService.agregarCiudadano(p);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Persona p) {
        personaService.actualizarRegistro(p);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id) {
        personaService.darDeBaja(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> todos() {
        return personaDAO.getAll();
    }
}