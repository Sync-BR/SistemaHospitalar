package sistema.hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sistema.hospital.Beans.especialidadeBean;
import sistema.hospital.Beans.filaBean;
import sistema.hospital.Beans.pacientesBean;
import sistema.hospital.Beans.prioridadeBean;
import sistema.hospital.util.conexaoUtil;

/**
 *
 * @author SYNC
 */
public class ListaDao {

    private static final ArrayList<pacientesBean> addPaciente = new ArrayList<>();

    public ListaDao() {
        addPaciente.clear();
    }

    /**
     *
     * Carregar listar de prioridades
     *
     * @return
     * @throws java.lang.Exception
     */
    /**
     * *
     * REGRA DE NEGOCIO
     *
     * Tabela de lista de chamadas -Deve seguir a ordem -- 2 Vermelhos -- 1
     * Amarelo -- 1 Branco
     */
    public ArrayList<pacientesBean> loadList() throws Exception {
        ArrayList<pacientesBean> listPacientes = new ArrayList<>();
        ArrayList<pacientesBean> pacienteListVermelho = ListaDao.loadRedList();

        for (pacientesBean loadPaciente : pacienteListVermelho) {
            listPacientes.add(loadPaciente);
            break;
        }
        ArrayList<pacientesBean> pacienteListLaranja = ListaDao.loadOrangeList();
        for (pacientesBean loadPaciente : pacienteListLaranja) {
            listPacientes.add(loadPaciente);
            break;
        }
        ArrayList<pacientesBean> pacienteListBranco = ListaDao.loadWhiteList();
        for (pacientesBean loadPaciente : pacienteListBranco) {
            listPacientes.add(loadPaciente);
            break;
        }


        for (pacientesBean listarpacientes : listPacientes) {
            System.out.println("Nome: " + listarpacientes.getNome());
            System.out.println("Cpf: " + listarpacientes.getCpf());
            System.out.println("Especialista: " + listarpacientes.getEspecialista().getEspecialista());
            System.out.println("Prioridade: " + listarpacientes.getprioridade().getPrioridade());
            System.out.println("===================Dados finalizados===================");

        }

      
        return listPacientes;
    }

    public static void main(String[] args) throws Exception {
        ListaDao lista = new ListaDao();
        lista.loadList();
    }

    public filaBean chamar() throws Exception {
        filaBean addFila = new filaBean();
        List<pacientesBean> cpf = new ArrayList<>();
        pacientesBean filaPaciente = new pacientesBean();
        for (pacientesBean paciente : addPaciente) {
            addFila.setNome(paciente.getNome());
            addFila.setCpf(paciente.getCpf());
            addFila.setEspecialista(paciente.getEspecialista().getEspecialista());
            addFila.setPrioridade(paciente.getprioridade().getPrioridade());

            filaPaciente.setCpf(paciente.getCpf());
            System.out.println("CPF: " + paciente.getCpf());
            break;
        }

        // deletePaciente(filaPaciente);
        return addFila;

    }

