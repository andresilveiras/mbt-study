package com.filemanager;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

import com.filemanager.impl.FileManagerImpl;

public class FileManagerMain {

    public static void executeFileManagerTests() throws IOException {
        System.out.println("=".repeat(50));
        System.out.println(" Iniciando testes do File Manager ");
        System.out.println("=".repeat(50));

        // Captura tempo de início
        LocalDateTime startTime = LocalDateTime.now();
        long startMillis = System.currentTimeMillis();
        
        // Executa os testes
        Executor executor = new TestExecutor(FileManagerImpl.class);
        Result result = executor.execute(true);
        
        // Captura tempo de fim
        LocalDateTime endTime = LocalDateTime.now();
        long endMillis = System.currentTimeMillis();

        // Exibe relatório completo
        displayReport(result, startTime, endTime, startMillis, endMillis);
        
    }

    private static void displayReport(Result result, LocalDateTime startTime, LocalDateTime endTime, long startMillis, long endMillis) {
        if (result.hasErrors()) {
            System.out.println("\nErros encontrados:");
            for (String error : result.getErrors()) {
                System.out.println("  - " + error);
            }
        } 
        System.out.println("\n" + "=".repeat(50));
        System.out.println("      RESULTADO DA EXECUÇÃO:");
        System.out.println("=".repeat(50));
        System.out.println(result.getResultsAsString());
        System.out.println("-".repeat(50));
        System.out.println("Início:  " + formatDateTime(startTime));
        System.out.println("Fim:     " + formatDateTime(endTime));
        System.out.println("Duração: " + calculateDuration(startMillis, endMillis));
        System.out.println("=".repeat(50));
    }

    private static String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    private static String calculateDuration(long startMillis, long endMillis) {
        long durationMillis = endMillis - startMillis;
        Duration duration = Duration.ofMillis(durationMillis);
        
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;
        long millis = durationMillis % 1000;
        
        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, millis);
    }

}