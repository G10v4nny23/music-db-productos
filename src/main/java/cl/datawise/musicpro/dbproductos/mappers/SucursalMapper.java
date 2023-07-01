package cl.datawise.musicpro.dbproductos.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cl.datawise.musicpro.dbproductos.dto.StockDto;
import cl.datawise.musicpro.dbproductos.dto.SucursalDto;
import cl.datawise.musicpro.dbproductos.models.StockModel;
import cl.datawise.musicpro.dbproductos.models.SucursalModel;


@Component
public class SucursalMapper {
    public static SucursalDto createDto(SucursalModel sucursal){
        List<StockDto> stockDto = new ArrayList<>();
        List<StockModel> stock = sucursal.getStock();
        stock.forEach((value) -> stockDto.add(StockMapper.createDto(value)));
        return SucursalDto.builder()
                .nombre(sucursal.getNombre())
                .direccion(sucursal.getDireccion())
                .permisoMunicipal(sucursal.getPermisoMunicipal())
                .rut(sucursal.getRut())
                .idEncargado(sucursal.getIdEncargado())
                .stock(stockDto)
                .build();     
    }

    public static SucursalModel createModel(SucursalDto sucursalDto){
        List<StockModel> stock = new ArrayList<>();
        List<StockDto> stockDto = sucursalDto.getStock();
        stockDto.forEach((value) -> stock.add(StockMapper.createModel(value)));
        return SucursalModel.builder()
                .nombre(sucursalDto.getNombre())
                .direccion(sucursalDto.getDireccion())
                .permisoMunicipal(sucursalDto.getPermisoMunicipal())
                .rut(sucursalDto.getRut())
                .idEncargado(sucursalDto.getIdEncargado())
                .stock(stock)
                .build();     
    }

}
