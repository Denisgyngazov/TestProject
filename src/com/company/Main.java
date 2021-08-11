package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FilterWordsInText filterWordsInText = new FilterWordsInText();
        List<String> resultList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        String resultFileName = "result.txt";
        Path result = Paths.get(resultFileName);

        try {
            System.out.println("Файлы должны находится в корне проекта!");
            System.out.println("Введите название текст файла:");
            String scannerTextFile = scanner.nextLine();
            String text = Files.readString(Path.of(scannerTextFile));
            System.out.println("--------------------------------------");
            System.out.println("Введите название шаблон файла:");
            String scannerTemplateFile = scanner.nextLine();
            String templates = Files.readString(Path.of(scannerTemplateFile));
            System.out.println("--------------------------------------");
            System.out.println("Результат работы программы записан в файл result");
            String[] newTemplates = templates.split("\n");

            for (String newTemplate : newTemplates) {
                int count = 0;
                int resultFilter = filterWordsInText.filterContainsLetterAndNumber(text, newTemplate, count);

                String stringCount = Integer.toString(resultFilter);
                resultList.add(newTemplate);
                resultList.add(stringCount);
                Files.write(result, resultList);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
