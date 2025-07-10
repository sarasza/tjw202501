package br.edu.ifce.meuprimeirospringboot.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifce.meuprimeirospringboot.beans.Matricula;
import br.edu.ifce.meuprimeirospringboot.repository.MatriculaRepository;
import br.edu.ifce.meuprimeirospringboot.service.MatriculaService;

import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {
    
    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> listarTodos() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula salvar(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula buscarPorId(Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada com o ID: " + id));
    }

    @Override
    public void deletar(Long id) {
        matriculaRepository.deleteById(id);
    }
}