package com.dalvan.gerenciadortarefa.repository;

import com.dalvan.gerenciadortarefa.entety.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends  JpaRepository<Usuario,Long> {
    boolean existsByEmail(String email);
}
