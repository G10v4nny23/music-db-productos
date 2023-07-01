package cl.datawise.musicpro.dbproductos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.datawise.musicpro.dbproductos.models.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Integer>{
    Optional<CategoriaModel> findByNombre(String nombre);
}

