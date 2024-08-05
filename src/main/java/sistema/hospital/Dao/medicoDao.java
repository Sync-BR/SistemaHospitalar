
package sistema.hospital.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sistema.hospital.Beans.especialidadeBean;
import sistema.hospital.Beans.medicoBean;
import sistema.hospital.util.conexaoUtil;

/**
 *
 * @author SYNC
 * @medicoDao Classe responsavel pelas operações dos medicos.
 */
public class medicoDao {
    
    public static void main(String[] args) throws Exception{
        especialidadeBean addEspecialista = new especialidadeBean();
        medicoBean addMedico = new medicoBean();
        medicoDao cadastrarMedico = new medicoDao();
        addMedico.setNome("SYNC BACKEND");
        addMedico.setCpf("06126039548");
        addMedico.setDescricao("ótimo medico");
        addMedico.setIdade(26);
        addMedico.setSala("25B");
        addEspecialista.setEspecialista("Cirugiao");
        addMedico.setEspecialidade(addEspecialista);
        cadastrarMedico.registerMedico(addMedico);
    }
    
    public void registerMedico(medicoBean addMedico) throws Exception{
        String sql = "insert into hospital.medico (nome, cpf, descricao, sala, especialidade, idade) value (?,?,?,?,?,?)";
        try(Connection connection = conexaoUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, addMedico.getNome());
            ps.setString(2, addMedico.getCpf());
            ps.setString(3, addMedico.getDescricao());
            ps.setString(4, addMedico.getSala());
            ps.setObject(5, addMedico.getEspecialidade());
            ps.setInt(6, addMedico.getIdade());
            int state = ps.executeUpdate();
            if(state > 0){
                System.out.println("Sucesso ao adicionar medico " +addMedico.getNome());
            } else {
                System.out.println("Falhou");
            }
        } catch(SQLException e){
            e.getMessage();
        }
    
    }
    
    
    
}
