package io.github.filipeacht.clients.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{field.name.required}")
    private String name;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{field.cpf.required}")
    @CPF(message = "{field.cpf.invalid}")
    private String cpf;

    @Column(name = "register_date", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate registerDate;

    @PrePersist
    public void prePersist(){
        setRegisterDate(LocalDate.now());
    }
}