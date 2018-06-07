package cn.hfbin.elasticsearch.bean;


import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by: HuangFuBin
 * Date: 2018/6/7
 * Time: 16:48
 * Such description:
 */
@Document(indexName = "hfbin" , type = "book")
public class Book {

    private Integer id;

    private String bookName;

    private String bookContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookContent='" + bookContent + '\'' +
                '}';
    }
}
