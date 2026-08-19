package com.dalvan.gerenciadortarefa.service;

import com.dalvan.gerenciadortarefa.dto.AtualizarMetaDto;
import com.dalvan.gerenciadortarefa.dto.MetaCadastroDto;
import com.dalvan.gerenciadortarefa.dto.MetaDto;
import com.dalvan.gerenciadortarefa.entety.Meta;
import com.dalvan.gerenciadortarefa.entety.Usuario;
import com.dalvan.gerenciadortarefa.execept.MetaNaoEncontradaExeption;
import com.dalvan.gerenciadortarefa.repository.MetaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<MetaDto> listarMetaUsuario(Usuario usuario) {
        List<Meta> metas = metaRepository.findByUsuario(usuario);

        List<MetaDto> metasDto = new ArrayList<>();

        for  (Meta meta : metas) {
            MetaDto metaDto = new MetaDto(
            meta.getId(),
            meta.getTitulo(),
            meta.getDescricao(),
            meta.getPrazo(),
            meta.getTipo(),
            meta.getStatus(),
            meta.getDataCriacao()
            );
            metasDto.add(metaDto);

        }
        return metasDto;
    }

    public MetaDto buscarIdAndUsuario(Long id, Usuario usuario) {
        Meta meta = metaRepository.findByIdAndUsuario(id, usuario)
                .orElseThrow(() -> new MetaNaoEncontradaExeption());

        return  new MetaDto(
                meta.getId(),
                meta.getTitulo(),
                meta.getDescricao(),
                meta.getPrazo(),
                meta.getTipo(),
                meta.getStatus(),
                meta.getDataCriacao()
        );


    }
    public MetaDto atualizar(Long id, AtualizarMetaDto dado, Usuario usuario) {
        Meta meta = metaRepository.findByIdAndUsuario(id, usuario)
                .orElseThrow(() -> new MetaNaoEncontradaExeption());

        meta.setTitulo(dado.getTitulo());
        meta.setDescricao(dado.getDescricao());
        meta.setPrazo(dado.getPrazo());
        meta.setTipo(dado.getTipo());

        Meta atualizadaMeta = metaRepository.save(meta);

        return  new MetaDto(
                atualizadaMeta.getId(),
                atualizadaMeta.getTitulo(),
                atualizadaMeta.getDescricao(),
                atualizadaMeta.getPrazo(),
                atualizadaMeta.getTipo(),
                atualizadaMeta.getStatus(),
                atualizadaMeta.getDataCriacao()
        );
    }

    public void deletar(Long id, Usuario usuario) {
        Meta meta = metaRepository.findByIdAndUsuario(id, usuario)
                .orElseThrow(() -> new MetaNaoEncontradaExeption());

        metaRepository.delete(meta);

    }
}
