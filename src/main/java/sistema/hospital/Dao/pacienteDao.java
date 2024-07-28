package sistema.hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import sistema.hospital.Beans.especialidadeBean;
import sistema.hospital.Beans.pacientesBean;
import sistema.hospital.util.conexaoUtil;

/**
 *
 * @author SYNC INSERT INTO `hospital`.`paciente` (`id`, `Nome`, `Cpf`,
 * `Especialista`, `Prioridade`) VALUES ('1', 'ewad', '2323', 'awdaw',
 * 'wadwad');
 *
 */
public class pacienteDao {

    public boolean registerPatient(pacientesBean addPaciente) throws Exception {
        boolean registred = false;
        String sql = "insert into hospital.paciente (Nome, Cpf, Especialista, Prioridade) values (?,?,?,?)";
        try (Connection connection = conexaoUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, addPaciente.getNome());
            ps.setString(2, addPaciente.getCpf());
           ps.setString(3, addPaciente.getEspecialista().getEspecialista());
           ps.setString(4, addPaciente.getprioridade().getPrioridade());
            int state = ps.executeUpdate();
            if(state > 0){
                registred = true;
            } 

        }
        return registred;
    }
    public static void main(String[] args)  throws Exception{
        pacientesBean add = new pacientesBean();
        especialidadeBean especialista = new especialidadeBean();
        pacienteDao cad = new pacienteDao();
        add.setNome("Eduardo");
        add.setCpf("06126039548");
        
       // add.setPrioridade(1);
        cad.registerPatient(add);
    }

}
