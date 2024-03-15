package org.example.domain;

import java.util.ArrayList;

public class ArticleView {
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
    public void PrintArticleDetail(Article article){
        System.out.println("======== " + article.getId() + "번 게시물 ==========");
        System.out.println("번호 : " + article.getId());
        System.out.println("제목 : " + article.getTitle());
        System.out.println("내용 : " + article.getBody());
        System.out.println("등록날짜 : " + article.getRegDate());
        System.out.println("조회수 : " + article.getHit());
        System.out.println("==========================");
    }

    public void PrintArticleComment(Article article, Comment comment){
        System.out.println("======== " + article.getId() + "번 게시물 ==========");
        System.out.println("번호 : " + article.getId());
        System.out.println("제목 : " + article.getTitle());
        System.out.println("내용 : " + article.getBody());
        System.out.println("등록날짜 : " + article.getRegDate());
        System.out.println("조회수 : " + article.getHit());
        System.out.println("==========================");
        System.out.println("======= 댓글 =======");
        System.out.println("댓글 내용 : " + comment.getComment());
//        System.out.println("댓글 작성일 : " + );
    }
    public void showAddComment(){
        System.out.println("[댓글 추가 기능]");}
    public void showRecommend(){
        System.out.println("[추천기능]");
    }
    public void showEdit(){
        System.out.println("[수정기능]");
    }
    public void showDelete(){
        System.out.println("[삭제기능]");
    }
    public void showList(){
        System.out.println("[목록으로]");
    }
}
