package com.mesaTrabalho.MVC.veiculoMCV.service.impl;

import com.mesaTrabalho.MVC.veiculoMCV.model.Veiculo;
import com.mesaTrabalho.MVC.veiculoMCV.service.IveiculoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VeiculoServiceImpl implements IveiculoService {
    @Override
    public List<Veiculo> listVeiculo() {

        return Arrays.asList(new Veiculo("GOL","Vermelho"),new Veiculo("GOL","Azul"),new Veiculo("GOL","Preto"));
    }
}
