package org.example;

import lombok.*;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@Builder
@Audited
public class Factura implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Fecha")
    private String fecha;
    @Column(name = "Numero")
    private int numero;
    @Column(name = "total")
    private int total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy ="factura",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();

    public Factura() {
    }

    public Factura(String fecha, int numero) {
        this.fecha = fecha;
        this.numero = numero;
    }

    public Factura(String fecha, int numero, Cliente cliente, List<DetalleFactura> detalle) {
        this.fecha = fecha;
        this.numero = numero;
        this.cliente = cliente;
        this.detalle = detalle;
    }


}
