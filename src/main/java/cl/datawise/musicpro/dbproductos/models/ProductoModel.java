package cl.datawise.musicpro.dbproductos.models;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoModel {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String uri_imagen;
    private String descripcion;
    private int precio;
    @OneToOne
    private CategoriaModel categoria;
    @OneToMany
    private List<StockModel> stock;
}
