package org.example.domain;

import org.example.base.CommonUtil;

import java.util.ArrayList;

public class ArticleRepository {

    ArrayList<Article> articleList = new ArrayList<>(); // 인스턴스 변수
    CommonUtil commonUtil = new CommonUtil();
    int latestArticleId = 4;

    public ArticleRepository(){
        makeTestData(); // 시작과 동시에 테스트 데이터 생성
    }

    public void makeTestData() {
        Article a1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "냉무", 0, commonUtil.getCurrentDateTime());
        Article a2 = new Article(2, "자바 질문좀 할게요~", "냉무", 0, commonUtil.getCurrentDateTime());
        Article a3 = new Article(3, "정처기 따야되나요?", "냉무", 0, commonUtil.getCurrentDateTime());
        articleList.add(a1);
        articleList.add(a2);
        articleList.add(a3);
    }

    public ArrayList<Article> findArticleByKeyword(String InputKey){
        ArrayList<Article> searchList = new ArrayList<>();

        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            if (articleList.get(i).getTitle().contains(InputKey)) {
                searchList.add(article);
            }
        }

        return searchList;
    }
    public Article findArticleById(int id) {
        int index = -1;
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);

            // 리턴 값으로 변경
            if (article.getId() == id) {
                return article;
            }
        }
        // 찾은 게 없다면 null 리턴하라(없다고 리턴하라), 객체 타입에서만 사용 가능
        return null;
    }
    public void deleteArticle(Article article){
        articleList.remove(article); // arraylist 값은 값을 직접 찾아서 지워주기도 한다
    }
    public void updateArticle(Article article, String newTitle, String newBody){
        article.setTitle(newTitle);
        article.setBody(newBody);
    }
    public ArrayList<Article> findall(){
        return  articleList;
    }
    public Article saveArticle(String title, String body){

        Article article = new Article(latestArticleId, title, body, 0, commonUtil.getCurrentDateTime()); //생성자 이용
        articleList.add(article);
        latestArticleId++; // 게시물이 생성 될때마다 번호를 증가

        return article;
    }
}
