package cn.hfbin.elasticsearch;

import cn.hfbin.elasticsearch.bean.Book;
import cn.hfbin.elasticsearch.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootElasticsearchApplicationTests {

	/*@Autowired
	JestClient jestClient;

	@Test
	public void contextLoads() {
		Book book = new Book();
		book.setId(1);
		book.setBookName("spring boot");
		book.setBookContent("hello world spring boot elasticseach");

		//构建一个索引功能
		Index index = new Index.Builder(book).index("hfbin").type("book").build();

		try {
			//执行
			jestClient.execute(index);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void jestSearch(){
		String json = "{\n" +
				"    \"query\" : {\n" +
				"        \"match\" : {\n" +
				"            \"bookContent\" : \"world\"\n" +
				"        }\n" +
				"    }\n" +
				"}";

		Search build = new Search.Builder(json).addIndex("hfbin").addType("book").build();

		try {
			SearchResult execute = jestClient.execute(build);

			System.out.println(execute.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
*/

	@Autowired
    BookRepository bookRepository;

	@Test
    public void test(){
	    for (int i = 2 ; i<50 ; i++){
            Book book = new Book();
            book.setId(i);
            book.setBookName("javascript "+i);
            book.setBookContent("hello world javascript "+ i);

            bookRepository.index(book);
        }
    }

    @Test
    public void testSearch(){
        List<Book> hello = bookRepository.findBooksByBookContent("1");
        for (Book book : hello){
            System.out.println(book.toString());
        }

    }


    @Test
    public void testSearchLike(){
        List<Book> hello = bookRepository.findBooksByBookContentLike("1");
        for (Book book : hello){
            System.out.println(book.toString());
        }

    }


}
