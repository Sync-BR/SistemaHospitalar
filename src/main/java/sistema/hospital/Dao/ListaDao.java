package sistema.hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sistema.hospital.Beans.especialidadeBean;
import sistema.hospital.Beans.pacientesBean;
import sistema.hospital.Beans.prioridadeBean;
import sistema.hospital.util.conexaoUtil;

/**
 *
 * @author SYNC
 */
public class ListaDao {

    public ArrayList<pacientesBean> listPatients() throws Exception {
        especialidadeBean addespecialista = new especialidadeBean();
        prioridadeBean addprioridade = new prioridadeBean();
        ArrayList<pacientesBean> addPaciente = new ArrayList<>();
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


                /*
                String especialista = rs.getString("Especialista");
                addespecialista.setEspecialista(especialista);
                String Prioridade = rs.getString("Prioridade");
                 */
                //  addPaciente.add(new pacientesBean(id, nome, cpf, especialidade, prioridade));
                 addPaciente.add(new pacientesBean(pacientes.getId(), pacientes.getNome(), pacientes.getCpf(),pacientes.getprioridade().getPrioridade(), pacientes.getEspecialista().getEspecialista()));
                //addPaciente.add(pacientes);
            }
        }
        return addPaciente;
    }

    public void verificarLista() throws Exception {
        ListaDao updateList = new ListaDao();
        new Thread(() -> {
            while (true) {
                try {
                    List<pacientesBean> pacientesInfor = updateList.listPatients();
                    for (pacientesBean pacientes : pacientesInfor) {
                        System.out.println("ID: " + pacientes.getId());
                        System.out.println("Nome: " + pacientes.getNome());
                        System.out.println("CPF: " + pacientes.getCpf());
                        System.out.println("Especialista: " + pacientes.getEspecialista());
                        //        System.out.println("Prioridade: " + pacientes.getPrioridade());

                    }

                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.getMessage();
                }
            }

        }).start();
    }

    public static void main(String[] args) throws Exception {
        ListaDao retornar = new ListaDao();
        retornar.listPatients();

    }

}
