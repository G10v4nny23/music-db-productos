package cl.datawise.musicpro.dbproductos.services;

import org.springframework.stereotype.Service;

import cl.datawise.musicpro.dbproductos.dto.RespuestaGenericaDto;
import cl.datawise.musicpro.dbproductos.dto.SucursalDto;
import cl.datawise.musicpro.dbproductos.exceptions.SucursalException;
import cl.datawise.musicpro.dbproductos.mappers.SucursalMapper;
import cl.datawise.musicpro.dbproductos.models.SucursalModel;
import cl.datawise.musicpro.dbproductos.repositories.SucursalRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor()
public class SucursalService {
    private final SucursalRepository sucursalRepository;

    public RespuestaGenericaDto getSucursalById(int id) throws SucursalException{
        SucursalModel sucursal = sucursalRepository.findById(id).orElseThrow(() -> new SucursalException("Not Found"));
        SucursalDto sucursalDto = SucursalMapper.createDto(sucursal);
        return RespuestaGenericaDto.builder()
                .data(sucursalDto)
                .build();
        }


    public RespuestaGenericaDto getSucursalByNombre(String nombre) throws SucursalException{
        SucursalModel sucursal = sucursalRepository.findByNombre(nombre).orElseThrow(() -> new SucursalException("Not Found"));
        SucursalDto sucursalDto = SucursalMapper.createDto(sucursal);
        return RespuestaGenericaDto.builder()
                .data(sucursalDto)
                .build();
        }


    public RespuestaGenericaDto getSucursalByDireccion(String direccion) throws SucursalException{
        SucursalModel sucursal = sucursalRepository.findByDireccion(direccion).orElseThrow(() -> new SucursalException("Not Found"));
        SucursalDto sucursalDto = SucursalMapper.createDto(sucursal);
        return RespuestaGenericaDto.builder()
                .data(sucursalDto)
                .build();
        }


    public RespuestaGenericaDto getSucursalByPermisoMunicipal(String permisoMunicipal) throws SucursalException{
        SucursalModel sucursal = sucursalRepository.findByPermisoMunicipal(permisoMunicipal).orElseThrow(() -> new SucursalException("Not Found"));
        SucursalDto sucursalDto = SucursalMapper.createDto(sucursal);
        return RespuestaGenericaDto.builder()
                .data(sucursalDto)
                .build();
        }


    public RespuestaGenericaDto getSucursalByRut(String rut) throws SucursalException{
        SucursalModel sucursal = sucursalRepository.findByRut(rut).orElseThrow(() -> new SucursalException("Not Found"));
        SucursalDto sucursalDto = SucursalMapper.createDto(sucursal);
        return RespuestaGenericaDto.builder()
                .data(sucursalDto)
                .build();
        }


    public RespuestaGenericaDto getSucursalByIdEncargado(Integer idEncargado) throws SucursalException{
        SucursalModel sucursal = sucursalRepository.findByIdEncargado(idEncargado).orElseThrow(() -> new SucursalException("Not Found"));
        SucursalDto sucursalDto = SucursalMapper.createDto(sucursal);
        return RespuestaGenericaDto.builder()
                .data(sucursalDto)
                .build();
        }

        
    public SucursalDto createSucursal(SucursalDto sucursalDto) throws SucursalException{
        SucursalModel sucursalModel = SucursalMapper.createModel(sucursalDto);
        SucursalModel sucursalCreated = sucursalRepository.save(sucursalModel);
        return SucursalMapper.createDto(sucursalCreated);
    }


    public RespuestaGenericaDto updateSucursal(SucursalModel sucursalModel) throws SucursalException{
        SucursalModel sucursalFound = sucursalRepository.findById(sucursalModel.getId()).orElseThrow(() -> new SucursalException("Not Found"));
        sucursalFound.setDireccion(sucursalModel.getDireccion());
        sucursalFound.setIdEncargado(sucursalModel.getIdEncargado());
        sucursalFound.setNombre(sucursalModel.getNombre());
        sucursalFound.setPermisoMunicipal(sucursalModel.getPermisoMunicipal());
        sucursalFound.setRut(sucursalModel.getRut());
        sucursalFound.setStock(sucursalModel.getStock());

        SucursalModel sucursal = sucursalRepository.save(sucursalFound);
        SucursalDto sucursalDto = SucursalMapper.createDto(sucursal);

        return RespuestaGenericaDto.builder()
            .data(sucursalDto)
            .build();
        }


    public RespuestaGenericaDto deleteSucursal(int id) throws SucursalException{
        SucursalModel sucursalModel = sucursalRepository.findById(id).orElseThrow(() -> new SucursalException("Not Found"));
        SucursalDto sucursalDto =  SucursalMapper.createDto(sucursalModel);
        sucursalRepository.delete(sucursalModel);

        return RespuestaGenericaDto.builder()
            .data(sucursalDto)
            .build();    
    }
}

