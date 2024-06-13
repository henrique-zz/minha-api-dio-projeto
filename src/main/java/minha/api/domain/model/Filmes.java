package minha.api.domain.model;

import javax.persistence.*;

@Entity(name = "tb_filmes")
public class Filmes{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeFilme;

    private String nomeDiretor;

    private boolean assistido;

    @Column(nullable = false)
    private int notaFilme;

    @Column(nullable = false)
    private int duracaoEmMin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDuracaoEmMin() {
        return duracaoEmMin;
    }

    public void setDuracaoEmMin(int duracaoEmMin) {
        this.duracaoEmMin = duracaoEmMin;
    }

    public int getNotaFilme() {
        return notaFilme;
    }

    public void setNotaFilme(int notaFilme) {
        this.notaFilme = notaFilme;
    }

    public boolean isAssistido() {
        return assistido;
    }

    public void setAssistido(boolean assistido) {
        this.assistido = assistido;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }
}
