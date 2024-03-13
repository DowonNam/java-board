package org.example;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class boardAppNew {
    ArrayList<Article> articleList = new ArrayList<>(); // 인스턴스 변수
    public void run() {
        Scanner scan = new Scanner(System.in);

        // 시작 번호를 1로 지정한다.
        int latestArticleId = 1;

        while(true){

            System.out.print("명령어 : ");
            String word = scan.nextLine();

            if(word.equals("exit")){ // 숫자가 아닌 경우 같다라는 표현을 할 때 == 이 아닌, equals()를 사용
                System.out.println("프로그램을 종료합니다.");
                break; // 반복문 탈출
            }
            else if(word.equals("add")){

                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();

                System.out.print("게시물 내용을 입력해주세요 : ");
                String body = scan.nextLine();

                // 날짜, 시간 가져오는 방법
                //1. 현재 날짜와 시간을 가져옵니다.
                LocalDateTime now = LocalDateTime.now();

                //2. 날짜와 시간의 형식을 지정합니다. 여기서는 연-월-일 시:분:초 형식을 사용합니다.
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

                //3. 지정한 형식으로 날짜와 시간을 출력합니다.
                String formattedDate = now.format(formatter);
                Article article = new Article(latestArticleId, title, body, formattedDate); //생성자 이용

                articleList.add(article);
                System.out.println("게시물이 등록되었습니다.");

                latestArticleId++; // 게시물이 생성 될때마다 번호를 증가

            } else if(word.equals("list")){
                System.out.println("==================");
                for(int i = 0; i < articleList.size(); i++){
                    Article article = articleList.get(i);

                    System.out.println("번호 : " + article.getId());
                    System.out.println("제목 : " + article.getTitle());
                    System.out.println("내용 : " + article.getBody());
                    System.out.println("등록날짜 : " + article.getRegDate());
                    System.out.println("==================");
                }
            }
            else if(word.equals("update")){
                System.out.print("수정할 게시물 번호 : ");
                int indexNum = Integer.parseInt(scan.nextLine());

                    System.out.print("새로운 제목을 입력해주세요 : ");
                    String newTitle = scan.nextLine();

                    System.out.print("새로운 내용을 입력해주세요 : ");
                    String newBody = scan.nextLine();

                    int index   = findIndexById(indexNum);
                    Article target = articleList.get(index);
                    target.setTitle(newTitle);
                    target.setBody(newBody);

                    System.out.println(indexNum + "번 게시물이 수정되었습니다.");
            }
            else if(word.equals("delete")){
                System.out.print("삭제할 게시물 번호 : ");
                int indexNum = Integer.parseInt(scan.nextLine());

                int index = findIndexById(indexNum);
                articleList.remove(index);
                System.out.println(indexNum + "번째 게시물이 삭제 되었습니다.");

            }
        }
    }
    public int findIndexById(int id){
        int index = -1;
        for(int i = 0; i < articleList.size(); i++){
            Article article = articleList.get(i);

            if(article.getId() == id){
                index = i;
            }
        }
        return index;
    }
}

