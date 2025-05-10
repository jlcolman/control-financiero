package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "tipo_documentos")
@Data
public class TipoDocumentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento")
<<<<<<< HEAD
    private Long idTipoDocumento;
=======
    private Integer idTipoDocumento;
>>>>>>> 08d85ce42845bdc2a6c2a907bb3bc389924d6f78

    @NotNull
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
}
