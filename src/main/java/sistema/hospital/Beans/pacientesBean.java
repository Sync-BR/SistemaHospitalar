package sistema.hospital.Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import sistema.hospital.Dao.ListaDao;
import sistema.hospital.Dao.pacienteDao;

/**
 *
 * @author SYNC
 */
@ManagedBean(name = "pacientesBeans")
@ViewScoped
public class pacientesBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static ArrayList<pacientesBean> pacientes = new ArrayList<>();
    private int id;
    private String nome;
    private String cpf;
    private especialidadeBean especialista;
    private prioridadeBean prioridade;
    ListaDao listaDao = new ListaDao();

    /**
     *
     * @init Carregar os arquivos de inicialização.
     */
    @PostConstruct
    public void init() {
        try {

            getPacientes(); //Carregar a lista da tabela de pacientes listaPacientes.xhtml.
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     *
     * @pacientesBean inicializar as classes das instancias
     *
     */
    public pacientesBean() {
        this.especialista = new especialidadeBean();
        this.prioridade = new prioridadeBean();
        pacientes = new ArrayList<>();

    }

    /**
     *
     * @param id Recebe o valor do id
     * @param nome recebe o valor do nome
     * @param cpf recebe o valor do cpf
     * @param prioridade Recebe o valor da prioridade.
     * @param especialista Recebe o valor da especialidade
     * @pacientesBean Construtor
     *
     */
    public pacientesBean(int id, String nome, String cpf, String prioridade, String especialista) {
        this.especialista = new especialidadeBean();
        this.prioridade = new prioridadeBean();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.prioridade.Prioridade = prioridade;
        this.especialista.especialista = especialista;
    }

    /**
     *
     * @viwerName Funcionalidade para pegar o valor do especialista
     * <h:selectOneMenu valueChangeListener="#{pacientesBeans.viwerName}">
     * @param event Recebe o nome
     */
    public void viwerName(ValueChangeEvent event) {
        String Nome = (String) event.getNewValue();
        this.especialista.especialista = Nome;

    }

    /**
     *
     * @viwerPriority Funcionalidade para pegar o valor da prioridade
     * <h:selectOneMenu  valueChangeListener="#{pacientesBeans.viwerPriority}">
     * @param event Recebe o nome da prioridade
     */
    public void viwerPriority(ValueChangeEvent event) {
        String value = (String) event.getNewValue();
        this.prioridade.Prioridade = value;
    }


    /**
     *
     * @return Retornar mensagem de Sucesso/Erro
     * @throws java.lang.Exception
     * @registerPaciente Funcionalidade para registrar um paciente no banco de dados
     * 
     */
    public String registerPaciente() throws Exception {
        pacientesBean addPaciente = new pacientesBean();
        pacienteDao registerPaciente = new pacienteDao();
        addPaciente.setNome(nome);
        addPaciente.setCpf(cpf);
        addPaciente.setEspecialista(especialista);
        addPaciente.setPrioridade(prioridade);
        int codeState = registerPaciente.registerPatient(addPaciente);
        switch (codeState) {
            
            case 200:
                    FacesMessage Sucesso = new FacesMessage(FacesMessage.SEVERITY_INFO, "Paciente: " +nome+ " Foi adicionado com sucesso.", null);
                    FacesContext.getCurrentInstance().addMessage(null, Sucesso);
                break;
                
            case 0:
                FacesMessage  Erro = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conexão", null);
                FacesContext.getCurrentInstance().addMessage(null, Erro);
                break;
            default:
                throw new AssertionError();
        }
 
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public especialidadeBean getEspecialista() {
        return especialista;
    }

    public void setEspecialista(especialidadeBean especialista) {
        this.especialista = especialista;
    }

    public prioridadeBean getprioridade() {
        return prioridade;
    }

    public void setPrioridade(prioridadeBean prioridade) {
        this.prioridade = prioridade;
    }

    public ArrayList<pacientesBean> getPacientes() throws Exception {
        pacientes = listaDao.listPatients();
        return pacientes;
    }

    public void setPacientes(List<pacientesBean> pacientess) {
        pacientesBean.pacientes = (ArrayList<pacientesBean>) pacientess;
    }

}