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
import static sistema.hospital.Beans.especialidadeBean.especialistas;

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

    @PostConstruct
    public void init() {
        try {
            obterLista();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<pacientesBean> obterLista() throws Exception {
        pacientesBean.pacientes = listaDao.listPatients();

        return pacientes;

    }

    public static void main(String[] args) throws Exception {
        pacientesBean te = new pacientesBean();
        List<pacientesBean> addpacientes = te.obterLista();
        for (pacientesBean paci : addpacientes) {
            System.out.println(paci.nome);
        }
        /*
        especialidadeBean especialista = new especialidadeBean();
        especialista.setEspecialista("teste");
        pacientesBean pacientesBean = new pacientesBean();
        pacientesBean.setEspecialista(especialista);
        System.out.println("Especialista: " + pacientesBean.getEspecialista().getEspecialista());
         */
        ListaDao lista = new ListaDao();
        // pacientes = lista.listPatients();

        for (pacientesBean addPacientes : pacientes) {
            System.out.println("Nome: " + addPacientes.getNome());
            System.out.println("CPF:" + addPacientes.getCpf());
            System.out.println("Especialista:" + addPacientes.getEspecialista().getEspecialista());
            // System.out.println("Especialista: " + addPacientes.especialista.getEspecialista());
        }

    }

    public pacientesBean() {
        this.especialista = new especialidadeBean();
        this.prioridade = new prioridadeBean();
        pacientes = new ArrayList<>();

    }

    public pacientesBean(int id, String nome, String cpf, String prioridade, String especialista) {
        this.especialista = new especialidadeBean();
        this.prioridade = new prioridadeBean();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.prioridade.Prioridade = prioridade;
        this.especialista.especialista = especialista;
    }

    public pacientesBean(especialidadeBean especialista) {

        this.especialista = especialista;
    }

    public void listar() throws Exception {
        //     pacientes = listaDao.listPatients();
        //  pacientes = listaDao.listPatients();
        pacientesBean add = new pacientesBean();
        for (pacientesBean listarPacientes : pacientes) {
            pacientes.add(listarPacientes);
            //  System.out.println("Nome: " +listarPacientes.getNome() );

        }
        for (int index = 0; index < pacientes.size(); index++) {
            System.out.println(pacientes.get(index));
        }

    }
    public String nomeSelecionado;
    public void viwerName(ValueChangeEvent event) {
        
        String nome = (String) event.getNewValue();
        this.especialista.especialista = nome;
    }
    public String registerPaciente() throws Exception {
        pacientesBean addPaciente = new pacientesBean();
        pacienteDao registerPaciente = new pacienteDao();
        addPaciente.setNome(nome);
        addPaciente.setCpf(cpf);
        addPaciente.setEspecialista(especialista);
        addPaciente.setPrioridade(prioridade);
        boolean stateRegistred = registerPaciente.registerPatient(addPaciente);
        if (stateRegistred) {
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Adicionado com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            return null;

        } else {
            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falhou ao adicionar paciente", null);
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            return null;
        }

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
