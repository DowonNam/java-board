package org.example;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class boardAppNew {
    ArrayList<Article> articleList = new ArrayList<>(); // 인스턴스 변수
    Scanner scan = new Scanner(System.in);
    int latestArticleId = 4;

    public void run() {

        makeTestData();

        while (true) {

            System.out.print("명령어 : ");
            String word = scan.nextLine();

            if (word.equals("exit")) { // 숫자가 아닌 경우 같다라는 표현을 할 때 == 이 아닌, equals()를 사용
                System.out.println("프로그램을 종료합니다.");
                break; // 반복문 탈출
            } else if (word.equals("add")) {
                add();
            } else if (word.equals("list")) {
                list();
            } else if (word.equals("update")) {
                update();
            } else if (word.equals("delete")) {
                delete();
            } else if (word.equals("detail")) {
                detail();
            } else if (word.equals("search")) {
                search();
            }
        }
    }

    private void makeTestData() {
        Article a1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "냉무", 0, getCurrentDateTime());
        Article a2 = new Article(2, "자바 질문좀 할게요~", "냉무", 0, getCurrentDateTime());
        Article a3 = new Article(3, "정처기 따야되나요?", "냉무", 0, getCurrentDateTime());
        articleList.add(a1);
        articleList.add(a2);
        articleList.add(a3);
    }

    private void search() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String InputKey = scan.nextLine();

        ArrayList<Article> searchList = new ArrayList<>();

        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            if (articleList.get(i).getTitle().contains(InputKey)) {
                searchList.add(article);
            }
        }
        printArticleList(searchList);
    }

    private void detail() {
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int indexNum = Integer.parseInt(scan.nextLine());

        int index = findIndexById(indexNum);

        if (index == -1) {
            System.out.println("존재하지 않는 게시물 번호입니다.");
            return;
        }
        Article article = articleList.get(index);

        //조회수 증가
        //article.setHit(article.getHit()+1); // 기존의 조회수 가져와서 1을 증가

        article.increaseHit(); // 뒤에서 만든 함수를 받아 조회수 증가

        System.out.println("======== " + article.getId() + "번 게시물 ==========");
        System.out.println("번호 : " + article.getId());
        System.out.println("제목 : " + article.getTitle());
        System.out.println("내용 : " + article.getBody());
        System.out.println("등록날짜 : " + article.getRegDate());
        System.out.println("조회수 : " + article.getHit());
        System.out.println("==========================");
        System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
        int act = Integer.parseInt(scan.nextLine());
        act(act);
    }

    private void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        int indexNum = Integer.parseInt(scan.nextLine());

        int index = findIndexById(indexNum);

        if (index == -1) {
            System.out.println("없는 게시물입니다.");
            return;
        }
        articleList.remove(index);
        System.out.println(indexNum + "번째 게시물이 삭제 되었습니다.");
    }

    private void update() {
        System.out.print("수정할 게시물 번호 : ");
        int indexNum = Integer.parseInt(scan.nextLine());
        //int indexNum = scan. nextInt();
        //scan.nextLine; 찌꺼기 없애주는 단계 > 무조건 필요하다
        // 두 줄을 상단 한 줄로 함축 가능하다

        int index = findIndexById(indexNum);
        if (index == -1) {
            System.out.println("없는 게시물입니다.");
            return; // 함수종료(update 함수로 변경하면서 continue > return 으로 변경)
        }

        System.out.print("새로운 제목을 입력해주세요 : ");
        String newTitle = scan.nextLine();

        System.out.print("새로운 내용을 입력해주세요 : ");
        String newBody = scan.nextLine();

        Article target = articleList.get(index);
        target.setTitle(newTitle);
        target.setBody(newBody);

        System.out.println(indexNum + "번 게시물이 수정되었습니다.");
    }

    private void list() {

        printArticleList(this.articleList); // 전체 출력 → 전체 저장소

    }

    private void add() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();

        System.out.print("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();

        Article article = new Article(latestArticleId, title, body, 0, getCurrentDateTime()); //생성자 이용

        articleList.add(article);
        System.out.println("게시물이 등록되었습니다.");

        latestArticleId++; // 게시물이 생성 될때마다 번호를 증가

    }

    // arrayList를 매개변수로 받는 방법 :
    public void printArticleList(ArrayList<Article> targetList) {
        for (int i = 0; i < targetList.size(); i++) {

            Article article = targetList.get(i);
            System.out.println("==================");
            System.out.println("번호 : " + article.getId());
            System.out.println("제목 : " + article.getTitle());
            System.out.println("내용 : " + article.getBody());
            System.out.println("조회수 : " + article.getHit());
            System.out.println("==================");
        }

    }

    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);

            if (article.getId() == id) {
                index = i;
            }
        }
        return index;
    }

    public String getCurrentDateTime() {
        //1. 현재 날짜와 시간을 가져옵니다.
        LocalDateTime now = LocalDateTime.now();

        //2. 날짜와 시간의 형식을 지정합니다. 여기서는 연-월-일 시:분:초 형식을 사용합니다.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

        //3. 지정한 형식으로 날짜와 시간을 출력합니다.
        String formattedDate = now.format(formatter);

        return formattedDate;
    }

    public int act(int n) {
        Scanner scan = new Scanner(System.in);
        if (n == 1) {
            System.out.println("[댓글 추가 가능");
        } else if (n == 2) {
            System.out.println("[추천기능]");
        } else if (n == 3) {
            System.out.println("[수정기능]");
        } else if (n == 4) {
            System.out.println("[삭제기능]");
        } else if (n == 5) {
            System.out.println("[목록으로]");
        }
        return n;
    }
}

