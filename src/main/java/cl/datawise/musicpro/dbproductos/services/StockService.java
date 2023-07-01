package cl.datawise.musicpro.dbproductos.services;

import org.springframework.stereotype.Service;

import cl.datawise.musicpro.dbproductos.dto.RespuestaGenericaDto;
import cl.datawise.musicpro.dbproductos.dto.StockDto;
import cl.datawise.musicpro.dbproductos.exceptions.ProductoException;
import cl.datawise.musicpro.dbproductos.exceptions.StockException;
import cl.datawise.musicpro.dbproductos.exceptions.SucursalException;
import cl.datawise.musicpro.dbproductos.mappers.StockMapper;
import cl.datawise.musicpro.dbproductos.models.ProductoModel;
import cl.datawise.musicpro.dbproductos.models.StockModel;
import cl.datawise.musicpro.dbproductos.models.SucursalModel;
import cl.datawise.musicpro.dbproductos.repositories.ProductoRepository;
import cl.datawise.musicpro.dbproductos.repositories.StockRepository;
import cl.datawise.musicpro.dbproductos.repositories.SucursalRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor()
public class StockService {
    private final ProductoRepository productoRepository;
    private final StockRepository stockRepository;
    private final SucursalRepository sucursalRepository;


    public RespuestaGenericaDto getStockById(int id) throws StockException{
        StockModel stock = stockRepository.findById(id).orElseThrow(() -> new StockException("Not Found"));
        StockDto stockDto = StockMapper.createDto(stock);
        return RespuestaGenericaDto.builder()
                .data(stockDto)
                .build();
        }


    public RespuestaGenericaDto getStockByProducto(int id) throws StockException, ProductoException{
        ProductoModel producto = productoRepository.findById(id).orElseThrow(() -> new ProductoException("Not found"));
        StockModel stock = stockRepository.findByProducto(producto).orElseThrow(() -> new StockException("Not Found"));
        StockDto stockDto = StockMapper.createDto(stock);
        return RespuestaGenericaDto.builder()
                .data(stockDto)
                .build();
        }


    public RespuestaGenericaDto getStockBySucursal(int id) throws StockException, SucursalException{
        SucursalModel sucursal = sucursalRepository.findById(id).orElseThrow(() -> new SucursalException("Not found"));
        StockModel stock = stockRepository.findBySucursal(sucursal).orElseThrow(() -> new StockException("Not Found"));
        StockDto stockDto = StockMapper.createDto(stock);
        return RespuestaGenericaDto.builder()
                .data(stockDto)
                .build();
        }


    public RespuestaGenericaDto getStockByCantidad(int cantidad) throws StockException{
        StockModel stock = stockRepository.findByCantidad(cantidad).orElseThrow(() -> new StockException("Not Found"));
        StockDto stockDto = StockMapper.createDto(stock);   
        return RespuestaGenericaDto.builder()
                .data(stockDto)
                .build();
        }

        
    public StockDto createStock(StockDto stockDto) throws StockException{
        StockModel stockModel = StockMapper.createModel(stockDto);
        StockModel stockCreated = stockRepository.save(stockModel);
        return StockMapper.createDto(stockCreated);
        }


    public RespuestaGenericaDto updateStock(StockModel stockModel) throws StockException{
        StockModel stockFound = stockRepository.findById(stockModel.getId()).orElseThrow(() -> new StockException("Not Found"));
        stockFound.setCantidad(stockModel.getCantidad());
        stockFound.setProducto(stockModel.getProducto());
        stockFound.setSucursal(stockModel.getSucursal());

        StockModel stock = stockRepository.save(stockFound);
        StockDto stockDto = StockMapper.createDto(stock);
        return RespuestaGenericaDto.builder()
            .data(stockDto)
            .build();
        }


    public RespuestaGenericaDto deleteStock(int id) throws StockException{
        StockModel stockModel = stockRepository.findById(id).orElseThrow(() -> new StockException("Not Found"));
        StockDto stockDto = StockMapper.createDto(stockModel);
        stockRepository.delete(stockModel);

        return RespuestaGenericaDto.builder()
            .data(stockDto)
            .build();
        }
}




