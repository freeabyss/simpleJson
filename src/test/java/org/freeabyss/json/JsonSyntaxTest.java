package org.freeabyss.json;

import org.junit.jupiter.api.Test;

class JsonSyntaxTest {

    @Test
    void parse_01() {
        String json = "{\"name\":\"freeabyss\",\"age\":18}";
        JsonSyntax jsonSyntax = new JsonSyntax(new JsonLex(new CharReader(json)));
        System.out.println(jsonSyntax.parse());
    }
   @Test
    void parse_03() {
        String json = "{\n" +
                "  \"banners\": [\n" +
                "    {\n" +
                "      \"cover\": \"imgs/banner-city.png\",\n" +
                "      \"name\": \"各城市知名IT公司\",\n" +
                "      \"content\": \"包括互联网公司、软件公司、硬件公司，上市、非上市、独角兽等等。目前整理的不是很详细。如有错误欢迎指正。\\n\\n点击下方图片查看大图\",\n" +
                "      \"img\": \"imgs/city-it.png\",\n" +
                "      \"link\": \"网页版复制链接：https://jeeweixin.com\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"cover\": \"imgs/mianshi.png\",\n" +
                "      \"name\": \"笔试面试题资料大全\",\n" +
                "      \"content\": \"包括Java初级、中级、高级等，还有架构师面试题、前端笔试面试题，参考下方图片。\",\n" +
                "      \"img\": \"imgs/1-20220228160818.png\",\n" +
                "      \"link\": \"获取链接：https://mp.weixin.qq.com/s/13Zd3D8-vgloB3mo3sFVuQ\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"promps\": [\n" +
                "    {\n" +
                "      \"title\": \"视频教程\",\n" +
                "      \"array\": [\n" +
                "        {\n" +
                "          \"cover\": \"imgs/coverp-website.png\",\n" +
                "          \"name\": \"手把手教你建站\",\n" +
                "          \"url\": \"/pages/course/course?code=website&name=手把手教你建站\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"cover\": \"imgs/coverp-weapp.png\",\n" +
                "          \"name\": \"小程序编程课\",\n" +
                "          \"url\": \"/pages/course/course?code=weapp&name=微信小程序编程\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"cover\": \"imgs/coverp-java.png\",\n" +
                "          \"name\": \"JavaWeb全栈编程\",\n" +
                "          \"url\": \"/pages/course/course?code=java&name=JavaWeb全栈编程\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"cover\": \"imgs/coverp-project.png\",\n" +
                "          \"name\": \"玩转项目源码\",\n" +
                "          \"url\": \"/pages/course/course?code=projects&name=玩转项目源码\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"编程路线图\",\n" +
                "      \"array\": [\n" +
                "        {\n" +
                "          \"cover\": \"imgs/coverm-learn.png\",\n" +
                "          \"name\": \"学习编程的步骤\",\n" +
                "          \"content\": \"好多同学想学编程，但是不知道怎么学，给大家整理了一个学习的过程，尤其是第3步，非常重要。\\n\\n点击下方图片看大图\",\n" +
                "          \"img\": \"imgs/xm-learn.jpg\",\n" +
                "          \"link\": \"关注公众号：祁大聪，获取原图\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"cover\": \"imgs/coverm-java.png\",\n" +
                "          \"name\": \"Java全栈路线图\",\n" +
                "          \"content\": \"Java编程就业率常年第一，编程排行榜常年霸榜。\\n\\n学Java编程好就业、升职加薪前景好。那该学哪些知识点呢？给大家整理了一个Java全栈编程路线图，供大家参考。\\n\\n点击下方图片看大图\",\n" +
                "          \"img\": \"imgs/xm-java.png\",\n" +
                "          \"link\": \"原图和思维脑图下载：https://mp.weixin.qq.com/s/ScDeU9fi24PEmdH9qsgTVQ\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"cover\": \"imgs/coverm-frontend.png\",\n" +
                "          \"name\": \"前端编程路线图\",\n" +
                "          \"content\": \"很多同学想学前端，但是不知道要学习哪些知识点，更不知道学习的路线规划是什么样的，容易走弯路。\\n\\n给大家整理了一个Java全栈编程路线图，供大家参考。\\n\\n点击下方图片看大图\",\n" +
                "          \"img\": \"imgs/xm-frontend.png\",\n" +
                "          \"link\": \"原图和思维脑图下载：https://jeeweixin.com/article/1417253081841696\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"cover\": \"imgs/coverm-python.png\",\n" +
                "          \"name\": \"Python3速查地图\",\n" +
                "          \"content\": \"Python3知识点速查地图，靠着一张图就够了。\\n\\n点击下方图片看大图\",\n" +
                "          \"img\": \"imgs/xm-python.jpg\",\n" +
                "          \"link\": \"中文版正在制作中。关注公众号：祁大聪，获取原图\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"热门电子书\",\n" +
                "      \"array\": [\n" +
                "        {\n" +
                "          \"cover\": \"imgs/coverp-pdf-ali.png\",\n" +
                "          \"name\": \"阿里巴巴Java编程规范\",\n" +
                "          \"pdf\": \"pdf/alibaba-dev.pdf\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"cover\": \"imgs/coverp-pdf-java.png\",\n" +
                "          \"name\": \"Java基础面试\",\n" +
                "          \"pdf\": \"pdf/java-v1.pdf\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JsonSyntax jsonSyntax = new JsonSyntax(new JsonLex(new CharReader(json)));
        System.out.println(jsonSyntax.parse());
    }

    // 测试 json 数组
    @Test
    void parse_02() {
        String json = "[{\"name\":\"freeabyss\",\"age\":18.5},{\"name\":\"freeabyss\",\"age\":1.8 }]";
        JsonSyntax jsonSyntax = new JsonSyntax(new JsonLex(new CharReader(json)));
        System.out.println(jsonSyntax.parse());
    }
}