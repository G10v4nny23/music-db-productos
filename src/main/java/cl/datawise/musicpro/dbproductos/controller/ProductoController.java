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

import cl.datawise.musicpro.dbproductos.dto.ProductoDto;
import cl.datawise.musicpro.dbproductos.dto.RespuestaGenericaDto;
import cl.datawise.musicpro.dbproductos.exceptions.CategoriaException;
import cl.datawise.musicpro.dbproductos.exceptions.ProductoException;
import cl.datawise.musicpro.dbproductos.mappers.ProductoMapper;
import cl.datawise.musicpro.dbproductos.models.ProductoModel;
import cl.datawise.musicpro.dbproductos.services.ProductoService;



@RestController
@RequestMapping("${api.base_url}/Producto")
public class ProductoController {
    private ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }


    @GetMapping("getById/{id}")
    public ResponseEntity<RespuestaGenericaDto> getProductoById(@PathVariable int id) throws ProductoException {
        return new ResponseEntity<>(productoService.getProductoById(id), HttpStatus.OK);
    }


    @GetMapping("getByNombre/{nombre}")
    public ResponseEntity<RespuestaGenericaDto> getProductoByNombre(@PathVariable String nombre) throws ProductoException {
        return new ResponseEntity<>(productoService.getProductoByNombre(nombre), HttpStatus.OK);
    }


    @GetMapping("getByPrecio/{precio}")
    public ResponseEntity<RespuestaGenericaDto> getProductoByPrecio(@PathVariable int precio) throws ProductoException {
        return new ResponseEntity<>(productoService.getProductoByPrecio(precio), HttpStatus.OK);
    }


    @GetMapping("getByIdCategoria/{idCategoria}")
    public ResponseEntity<RespuestaGenericaDto> getProductoByCategoria(@PathVariable int idCategoria) throws ProductoException, CategoriaException {
        return new ResponseEntity<>(productoService.getProductoByCategoria(idCategoria), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<ProductoDto> createProducto(@RequestBody ProductoDto productoDto) throws ProductoException {
        ProductoDto productoCreado = productoService.createProducto(productoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
    }

    @PutMapping("update")
    public ResponseEntity<RespuestaGenericaDto> updateProducto(@RequestBody ProductoDto productoDto) throws ProductoException{
        ProductoModel producto = ProductoMapper.createModel(productoDto);
        return new ResponseEntity<>(productoService.updateProducto(producto), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<RespuestaGenericaDto> deleteProducto(@PathVariable int id) throws ProductoException{
        return new ResponseEntity<>(productoService.deleteProducto(id), HttpStatus.OK);
    }
}
