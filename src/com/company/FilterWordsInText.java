package com.company;

public final class FilterWordsInText {

    public FilterWordsInText() {

    }

    public int filterContainsLetterAndNumber(String text, String template,int count) {
        if (template.length() == 2 && !template.startsWith("\"")) {
            String charTemplate = template.substring(0, 1);
            int countTemplate = Integer.parseInt(template.substring(1));
            for (String word : text.split(" ")) {
                if (word.toLowerCase().split(charTemplate.toLowerCase()).length - 1 == countTemplate) {
                    count++;
                }
            }
        } else if (template.length() >= 3 && !template.startsWith("\"")) {
            String charTemplate = template.substring(0, 1);
            String charTemplateTwo = template.substring(2, 3);
            int countTemplate = Integer.parseInt(template.substring(1, 2));
            int countTemplateTwo = Integer.parseInt(template.substring(3, 4));
            for (String word : text.split(" ")) {
                if (word.toLowerCase().split(charTemplate.toLowerCase()).length - 1 == countTemplate
                        && word.toLowerCase().split(charTemplateTwo.toLowerCase()).length - 1 == countTemplateTwo) {
                    count++;
                }
            }
        } else if (template.startsWith("\"")) {
            String charTemplate = template.substring(1, 3);
            for (String word : text.split(" ")) {
                if (word.toLowerCase().contains(charTemplate.toLowerCase())) {
                    count++;
                }
            }
        }
        return count;
    }
}
