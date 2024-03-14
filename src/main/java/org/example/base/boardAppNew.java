package org.example.base;

import org.example.domain.ArticleController;
import org.example.domain.ArticleRepository;

import java.util.Scanner;

public class boardAppNew {
    ArticleController articleController = new ArticleController();
    ArticleRepository articleRepository = new ArticleRepository();

    Scanner scan = new Scanner(System.in);


        // 값의 의미를 부여하기 위해 선언
        // -1 이라는 값은 에러가 나면 나오는 숫자라고 남들에게 알려주는 용도
        // 남들에게 알려주는 용도로도 변수를 사용할 수 있다

        public void run() {

        while (true) {

            System.out.print("명령어 : ");
            String word = scan.nextLine();

            if (word.equals("exit")) { // 숫자가 아닌 경우 같다라는 표현을 할 때 == 이 아닌, equals()를 사용
                System.out.println("프로그램을 종료합니다.");
                break; // 반복문 탈출
            }
            // else if 대신 switch 문으로 사용
            switch (word) {
                case "add" -> articleController.add();
                case "list" -> articleController.list();
                case "update" -> articleController.update();
                case "delete" -> articleController.delete();
                case "detail" -> articleController.detail();
                case "search" -> articleController.search();
                default -> System.out.println("올바른 명령어가 아닙니다.");
            }

        }
    }











}

