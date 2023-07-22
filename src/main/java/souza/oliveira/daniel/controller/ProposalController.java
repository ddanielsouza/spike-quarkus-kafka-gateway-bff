package souza.oliveira.daniel.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import souza.oliveira.daniel.dto.ProposalDetailsDTO;
import souza.oliveira.daniel.service.ProposalService;

@Path("/api/trade")
@ApplicationScoped
public class ProposalController {
    private final ProposalService proposalService;

    @Inject
    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"user", "manager"})
    public Response getProposalDetailsById(@PathParam("id") long id){
        final var proposals = this.proposalService.getProposalDetailsById(id);
        return Response.ok(proposals).build();
    }

    @POST
    @RolesAllowed({"proposal-customer"})
    public Response createNewProposal(ProposalDetailsDTO proposal){
        return this.proposalService.createProposal(proposal);
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"manager"})
    public Response responseProposal(@PathParam("id") long id){
        return this.proposalService.removeProposal(id);
    }
}
