package br.edu.ifce.meuprimeirospringboot.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifce.meuprimeirospringboot.beans.Turma;
import br.edu.ifce.meuprimeirospringboot.repository.TurmaRepository;
import br.edu.ifce.meuprimeirospringboot.service.TurmaService;
import java.util.List;

@Service
public class TurmaServiceImpl implements TurmaService {
    
    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public List<Turma> listarTodos() {
        return turmaRepository.findAll();
    }

    @Override
    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public Turma buscarPorId(Long id) {
        return turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com o ID: " + id));
    }

    @Override
    public void deletar(Long id) {
        turmaRepository.deleteById(id);
    }
}