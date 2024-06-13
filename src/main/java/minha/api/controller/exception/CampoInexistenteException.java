package minha.api.controller.exception;

public class CampoInexistenteException extends BusinessException {

    public CampoInexistenteException(String mensagem){
        super(mensagem);
    }
    public CampoInexistenteException(String mensagem, Object ... params) {
        super(String.format(mensagem, params));
    }
}
