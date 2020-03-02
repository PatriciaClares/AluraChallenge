package br.com.AluraChallenge.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataUtil {
    public static LocalDateTime parse(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return  LocalDateTime.parse(data, formatter);
    }
}
