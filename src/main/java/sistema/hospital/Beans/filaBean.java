package sistema.hospital.Beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sistema.hospital.Dao.ListaDao;

/**
 *
 * @author SYNC
 */
@ManagedBean(name = "filaBean")
@ViewScoped
public class filaBean {
    ListaDao lista = new ListaDao();
    private List<filaBean> fila = new ArrayList<>();
    private filaBean passiente = new filaBean();
    private String nome;
    private String cpf;
    private String especialista;
    private String prioridade;

    public filaBean() {
        this.fila = new ArrayList<>();
    }

    /**
     * @return the fila
     */
    public List<filaBean> getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(List<filaBean> fila) {
        this.fila = fila;
    }

    /**
     * @return the passiente
     */
    public filaBean getPassiente() throws Exception {
        passiente = lista.chamar();
        return passiente;
    }

    /**
     * @param passiente the passiente to set
     */
    public void setPassiente(filaBean passiente) {
        this.passiente = passiente;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the especialista
     */
    public String getEspecialista() {
        return especialista;
    }

    /**
     * @param especialista the especialista to set
     */
    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

    /**
     * @return the prioridade
     */
    public String getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }


}
