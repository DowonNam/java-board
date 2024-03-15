package org.example.domain;

public class Article {
    // Article 은 게시물
    // 게시물에 추가 되는 것은 Article에넣으면 됨
    private int id; // 번호
    private String title; // 제목
    private String body; // 내용
    private int hit; // 조회수
    private String regDate; // 등록날짜


    public Article(int id, String title, String body, int hit, String regDate){
        this.id = id;
        this.title = title;
        this.body = body;
        this.hit = hit;
        this.regDate = regDate;
    }

    public void increaseHit(){
        this.hit++;
    }

    public int getHit(){
        return hit;
    }

    public void setHit(int hit){
        this.hit = hit;
    }

    public String getRegDate(){
        return regDate;
    }
    public void setRegDate(String regDate){
        this.regDate = regDate;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getBody(){
        return body;
    }
    public void setBody(String body){
        this.body = body;
    }
}
class Comment {
    private String Inpucommment; // 댓글
    public Comment(String Inpucommment){
        this.Inpucommment = Inpucommment;
    }

    public String getComment() {
        return Inpucommment;
    }

    public void setComment(String Comment) {
        this.Inpucommment = Comment;
    }

}