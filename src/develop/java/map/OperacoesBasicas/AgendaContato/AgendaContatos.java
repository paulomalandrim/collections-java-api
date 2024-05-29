package develop.java.map.OperacoesBasicas.AgendaContato;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {

    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        agendaContatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        agendaContatoMap.remove(nome);
    }

    public void exibirContatos(){
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome){
        return agendaContatoMap.get(nome);
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Pessoa 1", 111222333);
        agendaContatos.adicionarContato("Pessoa 1", 222); // esse aqui sobrescreve o anterior
        agendaContatos.adicionarContato("Pessoa 2", 333);
        agendaContatos.adicionarContato("Pessoa 3", 444);
        agendaContatos.adicionarContato("Pessoa 4", 555);

        agendaContatos.exibirContatos();

        agendaContatos.removerContato("Pessoa 1");

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Pessoa 4"));
    }
}
