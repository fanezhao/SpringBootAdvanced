package com.zfspace.search.springbootwithelastic;

import com.zfspace.search.bean.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootwithelasticApplicationTests {

    @Autowired
    JestClient jestClient;

    /**
     * 测试索引
     */
    @Test
    public void contextLoads() {

        Article article = new Article();
        article.setId(1);
        article.setTitle("good news");
        article.setContent("hello world");
        article.setAuthor("fanezhao");

        // 构建一个索引
        Index index = new Index.Builder(article).index("zfspace").type("blog").build();
        try {
            // 执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试检索
     */
    @Test
    public void search() {
        // 表达式
        String q = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(q).addIndex("zfspace").addType("blog").build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
