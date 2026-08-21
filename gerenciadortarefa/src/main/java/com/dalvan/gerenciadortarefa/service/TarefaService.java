package com.dalvan.gerenciadortarefa.service;

import com.dalvan.gerenciadortarefa.dto.TarefaCadastroDto;
import com.dalvan.gerenciadortarefa.dto.TarefaDto;
import com.dalvan.gerenciadortarefa.entity.Meta;
import com.dalvan.gerenciadortarefa.entity.Tarefa;
import com.dalvan.gerenciadortarefa.repository.TarefaRepository;
import org.springframework.stereotype.Service;


@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public TarefaDto cadastrar(TarefaCadastroDto dados, Meta meta){
        Tarefa tarefa = new Tarefa(
                dados.getTitulo(),
                dados.getDescricao(),
                dados.getDataPrevista(),
                meta
        );

        Tarefa tarefaSalva = tarefaRepository.save(tarefa);

       return new TarefaDto(
               tarefaSalva.getId(),
               tarefaSalva.getTitulo(),
               tarefaSalva.getDescricao(),
               tarefaSalva.getNumeroDia(),
               tarefaSalva.getStatus(),
               tarefaSalva.getDataCriacao(),
               tarefaSalva.getDataPrevista()
       );
    }
}
