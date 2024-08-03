package sistema.hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sistema.hospital.Beans.pacientesBean;
import sistema.hospital.util.conexaoUtil;

/**
 *
 * @author SYNC
 * @pacienteDao Classe responsavel pelas operações com banco de dados
 */
public class pacienteDao {

    /**
     *
     * @author SYNC
     * @param addPaciente Instanciar a classe pacientesBean
     * @return Retornar o código do estado da manipulação
     * @Códigos de retorno 0 -> Erro de conexão com banco de dados. 200 -> Registrado. 
     * @throws java.lang.Exception Efetuar os possiveis tratamentos de erros
     * @registerPatient Funcionalidade para registrar um paciente na lista de chamada através do banco de dados.
     */
    public int registerPatient(pacientesBean addPaciente) throws Exception {
        int codeState = 0;
        String sql = "insert into hospital.paciente (Nome, Cpf, Especialista, Prioridade) values (?,?,?,?)";
        try (Connection connection = conexaoUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, addPaciente.getNome());
            ps.setString(2, addPaciente.getCpf());
            ps.setString(3, addPaciente.getEspecialista().getEspecialista());
            ps.setString(4, addPaciente.getprioridade().getPrioridade());
            int state = ps.executeUpdate();
            if (state > 0) {
                codeState = 200; 
            }

        } catch (SQLException e) {
            e.getMessage();
            codeState = e.getErrorCode();
            System.out.println("Código de erro: " + codeState);

        }
        return codeState;
    }



}
