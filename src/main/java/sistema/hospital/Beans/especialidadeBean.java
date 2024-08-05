package sistema.hospital.Beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author SYNC
 */
@ManagedBean(name = "especialistaBean")
@ViewScoped
public class especialidadeBean {

    public especialidadeBean(String especialista) {
        this.especialista = especialista;
    }

    public especialidadeBean() {
    }

    public String especialista;

    public void viwerName(String event) {
        this.especialista = event;
    }

    public String getEspecialista() {

        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;

    }

}
