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
import cl.datawise.musicpro.dbproductos.dto.SucursalDto;
import cl.datawise.musicpro.dbproductos.exceptions.SucursalException;
import cl.datawise.musicpro.dbproductos.mappers.SucursalMapper;
import cl.datawise.musicpro.dbproductos.models.SucursalModel;
import cl.datawise.musicpro.dbproductos.services.SucursalService;


@RestController
@RequestMapping("${api.base_url}/Sucursal")
public class SucursalController {
    private SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService){
        this.sucursalService = sucursalService;
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<RespuestaGenericaDto> getSucursalById(@PathVariable int id) throws SucursalException{
        return new ResponseEntity<>(sucursalService.getSucursalById(id), HttpStatus.OK);
    }

    @GetMapping("getByNombre/{nombre}")
    public ResponseEntity<RespuestaGenericaDto> getSucursalByNombre(@PathVariable String nombre) throws SucursalException{
        return new ResponseEntity<>(sucursalService.getSucursalByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("getByDireccion/{direccion}")
    public ResponseEntity<RespuestaGenericaDto> getSucursalByDireccion(@PathVariable String direccion) throws SucursalException{
        return new ResponseEntity<>(sucursalService.getSucursalByDireccion(direccion), HttpStatus.OK);
    }

    @GetMapping("getByPermisoMunicipal/{permisoMunicipal}")
    public ResponseEntity<RespuestaGenericaDto> getSucursalByPermisoMunicipal(@PathVariable String permisoMunicipal) throws SucursalException{
        return new ResponseEntity<>(sucursalService.getSucursalByPermisoMunicipal(permisoMunicipal), HttpStatus.OK);
    }

    @GetMapping("getByRut/{rut}")
    public ResponseEntity<RespuestaGenericaDto> getSucursalByRut(@PathVariable String rut) throws SucursalException{
        return new ResponseEntity<>(sucursalService.getSucursalByRut(rut), HttpStatus.OK);
    }

    @GetMapping("getByIdEncargado/{idEncargado}")
    public ResponseEntity<RespuestaGenericaDto> getSucursalByIdEncargado(@PathVariable Integer idEncargado) throws SucursalException{
        return new ResponseEntity<>(sucursalService.getSucursalByIdEncargado(idEncargado), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<SucursalDto> createSucursal(@RequestBody SucursalDto sucursalDto) throws SucursalException{
        SucursalDto sucursalCreated = sucursalService.createSucursal(sucursalDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalCreated);
    }

    @PutMapping("update")
    public ResponseEntity<RespuestaGenericaDto> updateSucursal(@RequestBody SucursalDto sucursalDto) throws SucursalException{
        SucursalModel sucursalModel = SucursalMapper.createModel(sucursalDto);
        return new ResponseEntity<>(sucursalService.updateSucursal(sucursalModel), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<RespuestaGenericaDto> deleteSucursal(@PathVariable int id) throws SucursalException{
        return new ResponseEntity<>(sucursalService.deleteSucursal(id), HttpStatus.OK);
    }
}
