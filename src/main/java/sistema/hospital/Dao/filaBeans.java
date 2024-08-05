package sistema.hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sistema.hospital.Beans.especialidadeBean;
import sistema.hospital.Beans.filaBean;
import sistema.hospital.Beans.pacientesBean;
import sistema.hospital.Beans.prioridadeBean;
import sistema.hospital.util.conexaoUtil;

/**
 *
 * @author SYNC
 * @filaBeans Classe responsavel pelas operações das filas
 */
public class filaBeans {

    private static final ArrayList<pacientesBean> addPaciente = new ArrayList<>();

    /**
     *
     * Carregar listar de prioridades
     *
     * @return
     * @throws java.lang.Exception
     */
    public static ArrayList<pacientesBean> loadList() throws Exception {
        int totalInList = filaBeans.countPatientQueue();
        ArrayList<pacientesBean> listPacientes = new ArrayList<>();
        ArrayList<pacientesBean> pacienteListVermelho = filaBeans.loadRedList();
        int redList = 0;
        for (pacientesBean loadPaciente : pacienteListVermelho) {
            redList++;
            if (redList <= 2) {
                listPacientes.add(loadPaciente);
            } else {
                break;
            }
        }
        ArrayList<pacientesBean> pacienteListLaranja = filaBeans.loadOrangeList();
        for (pacientesBean loadPaciente : pacienteListLaranja) {
            listPacientes.add(loadPaciente);
            break;
        }
        ArrayList<pacientesBean> pacienteListBranco = filaBeans.loadWhiteList();
        for (pacientesBean loadPaciente : pacienteListBranco) {
            listPacientes.add(loadPaciente);
            break;
        }

        return listPacientes;
    }

    private static int countPatientQueue() throws Exception {
        String sql = "SELECT id FROM hospital.paciente";
        int count = 0;
        try (Connection connection = conexaoUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Erro código: " + e.getErrorCode());
        }

        return count;
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
