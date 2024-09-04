package org.example;
import lombok.*;
import org.hibernate.envers.Audited;
import java.io.Serializable;
import javax.persistence.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@Builder
@Audited
public class Domicilio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NombreCalle")
    private String nombreCalle;
    @Column(name = "Numero")
    private int numero;


    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;

    public Domicilio() {
    }

    public Domicilio(String nombreCalle, int numero) {

        this.nombreCalle = nombreCalle;
        this.numero = numero;
    }

    public Domicilio(String nombreCalle, int numero, Cliente cliente) {
        this.nombreCalle = nombreCalle;
        this.numero = numero;
        this.cliente = cliente;
    }


}
