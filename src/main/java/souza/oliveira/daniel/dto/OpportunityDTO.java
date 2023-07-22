package souza.oliveira.daniel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@Jacksonized
public class OpportunityDTO {
    public Long proposalId;
    public String customer;
    public BigDecimal priceTonne;
    public BigDecimal lastDollarQuotation;
}
