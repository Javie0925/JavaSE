package lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;


import java.io.File;
import java.io.IOException;

/**
 * @author javie
 * @date 2019/9/2 21:51
 */
public class TestLucene {

    /**
     * 创建索引
     * @throws IOException
     */
    @Test
    public void storeIndex() throws IOException {

        // 索引存放路径
        FSDirectory directory = FSDirectory.open(new File("D:\\Temp\\lucene\\index"));

        // 创建标准分词器
        StandardAnalyzer analyzer = new StandardAnalyzer();

        // 创建IndexWriterConfig对象
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);

        // 创建indexWriter
        IndexWriter indexWriter = new IndexWriter(directory, config);

        File dir = new File("F:\\Java\\HTML");
        for (File f:dir.listFiles()){
            if (!f.isDirectory()){
                // 文件名
                String name = f.getName();
                // 文件内容
                String content = FileUtils.readFileToString(f);
                // 文件路径
                String path = f.getPath();
                // 文件大小
                long size = FileUtils.sizeOf(f);
                // 创建文件名域
                Field nameF = new TextField("filename", name, Field.Store.YES);
                // 内容域
                TextField contentF = new TextField("content", content, Field.Store.YES);
                // 路径
                StoredField pathF = new StoredField("path", path);
                // 大小
                LongField sizeF = new LongField("size", size, Field.Store.YES);

                // 创建Document对象
                Document document = new Document();
                document.add(nameF);
                document.add(contentF);
                document.add(pathF);
                document.add(sizeF);
                // 创建索引，并写入索引库
                indexWriter.addDocument(document);
                System.out.println("-------------");
            }
        }
        // 关闭indexWriter
        indexWriter.close();
    }


    /**
     * 查询索引
     * @throws IOException
     */
    @Test
    public void readIndex() throws IOException {

        // 创建indexSearcher对象，指定indexReader
        FSDirectory directory = FSDirectory.open(new File("D:\\Temp\\lucene\\index"));
        // 创建termQuery对象
        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
        // 执行查询
        TermQuery termQuery = new TermQuery(new Term("filename", "test.css"));
        TopDocs topDocs = searcher.search(termQuery, 10);
        System.out.println("总数："+topDocs.totalHits);
        // 遍历查询结果
        for(ScoreDoc sd:topDocs.scoreDocs){
            Document doc = searcher.doc(sd.doc);
            System.out.println("name:"+doc.get("filename"));
            System.out.println("content:"+doc.get("content"));
            System.out.println("path:"+doc.get("path"));
            System.out.println("size:"+doc.get("size"));
        }
        reader.close();
        // 关闭indexReader对象
    }

    /**
     * 使用QueryParse查询索引
     */
    @Test
    public void readIndex2() throws ParseException, IOException {
        // 创建indexSearcher对象，指定indexReader
        FSDirectory directory = FSDirectory.open(new File("D:\\Temp\\lucene\\index"));
        // 创建termQuery对象
        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
        // 执行查询
        QueryParser queryParser = new QueryParser("filename", new StandardAnalyzer());
        Query query = queryParser.parse("filename:.css");
        TopDocs topDocs = searcher.search(query, 10);
        System.out.println("总数："+topDocs.totalHits);
        for (ScoreDoc sd:topDocs.scoreDocs){
            Document document = searcher.doc(sd.doc);
            System.out.println("filename:"+document.get("filename"));
            System.out.println("content:"+document.get("content"));
            System.out.println("path:"+document.get("path"));
            System.out.println("size:"+document.get("size"));
        }
        reader.close();
    }
}
