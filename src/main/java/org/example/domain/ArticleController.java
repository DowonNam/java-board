package org.example.domain;

import org.example.base.CommonUtil;

import java.util.ArrayList;
import java.util.Scanner;
//Model - Controller - View

public class ArticleController { // Model + Controller 혼재
    ArticleView articleView = new ArticleView();
    CommonUtil commonUtil = new CommonUtil();
    ArticleRepository articleRepository = new ArticleRepository();
    Scanner scan = commonUtil.getScan();
    int WRONG_VALUE = -1;


    public void search() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String InputKey = scan.nextLine();
        ArrayList<Article> searchList = articleRepository.findArticleByKeyword(InputKey);

        articleView.printArticleList(searchList);
    }

    public void detail() {
        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");

        int indexNum = getParamAsInt(scan.nextLine(), WRONG_VALUE);
        if (indexNum == WRONG_VALUE) {
            return;
        }

        Article article = articleRepository.findArticleById(indexNum);

        if (article == null) {
            System.out.println("존재하지 않는 게시물 번호입니다.");
            return;
        }
        article.increaseHit();

        //조회수 증가
        //article.setHit(article.getHit()+1); // 기존의 조회수 가져와서 1을 증가

        article.increaseHit(); // 뒤에서 만든 함수를 받아 조회수 증가
        articleView.PrintArticleDetail(article);

        boolean loop = true;
        while (loop) {
            System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
            int act = Integer.parseInt(scan.nextLine());
            switch (act) {
                case 1:
                    Comment commentIn = new Comment();
                    articleView.showAddComment();
                    System.out.print("댓글 내용 : ");
                    String commentInput = scan.nextLine();
                    articleView.PrintArticleComment(commentIn.getComment(commentInput));

                    System.out.println("댓글이 성공적으로 등록되었습니다.");

                    break;
                case 2:
                    articleView.showRecommend();
                    break;
                case 3:
                    articleView.showEdit();
                    break;
                case 4:
                    articleView.showDelete();
                    break;
                case 5:
                    articleView.showList();
                    System.out.println("상세보기 화면을 빠져나갑니다.");
                    loop = false;
                    break;
                default:
                    System.out.println("다시 선택해주세요");
                    break;
            }
        }
    }

    public void delete() {

        System.out.print("삭제할 게시물 번호 : ");
        int indexNum = getParamAsInt(scan.nextLine(), WRONG_VALUE);
        // 에러가 나면 -1으로 반환한다

        if (indexNum == WRONG_VALUE) {
            return;
        }
        // if indexNum이 0 인 경우 에러가 난 것(바로 위 상단 때문에)
        // 이기 때문에 리턴하면 된다

        Article article = articleRepository.findArticleById(indexNum);

        if (article == null) {
            System.out.println("없는 게시물입니다.");
            return;
        }

        articleRepository.deleteArticle(article);
        System.out.println(indexNum + "번째 게시물이 삭제 되었습니다.");
    }

    public void update() {
        System.out.print("수정할 게시물 번호 : ");
        int indexNum = getParamAsInt(scan.nextLine(), WRONG_VALUE);

        if (indexNum == WRONG_VALUE) {
            return;
        }
        //int indexNum = scan. nextInt();
        //scan.nextLine; 찌꺼기 없애주는 단계 > 무조건 필요하다
        // 두 줄을 상단 한 줄로 함축 가능하다

        Article article = articleRepository.findArticleById(indexNum);
        if (article == null) {
            System.out.println("없는 게시물입니다.");
            return; // 함수종료(update 함수로 변경하면서 continue > return 으로 변경)
        }

        System.out.print("새로운 제목을 입력해주세요 : ");
        String newTitle = scan.nextLine();

        System.out.print("새로운 내용을 입력해주세요 : ");
        String newBody = scan.nextLine();


        articleRepository.updateArticle(article, newTitle, newBody);
        System.out.println(indexNum + "번 게시물이 수정되었습니다.");
    }

    public void list() {
        ArrayList<Article> articleList = articleRepository.findall();
        articleView.printArticleList(articleList); // 전체 출력 → 전체 저장소
    }

    public void add() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();

        System.out.print("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();

        articleRepository.saveArticle(title, body);

        System.out.println("게시물이 등록되었습니다.");
    }

    private int getParamAsInt(String param, int defaultValue) {
        try {
            return Integer.parseInt(param); // 문자를 숫자로 바꿔서 내보낸다
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해야합니다.");
            return defaultValue;
            // 사실상 매개변수가 숫자가 아니기 때문에
            // defaultValue 값을 선언하여,
            // 실패할 경우 int로 return 값을 준다
        }

    }


}
