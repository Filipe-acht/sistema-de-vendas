package io.github.filipeacht.clients.rest;

import io.github.filipeacht.clients.model.entity.Client;
import io.github.filipeacht.clients.model.entity.ServiceProvided;
import io.github.filipeacht.clients.model.repository.ClientRepository;
import io.github.filipeacht.clients.model.repository.ServiceProvidedRepository;
import io.github.filipeacht.clients.rest.dto.ServiceProvidedDTO;
import io.github.filipeacht.clients.utils.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services-provied")
@RequiredArgsConstructor
public class ServiceProvidedController {

    private final ClientRepository clientRepository;
    private final ServiceProvidedRepository serviceProvidedRepository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceProvided save(@RequestBody ServiceProvidedDTO dto) {

        LocalDate date = LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idClient = dto.getIdClient();

        Client client =
                clientRepository
                        .findById(idClient)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Non-existent client!"));


        ServiceProvided serviceProvided = new ServiceProvided();
        serviceProvided.setDescription((dto.getDescription()));
        serviceProvided.setDate(date);
        serviceProvided.setClient(client);
        serviceProvided.setValue(bigDecimalConverter.converter((dto.getPrice())));

        return serviceProvidedRepository.save(serviceProvided);
    }

    @GetMapping
    public List<ServiceProvided> search(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(value = "month", required = false) Integer month
    ) {
        return serviceProvidedRepository.findByClientNameAndMonth("%" + name + "%", month);
    }
}
