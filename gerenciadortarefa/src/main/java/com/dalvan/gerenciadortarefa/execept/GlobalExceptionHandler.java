package com.dalvan.gerenciadortarefa.execept;


import com.dalvan.gerenciadortarefa.dto.ErroDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UsuarioNaoEncontradoExeception.class)
    public ResponseEntity<ErroDto> tratarUsuarioNaoEncontrado(
            UsuarioNaoEncontradoExeception exeption) {

        ErroDto erroDto = new ErroDto(
                HttpStatus.NOT_FOUND.value(),
                exeption.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(erroDto);
    }

    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<ErroDto> tratarEmailJaCadastrado(
            EmailJaCadastradoException exception) {

        ErroDto erroDto = new ErroDto(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(erroDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> tratarValidacao(
            MethodArgumentNotValidException exception) {
        Map<String, String> erros = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(erro ->
                        erros.put(
                                erro.getField(),
                                erro.getDefaultMessage()));
        return ResponseEntity
                .badRequest()
                .body(erros);

    }



}
