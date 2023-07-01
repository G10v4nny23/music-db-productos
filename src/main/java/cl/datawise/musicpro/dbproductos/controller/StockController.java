package cl.datawise.musicpro.dbproductos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.datawise.musicpro.dbproductos.dto.RespuestaGenericaDto;
import cl.datawise.musicpro.dbproductos.dto.StockDto;
import cl.datawise.musicpro.dbproductos.exceptions.ProductoException;
import cl.datawise.musicpro.dbproductos.exceptions.StockException;
import cl.datawise.musicpro.dbproductos.exceptions.SucursalException;
import cl.datawise.musicpro.dbproductos.mappers.StockMapper;
import cl.datawise.musicpro.dbproductos.models.StockModel;
import cl.datawise.musicpro.dbproductos.services.StockService;


@RestController
@RequestMapping("${api.base_url}/Stock")
public class StockController {
    private StockService stockService;

    public StockController(StockService stockService){
        this.stockService = stockService;
    }


    @GetMapping("getById/{id}")
    public ResponseEntity<RespuestaGenericaDto> getStockById(@PathVariable int id) throws StockException, ProductoException {
        return new ResponseEntity<>(stockService.getStockById(id), HttpStatus.OK);
    }


    @GetMapping("getByProducto/{id}")
    public ResponseEntity<RespuestaGenericaDto> getStockByProducto(@PathVariable int id) throws StockException, ProductoException {
        return new ResponseEntity<>(stockService.getStockByProducto(id), HttpStatus.OK);
    }


    @GetMapping("getBySucursal/{id}")
    public ResponseEntity<RespuestaGenericaDto> getStockBySucursal(@PathVariable int id) throws StockException, SucursalException {
        return new ResponseEntity<>(stockService.getStockBySucursal(id), HttpStatus.OK);
    }


    @GetMapping("getByCantidad/{cantidad}")
    public ResponseEntity<RespuestaGenericaDto> getStockByCantidad(@PathVariable int cantidad) throws StockException {
        return new ResponseEntity<>(stockService.getStockByCantidad(cantidad), HttpStatus.OK);
    }


    @PostMapping("create")
    public ResponseEntity<StockDto> createStock(@RequestBody StockDto stockDto) throws StockException{
        StockDto stockCreated = stockService.createStock(stockDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(stockCreated);
    }


    @PutMapping("update")
    public ResponseEntity<RespuestaGenericaDto> updateStock(@RequestBody StockDto stockDto) throws StockException{
        StockModel stockModel = StockMapper.createModel(stockDto);
        return new ResponseEntity <>(stockService.updateStock(stockModel), HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<RespuestaGenericaDto> deleteStock(@PathVariable int id) throws StockException{
        return new ResponseEntity<>(stockService.deleteStock(id), HttpStatus.OK);
    }
}
