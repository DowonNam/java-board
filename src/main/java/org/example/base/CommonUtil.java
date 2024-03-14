package org.example.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CommonUtil {
    private Scanner scan = new Scanner(System.in);

    public Scanner getScan(){
        return scan;
    }

    // 모든 곳에서 자주 사용되는 것은 여기에 모아두는 것이 좋다.
    public String getCurrentDateTime() {
        //1. 현재 날짜와 시간을 가져옵니다.
        LocalDateTime now = LocalDateTime.now();

        //2. 날짜와 시간의 형식을 지정합니다. 여기서는 연-월-일 시:분:초 형식을 사용합니다.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

        //3. 지정한 형식으로 날짜와 시간을 출력합니다.
        String formattedDate = now.format(formatter);

        return formattedDate;
    }
}
