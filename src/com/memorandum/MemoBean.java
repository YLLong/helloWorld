package com.memorandum;

/**
 * Created by YLL on 2015/10/7.
 */
public class MemoBean {
    private int id;                 //备忘录编码
    private String username;        //备忘录用户名
    private String title;           //备忘录主题
    private String content;         //备忘录内容
    private String memotype;        //备忘录类型
    private String memotime;        //备忘录时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMemotype() {
        return memotype;
    }

    public void setMemotype(String memotype) {
        this.memotype = memotype;
    }

    public String getMemotime() {
        return memotime;
    }

    public void setMemotime(String memotime) {
        this.memotime = memotime;
    }
}
