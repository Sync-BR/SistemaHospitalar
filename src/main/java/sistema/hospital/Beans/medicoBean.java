
package sistema.hospital.Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author SYNC
 */
@ManagedBean(name = "MedicoBean")
@ViewScoped
public class medicoBean {
    
    public medicoBean() {
        this.especialidade = new especialidadeBean();
    }
    
    private String nome;
    private String cpf; 
    private String descricao;
    private especialidadeBean especialidade;
    private int idade;
    private String sala;
    
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public especialidadeBean getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(especialidadeBean especialidade) {
        this.especialidade = especialidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
