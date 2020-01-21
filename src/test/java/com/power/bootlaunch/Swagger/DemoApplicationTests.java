package com.power.bootlaunch.Swagger;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.nio.file.Paths;

//启动应用服务容器
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) //使用application.yml定义的端口
public class DemoApplicationTests {

    @Test
    public void generateMarkdown() throws Exception {
        //    输出文件的配置
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN) //生成Markdown格式
                .withOutputLanguage(Language.ZH)  //设置语言中文
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8888/v2/api-docs"))
//        from表示哪一个HTTP服务作为资源导出的源头(JSON格式)
                .withConfig(config)
                .build()
                .toFile(Paths.get("src/main/resources/docs/markdown")); //表示将导出文件存放的位置
//        也可以使用toFolder表示文件导出存放的路径，使用toFolder导出为文件目录下按标签TAGS分类的多个文件
    }

    @Test
    public void generateAsciiDocs() throws Exception {
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC) //生成adoc格式
                .withOutputLanguage(Language.ZH)  //设置语言中文
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8888/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFile(Paths.get("src/main/resources/docs/asciidoc"));
    }
}