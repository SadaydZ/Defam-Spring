package com.autocine.defam.services;

import com.autocine.defam.model.Reserva;
import com.autocine.defam.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
}
