package com.dalvan.gerenciadortarefa.service;

import com.dalvan.gerenciadortarefa.dto.MetaCadastroDto;
import com.dalvan.gerenciadortarefa.dto.MetaDto;
import com.dalvan.gerenciadortarefa.entety.Meta;
import com.dalvan.gerenciadortarefa.entety.Usuario;
import com.dalvan.gerenciadortarefa.repository.MetaRepository;
import org.springframework.stereotype.Service;

@Service
public class MetaService {
    private final MetaRepository metaRepository;

    public MetaService(MetaRepository metaRepository) {
        this.metaRepository = metaRepository;
    }

    public MetaDto cadastrar(MetaCadastroDto dados, Usuario usuario) {

        Meta meta = new Meta(
                dados.getTitulo(),
                dados.getDescricao(),
                dados.getTipo(),
                usuario,
                dados.getPrazo()
        );

        Meta saveMeta = metaRepository.save(meta);

        return  new MetaDto(
                saveMeta.getId(),
                saveMeta.getTitulo(),
                saveMeta.getDescricao(),
                saveMeta.getPrazo(),
                saveMeta.getTipo(),
                saveMeta.getStatus(),
                saveMeta.getDataCriacao()
        );
    }
}
