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

import cl.datawise.musicpro.dbproductos.dto.CategoriaDto;
import cl.datawise.musicpro.dbproductos.dto.RespuestaGenericaDto;
import cl.datawise.musicpro.dbproductos.exceptions.CategoriaException;
import cl.datawise.musicpro.dbproductos.mappers.CategoriaMapper;
import cl.datawise.musicpro.dbproductos.models.CategoriaModel;
import cl.datawise.musicpro.dbproductos.services.CategoriaService;


@RestController
@RequestMapping("${api.base_url}/Categoria")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }


    @GetMapping("getById/{id}")
    public ResponseEntity<RespuestaGenericaDto> getCategoriaById(@PathVariable int id) throws CategoriaException {
        return new ResponseEntity<>(categoriaService.getCategoriaById(id), HttpStatus.OK);
    }


    @GetMapping("getByNombre/{nombre}")
    public ResponseEntity<RespuestaGenericaDto> getCategoriaByNombre(@PathVariable String nombre) throws CategoriaException {
        return new ResponseEntity<>(categoriaService.getCategoriaByNombre(nombre), HttpStatus.OK);
    }


    @PostMapping("create")
    public ResponseEntity<CategoriaDto> createCategoria(@RequestBody CategoriaDto categoriaDto) throws CategoriaException{
        CategoriaDto categoriaCreated = categoriaService.createCategoria(categoriaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaCreated);
    }


    @PutMapping("update")
    public ResponseEntity<RespuestaGenericaDto> updateCategoria(@RequestBody CategoriaDto categoriaDto)throws CategoriaException{
        CategoriaModel categoriaModel = CategoriaMapper.createModel(categoriaDto);
        return new ResponseEntity<RespuestaGenericaDto>(categoriaService.updateCategoria(categoriaModel), HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<RespuestaGenericaDto> deleteCategoria(@PathVariable int id) throws CategoriaException{
        return new ResponseEntity<RespuestaGenericaDto>(categoriaService.deleteCategoria(id), HttpStatus.OK);
    }
}
