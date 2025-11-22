package com;

import java.io.IOException;
import java.util.Scanner;

public class Main {
  
    /* 
     * ******************************************* 
     *              MAIN CLASS
     * ******************************************* 
     */

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    com.notepad.NotepadMain.executeNotepadTests();
                    break;
                case 2:
                    System.out.println("Testes do app Gallery não estão funcionais no momento.");
                    break;
                case 3:
                    com.filemanager.FileManagerMain.executeFileManagerTests();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            
            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n\n" + "=".repeat(50));
        System.out.println("      ORQUESTRADOR DE TESTES");
        System.out.println("=".repeat(50));
        System.out.println("1. Executar testes - Notepad");
        System.out.println("2. Executar testes - Gallery");
        System.out.println("3. Executar testes - File Manager");
        System.out.println("0. Sair");
        System.out.println("=".repeat(50));
    }
}