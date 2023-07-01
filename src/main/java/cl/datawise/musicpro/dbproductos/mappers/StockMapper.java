package cl.datawise.musicpro.dbproductos.mappers;

import org.springframework.stereotype.Component;
import cl.datawise.musicpro.dbproductos.dto.StockDto;
import cl.datawise.musicpro.dbproductos.models.StockModel;


@Component
public class StockMapper {
    public static StockDto createDto(StockModel stock){
        return StockDto.builder()
                .id(stock.getId())
                .producto(ProductoMapper.createDto(stock.getProducto()))
                .sucursal(SucursalMapper.createDto(stock.getSucursal()))
                .cantidad(stock.getCantidad())
                .build();     
    }

    public static StockModel createModel(StockDto stockDto){
        return StockModel.builder()
                .id(stockDto.getId())
                .producto(ProductoMapper.createModel(stockDto.getProducto()))
                .sucursal(SucursalMapper.createModel(stockDto.getSucursal()))
                .cantidad(stockDto.getCantidad())
                .build();     
    }

}
