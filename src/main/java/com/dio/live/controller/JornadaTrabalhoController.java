package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    JornadaService jornadaService;

    @Autowired
    public JornadaTrabalhoController(JornadaService jornadaService) {
        this.jornadaService = jornadaService;
    }

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return this.jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList() {
        return this.jornadaService.findAll();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("idJornada") Long id) throws Exception {
        return ResponseEntity.ok(jornadaService.getById(id).orElseThrow(() -> new NoSuchElementException("Jornada não encontrada")));
    }

    @PutMapping
    public JornadaTrabalho updateJornada (JornadaTrabalho jornadaTrabalho) {
        return this.jornadaService.updateJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public void deleteJornada(@PathVariable("idJornada") Long idJornada) throws Exception {
        this.jornadaService.deleteJornada(idJornada);
    }
}
