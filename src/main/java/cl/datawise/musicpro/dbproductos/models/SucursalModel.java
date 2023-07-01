package cl.datawise.musicpro.dbproductos.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SucursalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String direccion;
    private String permisoMunicipal;
    private String rut;
    private Integer idEncargado;
    @OneToMany(mappedBy="sucursal")
    private List<StockModel> stock;
}
