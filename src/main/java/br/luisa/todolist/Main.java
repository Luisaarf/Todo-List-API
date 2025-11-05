package br.luisa.todolist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                case 1 -> registerNewTask(sc);
                case 2 -> showOpenTasks();
                case 3 -> searchTaskByTitle();
                case 4 -> markTaskAsConcluded();
                case 5 -> deleteTask();
                case 0 -> close = true;
            }
        }
    }

    public static void registerNewTask(Scanner scanner){
        System.out.println("Digite o nome do tarefa:");
        LocalDate deadline = LocalDate.parse(scanner.nextLine()); //yyyy-MM-dd
    }

    public static void showOpenTasks(){
        System.out.println("Mostrando as tarefas");
    }

    public static void searchTaskByTitle(){
        System.out.println("Digite o nome do tarefa desejada:");
    }

    public static void markTaskAsConcluded(){
        System.out.println("Digite o ID da tarefa desejada:");
    }

    public static void deleteTask(){
        System.out.println("Digite o ID da tarefa desejada para deletar:");
    }
}