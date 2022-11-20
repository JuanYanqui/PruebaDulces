package com.ista.dulceria.dulce.estrella.web.models.entity.service;

import com.ista.dulceria.dulce.estrella.web.models.entity.Empresa;
import com.ista.dulceria.dulce.estrella.web.models.entity.dao.EmpresaRepository;
import com.ista.dulceria.dulce.estrella.web.models.entity.dao.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService{

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> findAll() {
        // TODO Auto-generated method stub
        return (List<Empresa>) empresaRepository.findAll();
    }

    @Override
    public Empresa save(Empresa empresa) {
        // TODO Auto-generated method stub
        return empresaRepository.save(empresa);
    }


    @Override
    public Empresa findById(Long id) {
        // TODO Auto-generated method stub
        return empresaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        // TODO Auto-generated method stub
        empresaRepository.deleteById(id);

    }

    @Override
    public Empresa actualizar(Empresa articulos) {
        // TODO Auto-generated method stub
        return empresaRepository.save(articulos);
    }
}
