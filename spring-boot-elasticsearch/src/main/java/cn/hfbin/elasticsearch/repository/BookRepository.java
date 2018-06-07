package cn.hfbin.elasticsearch.repository;

import cn.hfbin.elasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by: HuangFuBin
 * Date: 2018/6/7
 * Time: 18:54
 * Such description:
 */


public  interface BookRepository extends ElasticsearchRepository<Book , Integer> {

    public List<Book> findBooksByBookContent(String string);

    public List<Book> findBooksByBookContentLike(String string);
}
