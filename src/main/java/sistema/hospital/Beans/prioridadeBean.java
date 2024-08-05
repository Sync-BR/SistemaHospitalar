package sistema.hospital.Beans;

/**
 *
 * @author sync
 */
public class prioridadeBean {

    public String Prioridade;

    public String viwerName(String event) {
        this.Prioridade = event;
        return Prioridade;
    }

    public String getPrioridade() {
        return Prioridade;
    }

    public void setPrioridade(String Prioridade) {
        this.Prioridade = viwerName(Prioridade);
    }

}
