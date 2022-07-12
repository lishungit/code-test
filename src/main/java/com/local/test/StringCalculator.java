package com.local.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static void main(String[] args) {
        final String sourceStr = "3(a2(c))3(a)2(bc)";
        final String sourceStr2 = "3(ac)";
        final String sourceStr3 = "3(a2(c))";
        final StringBuffer result = new StringBuffer();
        calculator1(result, sourceStr);
        System.out.println(result);
    }

    public static void calculator1(StringBuffer result, String str) {
        String startStr = str.substring(0, 1);
        String contentStr;

        int endTagIndex = str.indexOf(")");
        for (int j = endTagIndex + 1; j < str.length(); j++) {
            if (str.substring(j, j + 1).contains(")")) {
                endTagIndex++;
                break;
            }
        }

        if (!isNumber(startStr)) {
            result.append(startStr);
            contentStr = str.substring(1);

            calculator1(result, contentStr);
        } else {
            contentStr = str.substring(str.indexOf("(") + 1, endTagIndex);
            if (contentStr.contains("(")) {
                calculator1(result, contentStr);
                String childResult = result.toString();
                int num = Integer.parseInt(startStr);
                for (int i = 0; i < num-1; i++) {
                    result.append(childResult);
                }
            } else {
                int num = Integer.parseInt(startStr);
                for (int i = 0; i < num; i++) {
                    result.append(contentStr);
                }
            }
        }

        // Next string
        String nextString = str.substring(endTagIndex+1);
        if (!nextString.equals("")){
            calculator1(result, nextString);
        }
    }

    public static String calculator2() {
        final StringBuffer result = new StringBuffer();

        return result.toString();
    }

    private static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+(\\\\.[0-9]+)?");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }
}
