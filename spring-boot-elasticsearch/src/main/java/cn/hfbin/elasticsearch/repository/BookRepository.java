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
    //具体写法参考官方的
    //https://docs.spring.io/spring-data/elasticsearch/docs/3.0.7.RELEASE/reference/html/#elasticsearch.misc.filter

    public List<Book> findBooksByBookContent(String string);

    public List<Book> findBooksByBookContentLike(String string);
}
