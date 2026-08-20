package com.dalvan.gerenciadortarefa.repository;

import com.dalvan.gerenciadortarefa.entity.Meta;
import com.dalvan.gerenciadortarefa.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MetaRepository extends JpaRepository<Meta,Long> {
    List<Meta> findByUsuario(Usuario usuario);
    Optional<Meta> findByIdAndUsuario(Long id, Usuario usuario);
}
