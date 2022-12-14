package com.breast.exam_result.entities;


import javax.persistence.*;

@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private String regiao;
    private  Long qnt_exames;

    public Region(String regiao, Long qnt_exames) {
       this.regiao = regiao;
        this.qnt_exames = qnt_exames;
    }

    public Region() {

    }

    public Long getId() {
        return id;
    }

   public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Long getQnt_exames() {
        return qnt_exames;
    }

    public void setQnt_exames(Long qnt_exames) {
        this.qnt_exames = qnt_exames;
    }
}
