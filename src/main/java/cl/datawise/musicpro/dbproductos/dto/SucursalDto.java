package cl.datawise.musicpro.dbproductos.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SucursalDto {
    private Integer id;
    private String nombre;
    private String direccion;
    private String permisoMunicipal;
    private String rut;
    private Integer idEncargado;
    private List<StockDto> stock;
}
