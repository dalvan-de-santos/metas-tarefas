package com.dalvan.gerenciadortarefa.execept;


import com.dalvan.gerenciadortarefa.dto.ErroDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
                HttpStatus.CONFLICT.value(),
                exception.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(erroDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroDto> tratarValidacao(
            MethodArgumentNotValidException exception) {
        Map<String, String> campos = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(erro ->
                        campos.put(
                                erro.getField(),
                                erro.getDefaultMessage()));

        ErroDto erro = new ErroDto(
                HttpStatus.BAD_REQUEST.value(),
                "Dados invalidos",
                campos
        );

        return ResponseEntity
                .badRequest()
                .body(erro);

    }

    @ExceptionHandler(CredenciaisIvalidasExeception.class)
    public ResponseEntity<ErroDto> tratarCredenciaisInvalidas(
            CredenciaisIvalidasExeception exeption) {
                ErroDto erro = new ErroDto(
                        HttpStatus.UNAUTHORIZED.value(),
                        exeption.getMessage()
                );

                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body(erro);
    }

    @ExceptionHandler(MetaNaoEncontradaExeption.class)
    public ResponseEntity<ErroDto> tratarMetaNaoEncontrada(
            MetaNaoEncontradaExeption exeption) {

        ErroDto erroDto = new ErroDto(
                HttpStatus.NOT_FOUND.value(),
                exeption.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(erroDto);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> tratarHttpMessageNotReadable(HttpMessageNotReadableException exception) {
        Map<String, Object> erro = new HashMap<>();

        erro.put("status", 400);
        erro.put("erro", "Dados invalidos");
        erro.put(
                "mensagem",
                "Valor invalido, verifique os campos enviados!"
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(erro);
    }




}
