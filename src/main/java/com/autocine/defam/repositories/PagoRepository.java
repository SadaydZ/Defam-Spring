package com.autocine.defam.repositories;

import com.autocine.defam.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
