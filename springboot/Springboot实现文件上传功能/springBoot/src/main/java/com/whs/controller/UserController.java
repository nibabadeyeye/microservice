package com.whs.controller;
import com.whs.pojo.UserEntity;
import com.whs.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    //Excel 文件上传并且读取里面的内容
    @RequestMapping("/excelUpload")
    public static String excelUpload(MultipartFile file)  throws Exception {
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();
        System.out.println("最终得到的数组长度"+list.size());
        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            System.out.println(lo);

        }
        return "上传成功";
    }


    public static List getBankListByExcel(InputStream in, String fileName) throws Exception {
        List list = new ArrayList<>();
        //创建Excel工作薄
        Workbook work = getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        //这里默认是3的原因,最多一次性上传三张表 ？
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            System.out.println(sheet+"==============");
            if (sheet == null) {
                continue;
            }
            //sheet.getLastRowNum()=列的长度=循环的次数
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }
                List<Object> li = new ArrayList<>();
                //Excel表格在这里一行行读取的，如果插入数据库也可以在这里进行操作
                System.out.println("这个是列的最大数量？"+row.getLastCellNum());
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    System.out.println("这个是我们具体表格的值"+cell);
                    cell = row.getCell(y);
                    li.add(cell);
                }
                list.add(li);
            }
        }
        work.close();
        return list;
    }
    public  static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return workbook;
    }



    //文件上传
    @RequestMapping("/upload")
    public String upload(MultipartFile file) throws Exception
    {
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
        //String filePath = "d:/mp3/";
        String filePath="/usr/local/file";
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
    @RequestMapping("/add")
    public ModelAndView create(UserEntity user,Model model)
    {
        userService.addUser(user);
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
    @Autowired
    UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
}
