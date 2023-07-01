package cl.datawise.musicpro.dbproductos.mappers;


import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;

import cl.datawise.musicpro.dbproductos.dto.ProductoDto;
import cl.datawise.musicpro.dbproductos.dto.StockDto;
import cl.datawise.musicpro.dbproductos.models.ProductoModel;
import cl.datawise.musicpro.dbproductos.models.StockModel;


@Component
public class ProductoMapper {

    public static ProductoDto createDto(ProductoModel producto){
        List<StockDto> stockDto = new ArrayList<>();
        List<StockModel> stock = producto.getStock();
        stock.forEach((value) -> stockDto.add(StockMapper.createDto(value)));
        return ProductoDto.builder()
               .id(producto.getId())
               .nombre(producto.getNombre())
               .uri_imagen(producto.getUri_imagen())
               .descripcion(producto.getDescripcion())
               .precio(producto.getPrecio())
               .categoria(CategoriaMapper.createDto(producto.getCategoria()))
               .stock(stockDto)
               .build();
    }   
    
    public static ProductoModel createModel(ProductoDto productoDto){
        List<StockModel> stock = new ArrayList<>();
        List<StockDto> stockDto = productoDto.getStock();
        stock.forEach((value) -> stockDto.add(StockMapper.createDto(value)));
        return ProductoModel.builder()
                .id(productoDto.getId())
                .nombre(productoDto.getNombre())
                .uri_imagen(productoDto.getUri_imagen())
                .descripcion(productoDto.getDescripcion())
                .precio(productoDto.getPrecio())
                .categoria(CategoriaMapper.createModel(productoDto.getCategoria()))
                .stock(stock)
                .build();
    }
}




