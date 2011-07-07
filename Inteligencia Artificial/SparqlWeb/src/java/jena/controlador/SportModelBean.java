package jena.controlador;
public class SportModelBean {
    private String sexo;
    private String altura;
    private String peso;
    private String envergadura;
    private String massaMuscular;
    private String tamanhoMaos;
    private String tamanhoPes;

    public String getAltura() {
        return altura;
    }

    public void setAltura(String alto) {
        int alt=0;
        alt = Integer.parseInt(alto);
        if(alt <= 159)
            this.altura = "baixa";
        else if(alt >= 160 && alt <= 179)
            this.altura= "media";
        else if (alt >= 180)
            this.altura = "alta";
    }

    public String getEnvergadura() {
        return envergadura;
    }

    public void setEnvergadura(String envergadura) {
        this.envergadura = envergadura;
    }

    public String getMassaMuscular() {
        return massaMuscular;
    }

    public void setMassaMuscular(String massaMuscular) {
        this.massaMuscular = massaMuscular;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String pe) {
        int p=0;
        p = Integer.parseInt(pe);
        if(p <= 60)
            this.peso = "leve";
        else if(p >= 61 && p <= 90)
            this.peso= "medio";
        else if (p >= 91)
            this.peso = "elevado";
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTamanhoMaos() {
        return tamanhoMaos;
    }

    public void setTamanhoMaos(String tm) {
        int m=0;
        m = Integer.parseInt(tm);
        if(m <= 12)
            this.tamanhoMaos = "pequena";
        else if(m >= 13 && m <= 16)
            this.tamanhoMaos= "media";
        else if (m >= 16)
            this.tamanhoMaos = "grande";
    }

    public String getTamanhoPes() {
        return tamanhoPes;
    }

    public void setTamanhoPes(String tp) {
        int p=0;
        p = Integer.parseInt(tp);
        if(p <= 35)
            this.tamanhoPes = "pequeno";
        else if(p >= 36 && p <= 40)
            this.tamanhoPes= "medio";
        else if (p >= 41)
            this.tamanhoPes = "grande";
    }

    
}
