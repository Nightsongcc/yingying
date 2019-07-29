package com.example.yingying.news;

public class News {
    private String newstitle;
    private String newsdate;
    private String newsurl;
    private String newspic1;
    private String newspic2;
    private String newspic3;

    public News(String newstitle,
                String newsdate,
                String newsurl,
                String newspic1,
                String newspic2,
                String newspic3) {
        this.newsdate = newsdate;
        this.newspic1 = newspic1;
        this.newspic2 = newspic2;
        this.newspic3 = newspic3;
        this.newstitle = newstitle;
        this.newsurl = newsurl;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public String getNewsdate() {
        return newsdate;
    }

    public String getNewsurl() {
        return newsurl;
    }

    public String getNewspic1() {
        return newspic1;
    }

    public String getNewspic2() {
        return newspic2;
    }

    public String getNewspic3() {
        return newspic3;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public void setNewsdate(String newsdate) {
        this.newsdate = newsdate;
    }

    public void setNewsurl(String newsurl) {
        this.newsurl = newsurl;
    }

    public void setNewspic1(String newspic1) {
        this.newspic1 = newspic1;
    }

    public void setNewspic2(String newspic2) {
        this.newspic2 = newspic2;
    }

    public void setNewspic3(String newspic3) {
        this.newspic3 = newspic3;
    }
}