    private static void deletePaciente(pacientesBean deletePacientes) throws Exception {

        String sql = "DELETE FROM hospital.paciente where Cpf =  ?";
        try (Connection connection = conexaoUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, deletePacientes.getCpf());
            int deleted = ps.executeUpdate();
            if (deleted > 0) {
                System.out.println("Deletado com sucesso");
            } else {
                System.out.println("Falhou");
            }
        }

    }

    public ArrayList<pacientesBean> listPatients() throws Exception {
        especialidadeBean addespecialista = new especialidadeBean();
        prioridadeBean addprioridade = new prioridadeBean();
        pacientesBean pacientes = new pacientesBean();
        String sql = "SELECT * FROM hospital.paciente";
        try (Connection connection = conexaoUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                pacientes.setId(rs.getInt("id"));
                pacientes.setNome(rs.getString("Nome"));
                pacientes.setCpf(rs.getString("Cpf"));
                addespecialista.setEspecialista(rs.getString("Especialista"));
                addprioridade.setPrioridade(rs.getString("Prioridade"));
                pacientes.setPrioridade(addprioridade);
                pacientes.setEspecialista(addespecialista);
                addPaciente.add(new pacientesBean(pacientes.getId(), pacientes.getNome(), pacientes.getCpf(), pacientes.getprioridade().getPrioridade(), pacientes.getEspecialista().getEspecialista()));

            }
        }
        return addPaciente;

    }

    /**
     *
     * @loadRedList() Carregar lista de prioridades vermelho do banco de dados
     * @return Retornar o tipo Arraylist
     * @throws Trata os possiveis erros
     */
    private static ArrayList<pacientesBean> loadRedList() throws Exception {
        addPaciente.clear();
        especialidadeBean addespecialista = new especialidadeBean();
        prioridadeBean addprioridade = new prioridadeBean();
        pacientesBean pacientes = new pacientesBean();
        String sql = "SELECT * FROM hospital.paciente WHERE Prioridade = 'Vermelho'";
        try (Connection connection = conexaoUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                addespecialista.setEspecialista(rs.getString("Especialista"));
                addprioridade.setPrioridade(rs.getString("Prioridade"));
                pacientes.setId(rs.getInt("id"));
                pacientes.setNome(rs.getString("Nome"));
                pacientes.setCpf(rs.getString("Cpf"));
                pacientes.setPrioridade(addprioridade);
                pacientes.setEspecialista(addespecialista);
                addPaciente.add(new pacientesBean(pacientes.getId(), pacientes.getNome(), pacientes.getCpf(), pacientes.getprioridade().getPrioridade(), pacientes.getEspecialista().getEspecialista()));

            }
        }
        return addPaciente;

    }

    /**
     *
     * @loadOrangeList() Carregar lista de prioridades laranja do banco de dados
     * @return Retornar o tipo Arraylist
     * @throws Trata os possiveis erros
     */
    private static ArrayList<pacientesBean> loadOrangeList() throws Exception {
        addPaciente.clear();
        especialidadeBean addespecialista = new especialidadeBean();
        prioridadeBean addprioridade = new prioridadeBean();
        pacientesBean pacientes = new pacientesBean();
        String sql = "SELECT * FROM hospital.paciente WHERE Prioridade = 'Laranja'";
        try (Connection connection = conexaoUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                addespecialista.setEspecialista(rs.getString("Especialista"));
                addprioridade.setPrioridade(rs.getString("Prioridade"));
                pacientes.setId(rs.getInt("id"));
                pacientes.setNome(rs.getString("Nome"));
                pacientes.setCpf(rs.getString("Cpf"));
                pacientes.setPrioridade(addprioridade);
                pacientes.setEspecialista(addespecialista);
                addPaciente.add(new pacientesBean(pacientes.getId(), pacientes.getNome(), pacientes.getCpf(), pacientes.getprioridade().getPrioridade(), pacientes.getEspecialista().getEspecialista()));

            }
        }
        return addPaciente;

    }

    /**
     *
     * @loadWhiteList() Carregar lista de prioridades branco do banco de dados
     * @return Retornar o tipo Arraylist
     * @throws Trata os possiveis erros
     */
    private static ArrayList<pacientesBean> loadWhiteList() throws Exception {
        addPaciente.clear();
        especialidadeBean addespecialista = new especialidadeBean();
        prioridadeBean addprioridade = new prioridadeBean();
        pacientesBean pacientes = new pacientesBean();
        String sql = "SELECT * FROM hospital.paciente WHERE Prioridade = 'Branco'";
        try (Connection connection = conexaoUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                addespecialista.setEspecialista(rs.getString("Especialista"));
                addprioridade.setPrioridade(rs.getString("Prioridade"));
                pacientes.setId(rs.getInt("id"));
                pacientes.setNome(rs.getString("Nome"));
                pacientes.setCpf(rs.getString("Cpf"));
                pacientes.setPrioridade(addprioridade);
                pacientes.setEspecialista(addespecialista);
                addPaciente.add(new pacientesBean(pacientes.getId(), pacientes.getNome(), pacientes.getCpf(), pacientes.getprioridade().getPrioridade(), pacientes.getEspecialista().getEspecialista()));

            }
        }
        return addPaciente;

    }

}
