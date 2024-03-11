package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 반복문 안에 선언을 하면 결국 다시 0 이 되기 때문에 의미가 없어진다.

        // 변수에는 하나의 값만 저장 가능하므로 여러개의 게시물을 저장하려면 ArrayList를 사용하다.

        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<String> textList = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();

        // 반복 횟수 정할 수 없음 → 무한 반복 구조
        while (true) { // 반복 조건이 true 이기 때문에 무한 반복
            System.out.print("명령어 : ");
            String cmd = scan.nextLine();

            if(cmd.equals("add")){
                System.out.print("게시물 제목을 입력해주세요 :");
                String title = scan.nextLine();
                titleList.add(title);

                System.out.print("게시물 내용을 입력해주세요 :");
                String text = scan.nextLine();
                textList.add(text);

                int newNum = numList.size() + 1;
                numList.add(newNum);

                System.out.print("게시물이 등록되었습니다.\n");
            }
            else if(cmd.equals("list")){
                System.out.println("=================");
                for(int i = 0; i < titleList.size(); i++){
                    int num = numList.get(i);
                    System.out.println("번호 : " + num);
                    String title = titleList.get(i);
                    System.out.printf("제목 : %s", title + "\n");
                    System.out.println("=================");
                    String text = textList.get(i);
                }
                System.out.println("=================");
            }
            else if(cmd.equals("update")) {
                System.out.printf("수정할 게시물 번호 : ");
                int Upnum = scan.nextInt();
                scan.nextLine();

                if ( Upnum > 0 && Upnum <= titleList.size() ){
                    System.out.printf("수정할 게시물 제목 : ");
                    String UpTitle = scan.nextLine();
                    titleList.set(Upnum -1, UpTitle);
                    System.out.printf("수정할 게시물 내용 : ");
                    String UpText = scan.nextLine();
                    textList.set(Upnum -1, UpText);
                    System.out.println("게시물이 수정되었습니다.");

                } else {
                    System.out.println("유효하지 않은 게시물 번호입니다.");
                }
            }
            else if(cmd.equals("delete")) {
                System.out.printf("삭제할 게시물 번호 : ");
                int Delnum = scan.nextInt();
                scan.nextLine();

                if ( Delnum > 0 && Delnum <= titleList.size() ){
                    titleList.remove(Delnum-1);
                    textList.remove(Delnum -1);
                    numList.remove(Delnum -1);
                    System.out.println(Delnum + "번 게시물이 삭제되었습니다.");
                } else {
                    System.out.println("유효하지 않은 게시물 번호입니다.");
                }
            }
            else if(cmd.equals("detail")){
                System.out.printf("상세보기 할 게시물 번호를 입력해주세요 : ");
                int Denum = scan.nextInt();
                scan.nextLine();

                if ( Denum > 0 && Denum <= titleList.size() ){
                    System.out.println("=================");
                    System.out.println("번호 : " + Denum);
                    System.out.println("제목 : " + titleList.get(Denum-1));
                    System.out.println("내용 : " + textList.get(Denum-1));
                    System.out.println("=================");
                } else {
                    System.out.println("존재하지 않은 게시물 번호입니다.");
                }
            }
            else if(cmd.equals("exit")){ // 숫자가 아닌 경우 같다라는 표현을 할 때 == 이 아닌, equals() 라는 함수를 사용해야한다.
                break; // 반복문 탈출
            }
        }

    }
}
