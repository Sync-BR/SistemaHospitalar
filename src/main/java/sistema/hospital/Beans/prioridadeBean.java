
package sistema.hospital.Beans;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sync
 */
public class prioridadeBean {
    public String Prioridade;
    private static  Map<String, String> prioridade = new HashMap<>();
    static{
        getprioridade().put("1", "Vermelho");
        getprioridade().put("2", "Laranja");
        getprioridade().put("3", "Branco");
    }
    
    public String viwerName(String event){
        this.Prioridade = event;
        return Prioridade;
    }
    
    public String getPrioridade() {
        return Prioridade;
    }

    public void setPrioridade(String Prioridade) {
        this.Prioridade = viwerName(Prioridade);
    }
    
    public static Map<String, String> getprioridade() {
        return prioridade;
    }
    public static void setPrioridade(Map<String, String> aPrioridade) {
        prioridade = aPrioridade;
    }
    
}
