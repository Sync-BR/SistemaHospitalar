package sistema.hospital.init;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sistema.hospital.Beans.especialidadeBean;
import sistema.hospital.Beans.pacientesBean;
import sistema.hospital.Beans.prioridadeBean;
import sistema.hospital.Dao.ListaDao;

/**
 *
 * @author SYNC
 */
public class init {

    private static List<pacientesBean> pacientebens = new ArrayList<>();
    private static pacientesBean addPaciente = new pacientesBean();

    public init() {
        pacientebens = new ArrayList<>();
        addPaciente = new pacientesBean();
    }

    public static List<pacientesBean> carregarLista() throws Exception {
        List<pacientesBean> ListaBranca = new ArrayList<>();
        List<pacientesBean> ListaVermelha = new ArrayList<>();
        try {
            //Lista prioridades.
            List<pacientesBean> listPacientes = pacientebens;
            for (pacientesBean allPacientes : listPacientes) {
                String prioridade = allPacientes.getprioridade().getPrioridade();
                if (prioridade.equals("Vermelho")) {
                    ListaVermelha.add(allPacientes);
                } else if (prioridade.equals("Branco")) {
                    ListaBranca.add(allPacientes);
                }

            }
            //Imprimir prioridade
            System.out.println("Lista Vermelha");
            for (pacientesBean listarPrioridades : ListaVermelha) {
                for (int index = 0; index < 2; index++) {
                    System.out.println("Especialista: " + listarPrioridades.getEspecialista().getEspecialista());
                    System.out.println("Prioridade: " + listarPrioridades.getprioridade().getPrioridade());
                    break;
                }
                for (int index = 0; index < 1; index++) {
                    System.out.println("Lista Branca");
                    for (pacientesBean listarPrioridades2 : ListaBranca) {
                        System.out.println("Especialista: " + listarPrioridades2.getEspecialista().getEspecialista());
                        System.out.println("Prioridade: " + listarPrioridades2.getprioridade().getPrioridade());
                        break;
                    }
                }

            }

        } catch (Exception e) {
            e.getMessage();
        }
        return pacientebens;
    }

    public static void main(String[] args) throws Exception {

        List<especialidadeBean> addListEspecialista = new ArrayList<>();
        List<prioridadeBean> addListPrioridade = new ArrayList<>();
        ListaDao adicionarList = new ListaDao();

        Scanner entrada = new Scanner(System.in);
        boolean state = false;

        do {
            System.out.println("(1) Adicionar paciente.  (2) Listar pacientes(0) Sair");
            int resposta = entrada.nextInt();
            switch (resposta) {
                case 1:
                    pacientesBean paciente = new pacientesBean();
                    especialidadeBean addEspecialista = new especialidadeBean();
                    prioridadeBean addPrioridade = new prioridadeBean();
                    System.out.println("(1) Psicologo. (2) Clinico Geral.");
                    int especialista = entrada.nextInt();
                    switch (especialista) {
                        case 1:
                            addEspecialista.setEspecialista("Psicologo");
                            break;
                        case 2:
                            addEspecialista.setEspecialista("Clinico Geral");
                            break;
                        default:
                            System.out.println("Especialista invalido");
                            continue;
                    }
                    addListEspecialista.add(addEspecialista);
                    paciente.setEspecialista(addEspecialista);

                    System.out.println("(1) Prioridade vermelho. (2) Prioridade branco");
                    int prioridade = entrada.nextInt();
                    switch (prioridade) {
                        case 1:
                            addPrioridade.setPrioridade("Vermelho");
                            break;
                        case 2:
                            addPrioridade.setPrioridade("Branco");
                            break;
                        default:
                            System.out.println("Prioridade invalida.");
                            continue;
                    }
                    addListPrioridade.add(addPrioridade);
                    paciente.setPrioridade(addPrioridade);
                    pacientebens.add(paciente);

                    break;
                default:
                    throw new AssertionError();

                case 2:
                    System.out.println("Total de cadastros: " + pacientebens.size());
            //        adicionarList.CarregarListaPacientes(pacientebens);
                case 0:
                    state = true;
                    break;
            }

        } while (!state);

        System.out.println("Teste finalizado");

    }

}
