/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cz.fit.bitjv.tadeasvalenta.semestralka.entities.service;

import eu.cz.fit.bitjv.tadeasvalenta.semestralka.entities.Plug;
import eu.cz.fit.bitjv.tadeasvalenta.semestralka.entities.PlugBox;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tadas
 */
@Stateless
@Path("eu.cz.fit.bitjv.tadeasvalenta.semestralka.entities.plug")
public class PlugFacadeREST extends AbstractFacade<Plug> {

    @PersistenceContext(unitName = "eu.cz.fit.bitjv.tadeasvalenta_semestralka_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public PlugFacadeREST() {
        super(Plug.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Plug entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Plug entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Plug find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
 
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PlugBox findAllPlug() {
        PlugBox pb = new PlugBox();
        pb.setPlugs(super.findAll());
        return pb;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PlugBox findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        PlugBox pb = new PlugBox();
        pb.setPlugs(super.findRange(new int[]{from, to}));
        return pb;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
