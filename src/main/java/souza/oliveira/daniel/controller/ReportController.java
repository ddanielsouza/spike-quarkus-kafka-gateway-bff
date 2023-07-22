package souza.oliveira.daniel.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import souza.oliveira.daniel.service.ReportService;

import java.time.LocalDateTime;

@Path("/api/opportunities")
@ApplicationScoped
public class ReportController {
    private final ReportService reportService;

    @Inject
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GET
    @Path("/report/csv")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @RolesAllowed({"manager", "user"})
    public Response generateReportCsv(){
        final var csv = this.reportService.genenateCSVOpportunitiesReport();
        final var fileNameHeader = String
                .format("attachment; filename=%s--oportunidades-vendas.csv", LocalDateTime.now().toString());

        return Response.ok(csv, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", fileNameHeader)
                .build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"manager", "user"})
    public Response generateReport(){
        final var opportunities = this.reportService.getOpportunitiesData();
        return Response.ok(opportunities).build();
    }
}
