package cl.datawise.musicpro.dbproductos.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private Integer id;
    private String nombre;
    private String uri_imagen;
    private String descripcion;
    private int precio;
    private List<StockDto> stock;
    private CategoriaDto categoria;
}
