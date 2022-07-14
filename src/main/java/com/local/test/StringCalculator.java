package com.local.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static void main(String[] args) {
        final String sourceStr = "3(a2(c))3(a)2(bc)";
        System.out.println(stringCalculateByRecursion(sourceStr));
        System.out.println(stringCalculateByLoop(sourceStr));
    }

    public static String stringCalculateByRecursion(String str) {
        final StringBuffer result = new StringBuffer();
        calculator(str, result);
        return result.toString();
    }

    private static void calculator(String str, StringBuffer result) {
        if (str != null && !str.equals("")) {
            final int endTagIndex = getEndTagIndex(str);
            final String contentStr = str.substring(0, endTagIndex + 1);

            final StringBuffer childResult = new StringBuffer();
            calculatorChild(childResult, contentStr);
            result.append(childResult);

            // Next string
            str = str.substring(endTagIndex + 1);
            if (str.equals("")) {
                return;
            } else {
                calculator(str, result);
            }
        }
    }

    public static void calculatorChild(StringBuffer result, String str) {
        final String startStr = str.substring(0, 1);
        final int endTagIndex = getEndTagIndex(str);

        if (!isNumber(startStr)) {
            result.append(startStr);
            final String contentStr = str.substring(1);

            calculatorChild(result, contentStr);
        } else {
            final String contentStr = str.substring(str.indexOf("(") + 1, endTagIndex);
            if (contentStr.contains("(") && contentStr.contains(")")) {
                calculatorChild(result, contentStr);
                final String childResult = result.toString();
                int num = Integer.parseInt(startStr);
                for (int i = 0; i < num - 1; i++) {
                    result.append(childResult);
                }
            } else {
                int num = Integer.parseInt(startStr);
                for (int i = 0; i < num; i++) {
                    result.append(contentStr);
                }
            }
        }
    }

    public static String stringCalculateByLoop(String str) {
        final StringBuffer result = new StringBuffer();

        while (str != null && !str.equals("")) {
            int endTagIndex = getEndTagIndex(str);
            String contentStr = str.substring(0, endTagIndex + 1);

            final StringBuffer childResult = new StringBuffer();

            String startStr = str.substring(0, 1);
            endTagIndex = getEndTagIndex(contentStr);


            contentStr = str.substring(str.indexOf("(") + 1, endTagIndex);
            if (contentStr.contains("(") && contentStr.contains(")")) {
                final StringBuffer secondChildResult = new StringBuffer();

                final String charStr = contentStr.substring(0, 1);
                String childContent = contentStr;

                final String childStartStr = childContent.substring(1, 2);
                childContent = childContent.substring(1);
                String childContentStr = childContent.substring(childContent.indexOf("(") + 1, childContent.indexOf(")"));

                for (int i = 0; i < Integer.parseInt(startStr); i++) {
                    secondChildResult.append(charStr);

                    for (int j = 0; j < Integer.parseInt(childStartStr); j++) {
                        secondChildResult.append(childContentStr);
                    }
                }
                childResult.append(secondChildResult);

            } else {
                int num = Integer.parseInt(startStr);
                for (int i = 0; i < num; i++) {
                    childResult.append(contentStr);
                }
            }

            result.append(childResult);

            // Next string
            str = str.substring(endTagIndex + 1);
            if (str.equals("")) {
                break;
            }
        }

        return result.toString();
    }

    private static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+(\\\\.[0-9]+)?");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }

    private static int getEndTagIndex(String str) {
        int endTagIndex = str.indexOf(")");
        for (int j = endTagIndex + 1; j < str.length(); j++) {
            if (str.substring(j, j + 1).contains(")")) {
                endTagIndex++;
            } else {
                break;
            }
        }
        return endTagIndex;
    }
}
