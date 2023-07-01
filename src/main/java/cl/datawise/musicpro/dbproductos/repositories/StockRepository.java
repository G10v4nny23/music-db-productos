package cl.datawise.musicpro.dbproductos.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import cl.datawise.musicpro.dbproductos.models.ProductoModel;
import cl.datawise.musicpro.dbproductos.models.StockModel;
import cl.datawise.musicpro.dbproductos.models.SucursalModel;


//Aqui tengo una duda
@Repository
public interface StockRepository extends JpaRepository<StockModel, Integer>{
    Optional<StockModel> findByProducto (ProductoModel producto);
    Optional<StockModel> findBySucursal (SucursalModel sucursal);
    Optional<StockModel> findByCantidad (int cantidad);
    
}
