package br.luisa.todolist;

import java.time.LocalDate;
import java.util.ArrayList;
import br.luisa.todolist.Task;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        boolean close = false;
        Scanner sc = new Scanner(System.in);
        while (!close){
            System.out.println("========Menu========");
            System.out.println("1. Cadastrar tarefa");
            System.out.println("2. Listar tarefas pendentes");
            System.out.println("3. Buscar tarefa por título");
            System.out.println("4. Marcar tarefa como concluída");
            System.out.println("5. Excluir tarefa");
            System.out.println("0. Sair");
            System.out.println("Digite uma opção pelo número:");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1 -> registerNewTask(sc, tasks);
                case 2 -> showOpenTasks(tasks);
                case 3 -> searchTaskByTitle(sc, tasks);
                case 4 -> markTaskAsConcluded(sc, tasks);
                case 5 -> deleteTask(sc, tasks);
                case 0 -> close = true;
            }
        }
    }

    public static void registerNewTask(Scanner scanner,  List<Task> tasks) {
        int id = tasks.size() + 1;
        System.out.println("Digite o nome do tarefa:");
        String title =  scanner.nextLine();
        System.out.println("Digite a descrição da tarefa:");
        String description =  scanner.nextLine();
        System.out.println("Digite a data da tarefa no formato yyyy-mm-dd:");
        LocalDate deadline = LocalDate.parse(scanner.nextLine()); //yyyy-MM-dd
        Task newTask = new Task(id, title, description, deadline);
        tasks.add(newTask);
        System.out.println("Nova tarefa adicionada! "+ newTask.getTitle());
    }

    public static void showOpenTasks(List<Task> tasks){
        System.out.println("Mostrando as tarefas");
        StringBuilder output = new StringBuilder();
        for (Task task : tasks){
            output.append(task.getId());
            output.append(" - ");
            output.append(task.getTitle());
            output.append("\n");
        }
        System.out.println(output);
    }

    public static void searchTaskByTitle(Scanner scanner,  List<Task> tasks){
        System.out.println("Digite o nome do tarefa desejada:");
        String search = scanner.nextLine();
        StringBuilder output = new StringBuilder();
        List<Task> filtered = tasks.stream()
                .filter(task -> task.getTitle().toLowerCase().contains(search.toLowerCase()))
                .toList();
        for (Task task : filtered){
            output.append(task.getId());
            output.append(" - ");
            output.append(task.getTitle());
            output.append("\n");
        }
        if (filtered.isEmpty()){
            System.out.println("Tarefa não encontrada");
        }else{
            System.out.println("Lista de Tarefas encontradas:");
            System.out.println(output);
        }
    }

    public static void markTaskAsConcluded(Scanner scanner,  List<Task> tasks){
        System.out.println("Digite o ID da tarefa desejada:");
        int id = scanner.nextInt();
        Task found = tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
        if (found == null){
            System.out.println("Tarefa não encontrada");
        }else{
            System.out.println("Tarefa marcada como concluída");
            found.setDone(true);
        }
    }

    public static void deleteTask(Scanner scanner,  List<Task> tasks){
        System.out.println("Digite o ID da tarefa desejada para deletar:");
    }
}

//import java.time.LocalDateTime;
//import java.time.Period;
//import java.time.Duration;
//import java.time.temporal.ChronoUnit;
//        Duration duration = Duration.ofHours(5);
//        LocalDateTime time = LocalDateTime.now();
//        LocalDate dataNascimento = LocalDate.of(2001,8,22);
//        Period period = Period.between(dataNascimento, LocalDate.now());
//        long chronoUnit = ChronoUnit.DAYS.between(dataNascimento,LocalDate.now() );
//        System.out.println(chronoUnit);
//        System.out.println(period.getYears());
//        System.out.println(time.plus(duration));