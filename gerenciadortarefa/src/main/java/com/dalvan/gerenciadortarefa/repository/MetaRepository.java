package com.dalvan.gerenciadortarefa.repository;

import com.dalvan.gerenciadortarefa.entety.Meta;
import com.dalvan.gerenciadortarefa.entety.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MetaRepository extends JpaRepository<Meta,Long> {
    List<Meta> findByUsuario(Usuario usuario);
    Optional<Meta> findByIdAndUsuario(Long id, Usuario usuario);
}
