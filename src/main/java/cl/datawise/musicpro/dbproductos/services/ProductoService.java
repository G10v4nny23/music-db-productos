package cl.datawise.musicpro.dbproductos.services;


import org.springframework.stereotype.Service;

import cl.datawise.musicpro.dbproductos.dto.ProductoDto;
import cl.datawise.musicpro.dbproductos.dto.RespuestaGenericaDto;
import cl.datawise.musicpro.dbproductos.exceptions.CategoriaException;
import cl.datawise.musicpro.dbproductos.exceptions.ProductoException;
import cl.datawise.musicpro.dbproductos.mappers.ProductoMapper;
import cl.datawise.musicpro.dbproductos.models.CategoriaModel;
import cl.datawise.musicpro.dbproductos.models.ProductoModel;
import cl.datawise.musicpro.dbproductos.repositories.CategoriaRepository;
import cl.datawise.musicpro.dbproductos.repositories.ProductoRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor()
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;


    public RespuestaGenericaDto getProductoById(int id) throws ProductoException{
        ProductoModel producto = productoRepository.findById(id).orElseThrow(() -> new ProductoException("Not Found"));
        ProductoDto productoDto = ProductoMapper.createDto(producto);
        return RespuestaGenericaDto.builder()
                .data(productoDto)
                .build();
        }
    

    public RespuestaGenericaDto getProductoByNombre(String nombre) throws ProductoException{
        ProductoModel producto = productoRepository.findByNombre(nombre).orElseThrow(() -> new ProductoException("Not Found"));
        ProductoDto productoDto = ProductoMapper.createDto(producto);
        
        return RespuestaGenericaDto.builder()
                .data(productoDto)
                .build();
        }


    public RespuestaGenericaDto getProductoByPrecio(int precio) throws ProductoException{
        ProductoModel producto = productoRepository.findByPrecio(precio).orElseThrow(() -> new ProductoException("Not Found"));
        ProductoDto productoDto = ProductoMapper.createDto(producto);

        return RespuestaGenericaDto.builder()
                .data(productoDto)
                .build();
        }


    public RespuestaGenericaDto getProductoByCategoria(int id) throws ProductoException, CategoriaException{
        CategoriaModel categoria = categoriaRepository.findById(id).orElseThrow(()-> new CategoriaException("Not Found"));
        ProductoModel producto = productoRepository.findByCategoria(categoria).orElseThrow(() -> new ProductoException("Not Found"));
        ProductoDto productoDto = ProductoMapper.createDto(producto);

        return RespuestaGenericaDto.builder()
                .data(productoDto)
                .build();
    }

    public ProductoDto createProducto(ProductoDto productoDto) throws ProductoException {
        ProductoModel productoModel = ProductoMapper.createModel(productoDto);
        ProductoModel productoCreated = productoRepository.save(productoModel);

        return ProductoMapper.createDto(productoCreated);
    }
    
    public RespuestaGenericaDto updateProducto(ProductoModel producto) throws ProductoException{
        ProductoModel productFound = productoRepository.findById(producto.getId()).orElseThrow(() -> new ProductoException("Not Found"));
        productFound.setNombre(producto.getNombre());
        productFound.setUri_imagen(producto.getUri_imagen());
        productFound.setDescripcion(producto.getDescripcion());
        productFound.setPrecio(producto.getPrecio());
        productFound.setCategoria(producto.getCategoria());
        productFound.setStock(producto.getStock());
        ProductoModel productoModel = productoRepository.save(productFound);
        ProductoDto productoDto = ProductoMapper.createDto(productoModel);

        return RespuestaGenericaDto.builder()
                .data(productoDto)
                .build();
    }

    public RespuestaGenericaDto deleteProducto(Integer id) throws ProductoException {
        ProductoModel producto = productoRepository.findById(id).orElseThrow(() -> new ProductoException("Not Found"));
        ProductoDto productoDto = ProductoMapper.createDto(producto);
        productoRepository.delete(producto);

        return RespuestaGenericaDto.builder()
                .data(productoDto)
                .build();
    }
}


