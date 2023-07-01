package cl.datawise.musicpro.dbproductos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {
    private Integer id;
    private String nombre;
}
