package br.com.workconnect.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNotFound(NoHandlerFoundException ex, Model model) {
        model.addAttribute("message", "A página que você tentou acessar não existe.");
        return "errors/404";
    }

    @ExceptionHandler(Exception.class)
    public String handleInternalError(Exception ex, Model model) {
        model.addAttribute("message",
                "Ocorreu um erro inesperado. Nossa equipe foi notificada.");
        ex.printStackTrace();
        return "errors/500";
    }
}
