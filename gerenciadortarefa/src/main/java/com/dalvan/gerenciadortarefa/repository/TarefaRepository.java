package com.dalvan.gerenciadortarefa.repository;

import com.dalvan.gerenciadortarefa.entity.Meta;
import com.dalvan.gerenciadortarefa.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    List<Tarefa> findByMeta(Meta meta);
}
