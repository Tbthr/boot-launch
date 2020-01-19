package com.power.bootlaunch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data //成员变量的get和set方法、equals方法、canEqual方法、hashCode方法、toString方法
@AllArgsConstructor //全参构造函数
@NoArgsConstructor //无参构造函数
@Builder //对象属性赋值
public class Article {
    private String name;
    private String age;

    /**
     * id : 1
     * author : zimug
     * title : 手摸手教你开发spring boot
     * content : c
     * createTime :
     * reader : [{"name":"zimug","age":18},{"name":"kobe","age":37}]
     */

    private int id;
    private String author;
    private String title;
    private String content;
    private String createTime;
    private List<ReaderBean> reader;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<ReaderBean> getReader() {
        return reader;
    }

    public void setReader(List<ReaderBean> reader) {
        this.reader = reader;
    }

    public static class ReaderBean {
        /**
         * name : zimug
         * age : 18
         */

        private String nameX;
        private int ageX;

        public String getNameX() {
            return nameX;
        }

        public void setNameX(String nameX) {
            this.nameX = nameX;
        }

        public int getAgeX() {
            return ageX;
        }

        public void setAgeX(int ageX) {
            this.ageX = ageX;
        }
    }
}
