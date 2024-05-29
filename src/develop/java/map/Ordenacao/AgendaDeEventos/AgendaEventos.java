package develop.java.map.Ordenacao.AgendaDeEventos;

import java.time.LocalDate;
import java.util.*;

public class AgendaEventos {

    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        eventoMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosPorDataAscendente = new TreeMap<>(eventoMap);
        System.out.println(eventosPorDataAscendente);
    }

    public void obterProximoEvento(){
        Map<LocalDate, Evento> eventosPorDataAscendente = new TreeMap<>(eventoMap);
        LocalDate hoje = LocalDate.now();
        for (Map.Entry<LocalDate, Evento> entry : eventosPorDataAscendente.entrySet()){
            if (entry.getKey().isEqual(hoje) || entry.getKey().isAfter(hoje)){
                System.out.println("Proximo evento: " + entry.getValue() + " na data de: " + entry.getKey());
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();


        agendaEventos.exibirAgenda();

        agendaEventos.adicionarEvento(LocalDate.of(2024, 1, 1), "Evento 1", "Atracao 1");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 5, 30), "Evento 4", "Atracao 4");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 5, 29), "Evento 3", "Atracao 3");
        agendaEventos.adicionarEvento(LocalDate.of(2024, 5, 20), "Evento 2", "Atracao 2");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();


    }

}