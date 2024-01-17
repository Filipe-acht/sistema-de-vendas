package io.github.filipeacht.clients.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServiceProvidedDTO {

    private String description;
    private String price;
    private String date;
    private Integer idClient;

}
