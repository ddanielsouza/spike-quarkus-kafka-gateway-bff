package souza.oliveira.daniel.client;

import io.quarkus.oidc.token.propagation.reactive.AccessTokenRequestReactiveFilter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import souza.oliveira.daniel.dto.OpportunityDTO;

import java.util.List;

@Path("/api/opportunities")
@RegisterRestClient
@RegisterProvider(AccessTokenRequestReactiveFilter.class)
@ApplicationScoped
@RegisterClientHeaders
public interface ReportRestClient {
    @GET
    @Path("/report")
    List<OpportunityDTO> requestOpportunitiesData();
}
