package org.example;
import lombok.*;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@Builder
@Audited
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Denominacion")
    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    private Set<Articulo> articulos = new HashSet<>();

    public Categoria() {
    }

    public Categoria(String denominacion) {
        this.denominacion = denominacion;
    }

}