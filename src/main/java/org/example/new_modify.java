package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class new_modify {
    public void run() {
        Scanner scan = new Scanner(System.in);

        ArrayList<String>titleList  = new ArrayList<>();
        ArrayList<String>bodyList  = new ArrayList<>();

        String title = "";
        String body = "";

        while(true){
        System.out.printf("명령어 : ");
        String word = scan.nextLine();

        if(word.equals("exit")){
            System.out.println("프로그램을 종료합니다.");
            break;
            }

        else if(word.equals("add")){
            System.out.print("게시물 제목을 입력해주세요 : ");
            String title = scan.nextLine();
            titleList.add(title);

            System.out.print("게시물 내용을 입력해주세요 : ");
            String body = scan.nextLine();
            bodyList.add(body);

            System.out.println("게시물이 등록되었습니다.");
        }

        else if(word.equals("list")){
            System.out.println("==================");
            for (int i = 0; i < titleList.size(); i++){
                System.out.println("제목 : " + titleList.get(i));
                System.out.println("내용 : " + bodyList.get(i));
                System.out.println("==================");
            }
        }
        else if(word.equals("update")){
            System.out.println("수정할 게시물 번호 : ");
            int indexNum = scan.nextInt();
            if(indexNum !=  )
        }
        }
    }
}
