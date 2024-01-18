package io.github.filipeacht.clients.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ServiceProvidedDTO {

    @NotEmpty(message = "{field.description.required}")
    private String description;

    @NotEmpty(message = "{field.price.required}")
    private String price;

    @NotEmpty(message = "{field.date.required}")
    private String date;

    @NotNull(message = "{field.client.required}")
    private Integer idClient;

}
