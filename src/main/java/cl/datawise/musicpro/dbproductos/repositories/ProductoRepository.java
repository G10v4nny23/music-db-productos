package cl.datawise.musicpro.dbproductos.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.datawise.musicpro.dbproductos.models.CategoriaModel;
import cl.datawise.musicpro.dbproductos.models.ProductoModel;
import java.util.Optional;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Integer>{
    Optional<ProductoModel> findByNombre(String nombre);
    Optional<ProductoModel> findByPrecio(int precio);
    Optional<ProductoModel> findByCategoria (CategoriaModel categoria);
}
