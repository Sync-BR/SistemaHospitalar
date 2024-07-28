package sistema.hospital.Beans;

import java.awt.Event;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

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

    public static Map<String, String> especialistas = new HashMap<>();

    public void viwerName(String event) {
        this.especialista = event;
    }

    static {
        getEspecialistas().put("1", "Cardiologista");
        getEspecialistas().put("2", "Pediatra");
        getEspecialistas().put("3", "Ortopedista");
        getEspecialistas().put("4", "Ginecologista");
        getEspecialistas().put("5", "Neurologista");
        getEspecialistas().put("6", "Dermatologista");
        getEspecialistas().put("7", "Oncologista");
        getEspecialistas().put("8", "Endocrinologista");
        getEspecialistas().put("9", "Psiquiatra");
        getEspecialistas().put("10", "Oftalmologista");
        getEspecialistas().put("11", "Urologista");
        getEspecialistas().put("12", "Otorrinolaringologista");
        getEspecialistas().put("13", "Reumatologista");
        getEspecialistas().put("14", "Nefrologista");
        getEspecialistas().put("15", "Hematologista");
        getEspecialistas().put("16", "Infectologista");
        getEspecialistas().put("17", "Pneumologista");
        getEspecialistas().put("18", "Gastroenterologista");
        getEspecialistas().put("19", "Cirurgião Geral");
        getEspecialistas().put("20", "Radiologista");
    }

    public String getEspecialista() {

        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;

    }

    public static Map<String, String> getEspecialistas() {
        return especialistas;
    }

    public static void setEspecialistas(Map<String, String> aEspecialistas) {
        especialistas = aEspecialistas;
    }

    public static void main(String[] args) {
        especialidadeBean add = new especialidadeBean();
        add.setEspecialista("1");
        System.out.println(especialistas);
    }

}
