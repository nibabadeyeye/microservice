package com.whs.impl;


import com.whs.dao.JPADao;
import com.whs.dao.UserDao;
import com.whs.pojo.UserEntity;
import com.whs.pojo.ltudeEntity;
import com.whs.service.UserService;
import com.whs.util.EmailUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserImpl   implements UserService {
    @Autowired
    JPADao jPADao;

    @Override
    public List<ltudeEntity> getAll() {
        return userDao.getAll();
    }

    @Override
    public ltudeEntity get(String longtitude, String la) {
        return userDao.get(longtitude,la);
    }

    @Autowired
    UserDao userDao;
    @Autowired
    EmailUtil emailUtil;
    @Override
    public void sendSimpleEmail(String to, String subject, String content) {
        emailUtil.sendSimpleMail(to,subject,content);
    }



    @Override
    public void sendAttachmentsEmail(String to, String subject, String content, String filePath) {
        emailUtil.sendAttachmentsMail(to,subject,content,filePath);
    }

    @Override
    public void sendInlineResourceEmail(String to, String subject, String content, String rscPath, String rscId) {

    }

    //对方法加事务测试
    @Transactional
    @Override
    public void tetTransAction(UserEntity user)   throws RuntimeException {
        userDao.save(user);
        //int i=1/0;
        userDao.save(user);
        userDao.save(user);
    }

    @Cacheable(value=" List<UserEntity>")
    @Override
    public List<UserEntity> queryUserListByCache() {

        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        return userDao.queryList();
    }

    @Override
    public List<UserEntity> queryUserList() {
      //

        return jPADao.findAll();
    }

    @Override
    public void addUser(UserEntity user) {
       //userDao.save(user);
        jPADao.save(user);
    }

    @Override
    public void deleteUser(int id) {
      userDao.deleteUser(id);
    }

    @Override
    public void updateUser(UserEntity user) {
      userDao.update(user);
    }

    @Override
    public UserEntity queryOne(int id) {
       return  userDao.queryOne(id);
    }
    public  List getBankListByExcel(InputStream in, String fileName) throws Exception {
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
                // System.out.println("这个row 代表哦了什么？"+row);
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
    public   Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
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





}
