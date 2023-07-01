package cl.datawise.musicpro.dbproductos.services;

import org.springframework.stereotype.Service;

import cl.datawise.musicpro.dbproductos.dto.CategoriaDto;
import cl.datawise.musicpro.dbproductos.dto.RespuestaGenericaDto;
import cl.datawise.musicpro.dbproductos.exceptions.CategoriaException;
import cl.datawise.musicpro.dbproductos.mappers.CategoriaMapper;
import cl.datawise.musicpro.dbproductos.models.CategoriaModel;
import cl.datawise.musicpro.dbproductos.repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor()
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;


    public RespuestaGenericaDto getCategoriaById(int id) throws CategoriaException{
        CategoriaModel categoria = categoriaRepository.findById(id).orElseThrow(() -> new CategoriaException("Not Found"));
        CategoriaDto categoriaDto = CategoriaMapper.createDto(categoria);
        return RespuestaGenericaDto.builder()
                .data(categoriaDto)
                .build();
        }


    public RespuestaGenericaDto getCategoriaByNombre(String nombre) throws CategoriaException{
        CategoriaModel categoria = categoriaRepository.findByNombre(nombre).orElseThrow(() -> new CategoriaException("Not Found"));
        CategoriaDto categoriaDto = CategoriaMapper.createDto(categoria);
        return RespuestaGenericaDto.builder()
                .data(categoriaDto)
                .build();
        }


    public CategoriaDto createCategoria(CategoriaDto categoriaDto){
        CategoriaModel categoriaModel = CategoriaMapper.createModel(categoriaDto);
        CategoriaModel categoriaCreated = categoriaRepository.save(categoriaModel);
        return CategoriaMapper.createDto(categoriaCreated);
    }


    public RespuestaGenericaDto updateCategoria(CategoriaModel categoriaModel) throws CategoriaException{
        CategoriaModel categoriaFound = categoriaRepository.findById(categoriaModel.getId()).orElseThrow(() -> new CategoriaException("Not Found"));
        categoriaFound.setNombre(categoriaModel.getNombre());

        CategoriaModel categoria = categoriaRepository.save(categoriaFound);
        CategoriaDto categoriaDto = CategoriaMapper.createDto(categoria);
        return RespuestaGenericaDto.builder()
            .data(categoriaDto)
            .build();        
    }


    public RespuestaGenericaDto deleteCategoria(int id) throws CategoriaException{
        CategoriaModel categoriaModel = categoriaRepository.findById(id).orElseThrow(() -> new CategoriaException("Not Found"));
        CategoriaDto categoriaDto = CategoriaMapper.createDto(categoriaModel);

        categoriaRepository.delete(categoriaModel);
        return RespuestaGenericaDto.builder()
            .data(categoriaDto)
            .build();

    }
}
