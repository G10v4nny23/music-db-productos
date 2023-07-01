package cl.datawise.musicpro.dbproductos.mappers;

import org.springframework.stereotype.Component;

import cl.datawise.musicpro.dbproductos.dto.CategoriaDto;
import cl.datawise.musicpro.dbproductos.models.CategoriaModel;


@Component
public class CategoriaMapper {
    public static CategoriaDto createDto(CategoriaModel categoria){
        return CategoriaDto.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .build();
    }
    
    public static CategoriaModel createModel(CategoriaDto categoriaDto){
        return CategoriaModel.builder()
                .id(categoriaDto.getId())
                .nombre(categoriaDto.getNombre())
                .build();
    }
}