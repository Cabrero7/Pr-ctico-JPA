package org.example;

import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "articulo")
@AllArgsConstructor
@Builder
@Audited
public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Cantidad")
    private int cantidad;
    @Column(name = "Denominacion")
    private String denominacion;
    @Column(name = "Precio")
    private int precio;

    @OneToMany(mappedBy = "articulo",cascade = CascadeType.PERSIST)
    @Builder.Default
    @NotAudited
    private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )

    private Set<Categoria> categorias= new HashSet<>();

    public Articulo() {
    }

    public Articulo(int cantidad, String deniminacion, int precio) {
        this.cantidad = cantidad;
        this.denominacion = deniminacion;
        this.precio = precio;
    }

    public Articulo(int cantidad, String denominacion, int precio, List<DetalleFactura> detalle, Set<Categoria> categorias) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
        this.detalle = detalle;
        this.categorias = categorias;
    }

    public String getDeniminacion() {
        return denominacion;
    }

    public void setDeniminacion(String deniminacion) {
        this.denominacion = deniminacion;
    }

}