package webservices;

import entities.Module;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/modules")
public class HelloWorldService {

    private ModuleBusiness moduleBusiness = new ModuleBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Module> getAllModules() {
        return moduleBusiness.getAllModules();
    }

    @GET
    @Path("/{matricule}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModuleByMatricule(@PathParam("matricule") String matricule) {
        Module module = moduleBusiness.getModuleByMatricule(matricule);
        if (module != null)
            return Response.ok(module).build();
        return Response.status(Response.Status.NOT_FOUND).entity("Not found").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addModule(Module module) {
        boolean ok = moduleBusiness.addModule(module);
        if (ok)
            return Response.status(Response.Status.CREATED).entity(module).build();
        return Response.status(Response.Status.BAD_REQUEST).entity("Invalid").build();
    }

    @PUT
    @Path("/{matricule}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateModule(@PathParam("matricule") String matricule, Module updatedModule) {
        boolean ok = moduleBusiness.updateModule(matricule, updatedModule);
        if (ok)
            return Response.ok(updatedModule).build();
        return Response.status(Response.Status.NOT_FOUND).entity("Not found").build();
    }

    @DELETE
    @Path("/{matricule}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteModule(@PathParam("matricule") String matricule) {
        boolean ok = moduleBusiness.deleteModule(matricule);
        if (ok)
            return Response.ok("Deleted").build();
        return Response.status(Response.Status.NOT_FOUND).entity("Not found").build();
    }
}
