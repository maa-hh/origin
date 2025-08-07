package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.Domain.Emp;
import com.example.demo.Sever.sever;
import net.sf.jsqlparser.statement.create.index.CreateIndex;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.*;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.util.List;
//properties = {} 添加临时变量,args = {}，临时命令
@SpringBootTest(classes=DemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,properties = {},args = {})//添加模拟端口
//@Import(data.calss) 加载测试类专用的配置
@AutoConfigureMockMvc//模拟MVC
//@Transactional
//@Rollback(false)
class DemoApplicationTests {
    @Autowired
    sever sever;
    @Test
    public void test(@Autowired MockMvc mvc) throws Exception{
        //创建虚拟请求
        MockHttpServletRequestBuilder builde= MockMvcRequestBuilders.get("/books");
        //执行虚拟请求
        ResultActions action=mvc.perform(builde);
        //执行状态匹配器
        StatusResultMatchers status= MockMvcResultMatchers.status();
        //预期执行状态
        ResultMatcher ok=status.isOk();
        //真实执行状态与预期进行对比
        action.andExpect(ok);
        //执行结果匹配器
        ContentResultMatchers content=MockMvcResultMatchers.content();
        //预期结果
        ResultMatcher result=content.string("123456");
        //jason
        ResultMatcher r1=content.json("{}");
        //对比
        action.andExpect(result);
        //Header
        HeaderResultMatchers header=MockMvcResultMatchers.header();
        ResultMatcher h1=header.string("","");
        action.andExpect(h1);


    }


    @Test
    void testES() throws IOException {
        HttpHost ht=HttpHost.create("http://localhost:9200");
        RestClientBuilder re= RestClient.builder(ht);

        RestHighLevelClient rh=new RestHighLevelClient(re);

        CreateIndexRequest rq = new CreateIndexRequest("books");
        rq.mapping("{\n" +
                        "  \"properties\": {\n" +
                        "    \"title\": {\"type\": \"text\"},\n" +
                        "    \"author\": {\"type\": \"keyword\"},\n" +
                        "    \"publish_date\": {\"type\": \"date\"}\n" +
                        "  }\n" +
                        "}",
                XContentType.JSON);

        rh.indices().create(rq, RequestOptions.DEFAULT);

        List<Emp> emp=sever.getAll();
        BulkRequest bulk=new BulkRequest();
        for(Emp em:emp){
            IndexRequest r=new IndexRequest("books").id(em.getId().toString());
            String josn = JSON.toJSONString(em);
            r.source(josn,XContentType.JSON);
            bulk.add(r);
        }
        rh.bulk(bulk,RequestOptions.DEFAULT);

        SearchRequest sr=new SearchRequest("books");
        SearchSourceBuilder sbuilder=new SearchSourceBuilder();
        sbuilder.query(QueryBuilders.termQuery("title","Java"));
        sr.source(sbuilder);
        SearchResponse srp=rh.search(sr,RequestOptions.DEFAULT);
        SearchHits sh=srp.getHits();
        for(SearchHit hit:sh){
            String ss=hit.getSourceAsString();
            Emp e=JSON.parseObject(ss, Emp.class);
        }

        GetRequest gr=new GetRequest("books","1");
        GetResponse rp=rh.get(gr, RequestOptions.DEFAULT);
        String json=rp.getSourceAsString();
        rh.close();

    }

}
