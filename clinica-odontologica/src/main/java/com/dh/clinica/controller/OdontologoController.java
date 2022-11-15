package com.dh.clinica.controller;

import com.dh.clinica.dao.impl.OdontologoDaoH2;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.OdontologoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private final OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @GetMapping("/search")
    public ResponseEntity<Odontologo> buscar(@RequestParam Integer id) {
        Odontologo odontologo = odontologoService.buscar(id).orElse(null);
        return ResponseEntity.ok(odontologo);
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos() {
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }
}
