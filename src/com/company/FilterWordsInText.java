package com.company;

public final class FilterWordsInText {

    public FilterWordsInText() {

    }

    public int filterContainsLetterAndNumber(String text, String splitTemplate, int count) {
        if (splitTemplate.length() == 2 && !splitTemplate.startsWith("\"")) {
            String letterTemplate = splitTemplate.substring(0, 1);
            int countNumberTemplate = Integer.parseInt(splitTemplate.substring(1));
            for (String word : text.split(" ")) {
                if (word.toLowerCase().split(letterTemplate.toLowerCase()).length - 1 == countNumberTemplate) {
                    count++;
                }
            }
        } else if (splitTemplate.length() >= 3 && !splitTemplate.startsWith("\"")) {
            String letterTemplate = splitTemplate.substring(0, 1);
            String letterTemplateTwo = splitTemplate.substring(2, 3);
            int countNumberTemplate = Integer.parseInt(splitTemplate.substring(1, 2));
            int countNumberTemplateTwo = Integer.parseInt(splitTemplate.substring(3, 4));
            for (String word : text.split(" ")) {
                if (word.toLowerCase().split(letterTemplate.toLowerCase()).length - 1 == countNumberTemplate
                        && word.toLowerCase().split(letterTemplateTwo.toLowerCase()).length - 1 == countNumberTemplateTwo) {
                    count++;
                }
            }
        } else if (splitTemplate.startsWith("\"")) {
            String letterTemplate = splitTemplate.substring(1, 3);
            for (String word : text.split(" ")) {
                if (word.toLowerCase().contains(letterTemplate.toLowerCase())) {
                    count++;
                }
            }
        }
        return count;
    }
}
