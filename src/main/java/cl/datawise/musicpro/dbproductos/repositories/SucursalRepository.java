package cl.datawise.musicpro.dbproductos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.datawise.musicpro.dbproductos.models.SucursalModel;

@Repository
public interface SucursalRepository extends JpaRepository<SucursalModel, Integer>{
    Optional<SucursalModel> findByNombre (String nombre);
    Optional<SucursalModel> findByDireccion (String direccion);
    Optional<SucursalModel> findByPermisoMunicipal (String permisoMunicipal);
    Optional<SucursalModel> findByRut (String rut);
    Optional<SucursalModel> findByIdEncargado (Integer idEncargado);
}
