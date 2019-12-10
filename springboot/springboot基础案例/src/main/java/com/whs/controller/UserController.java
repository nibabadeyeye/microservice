package com.whs.controller;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.whs.impl.UserImpl;
import com.whs.pojo.UserEntity;
import com.whs.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@RestController
public class UserController {


    //查询数据库的经纬度信息
    @GetMapping("/showData")
    public List showData( )
    {
        //   userService.tetTransAction(user);
       // model.addAttribute("userList", userService.queryUserList());
     //   return new ModelAndView("miaodian","userModel",model) ;
        //  return new ModelAndView("redirect:/users");
         return    userService.queryUserList();
    }

    @GetMapping("/map")
    public ModelAndView testCache(Model model)
    {
     //   userService.tetTransAction(user);
        model.addAttribute("userList", userService.queryUserList());
        return new ModelAndView("miaodian","userModel",model) ;
        //  return new ModelAndView("redirect:/users");
    }
    //发送简单邮件
    @RequestMapping("/simpleEmail")
    public void Simple()
    {
        userService.sendSimpleEmail("2044881390@qq.com","新的主题","简单的测试邮件");
    }

    //带附件的邮件
    @RequestMapping("/difficultEmail")
    public void difficult()
    {
        String filePath = "D:/mp3/jdbc.rar";
        userService.sendAttachmentsEmail("1157793365@qq.com","硬主题","简单的测试邮件",filePath);
    }


    //Excel 文件上传并且读取里面的内容
    @RequestMapping("/excelUpload")
    public  String excelUpload(MultipartFile file)  throws Exception
    {

        if (file.isEmpty())
        {
            return "文件不能为空";
        }else {
            InputStream inputStream = file.getInputStream();
            List<List<Object>> list = userImp.getBankListByExcel(inputStream, file.getOriginalFilename());
            inputStream.close();
            System.out.println("最终得到的数组长度"+list.size());
            for (int i = 0; i < list.size(); i++) {
                List<Object> lo = list.get(i);
                System.out.println(lo);

            }

            }

        return "上传成功";

    }


    //文件上传
    @RequestMapping("/upload")
    public  String upload(MultipartFile file) throws Exception
    {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        if (file.isEmpty())
        {
            return "文件为空";
        }
       // 获取文件名
        String fileName = file.getOriginalFilename();
       //  logger.info("上传的文件名为：" + fileName);
       // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
       //  logger.info("上传的后缀名为：" + suffixName);
       // 文件上传路径
        String filePath = "d:/mp3/";
       // 解决中文问题，liunx 下中文路径，图片显示问题
       // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
       // 检测是否存在目录
        if (!dest.getParentFile().exists())
        {

            dest.getParentFile().mkdirs();
        }
        try
        {
            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }


   //查询所有用户信息
    @RequestMapping(value ={"/queryList"})
    public ModelAndView queryList(Model model)
    {
        model.addAttribute("userList", userService.queryUserList());
        return new ModelAndView("users/list","userModel",model) ;
    }
    /***根据id查询用户*/
    @GetMapping("/one")
    public ModelAndView view( int id, Model model) {
        UserEntity user = userService.queryOne(id);
        model.addAttribute("user", user);
        return new ModelAndView("users/update", "userModel", model);
    }
    //创建表单
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new UserEntity());
     //   model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**添加用户*/
    @RequestMapping(value="/add",produces = "application/json")
    public void create(@RequestBody  JSONObject obj)
    {

        if(obj.containsKey("ids"))
        {
            JSONArray array=   obj.getJSONArray("ids");

            for (int i = 0; i < array.size(); i++) {
                JSONObject temp = (JSONObject) array.get(i);
                String Typecode = temp.getString("Typecode");
                System.out.println(Typecode+"  ==========");

            }

        }

        System.out.println(obj);
       // userService.addUser(user);
      //  model.addAttribute("userList", userService.queryUserList());
      //  return new ModelAndView("users/list","userModel",model) ;
        //  return new ModelAndView("redirect:/users");
    }
    /**添加用户*/
    @RequestMapping("/testCache")
    public ModelAndView testCache(UserEntity user,Model model)
    {
        userService.tetTransAction(user);
        model.addAttribute("userList", userService.queryUserList());
        return new ModelAndView("users/list","userModel",model) ;
        //  return new ModelAndView("redirect:/users");
    }
    /*删除用户*/
    @GetMapping(value = "/delete")
    public ModelAndView delete(int id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("userList", userService.queryUserList());
        return new ModelAndView("users/list", "userModel", model);
    }
    /**
     * 修改用户
     *
     */
    @RequestMapping(value = "/update")
    public ModelAndView modifyForm(UserEntity userEntity, Model model) {
        userService.updateUser(userEntity);
        model.addAttribute("userList", userService.queryUserList());
        return new ModelAndView("users/list", "userModel", model);
    }

    @RequestMapping(value = {"/user","user1"}, method = RequestMethod.GET)
    public ModelAndView index(Model model)
    {
        // Map map=new HashMap();
        UserEntity userEntity=new UserEntity();
        userEntity.setAge(16);
        userEntity.setId(10);
        userEntity.setName("张三");
        model.addAttribute(userEntity);
        return new ModelAndView("index","userModel", model);

    }
    //log4j日志文件
    @RequestMapping("/load")
    public ModelAndView load( Model model) {
        logger.debug("this is a log test, debug");
        logger.info("this is a log test, info");
        return new ModelAndView("upload/upload");
    }

    @RequestMapping(value ={"/queryList1"})
    public ModelAndView queryList1(Model model)
    {
        model.addAttribute("userList", userService.queryUserListByCache());
        return new ModelAndView("users/list","userModel",model) ;
    }

    /**添加用户*/
    @RequestMapping("/testTransaction")
    public ModelAndView testTransaction(@Param(value="user") UserEntity user,Model model)
    {

        userService.tetTransAction(user);
        model.addAttribute("userList", userService.queryUserList());
        return new ModelAndView("users/list","userModel",model) ;
        //  return new ModelAndView("redirect:/users");
    }

    @Autowired
    UserService userService;
    @Autowired
    UserImpl userImp;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
}
