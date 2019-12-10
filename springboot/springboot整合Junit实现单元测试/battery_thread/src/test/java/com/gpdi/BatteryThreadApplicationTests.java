package com.gpdi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gpdi.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class BatteryThreadApplicationTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    /**
     * @description:不含参数的get请求 return 返回一个List集合
     */

    @Test
    public void testList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getList")).andDo(MockMvcResultHandlers.print());

    }

    /**
     * @description: 通过Attribute 传递参数
     * param String name
     */

    @Test
    public void getStringByPassString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                //设置请求方法类型和方法名称
                .get("/getStringByPassString")
                //设置请求的参数
                .requestAttr("name", "whs"))
                .andDo(MockMvcResultHandlers.print());

    }

    /**
     * param:  通过Http设置param参数
     */
    @Test
    public void getStringByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                //设置请求方法类型和方法名称
                .get("/getStringByName")
                //设置请求的参数
                .requestAttr("date", "2019年8月2号")
                //通过设置http对象的参数信息
                .param("name", "whs")
        ).andDo(MockMvcResultHandlers.print());

    }

    /**
     * @description: 传递一个json类型的数据进行测试
     */
    @Test
    public void passByJson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/passByJson")
                //设置传输的媒体类型
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                //设置传输的字段
                .content("{\"name\":\"wwww\",\"id\":\"1\"}")

        )
                //     .andExpect(MockMvcResultMatchers.status().isOk())
                //     .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print());

    }


}
