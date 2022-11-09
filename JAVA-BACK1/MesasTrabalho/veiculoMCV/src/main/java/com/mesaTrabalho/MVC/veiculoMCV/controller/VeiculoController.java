package com.mesaTrabalho.MVC.veiculoMCV.controller;


import com.mesaTrabalho.MVC.veiculoMCV.model.Veiculo;
import com.mesaTrabalho.MVC.veiculoMCV.service.IveiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VeiculoController {

    private final IveiculoService iveiculoService;

    @Autowired
    public VeiculoController(IveiculoService iveiculoService) {
        this.iveiculoService = iveiculoService;
    }



    @GetMapping(value = "veiculos")
    public List<Veiculo> getVeiculo(){
        return iveiculoService.listVeiculo();
    }
}
