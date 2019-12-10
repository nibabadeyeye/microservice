package com.gpdi.web.video.controller;
import com.gpdi.util.ResponseData;
import com.gpdi.web.user.entity.User;
import com.gpdi.web.user.service.UserService;
import com.gpdi.web.video.entity.Room;
import com.gpdi.web.video.entity.RoomUtil;
import com.gpdi.web.video.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @desc:视频信息管理
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @RequestMapping("test")
    public void test(){
        ServletContext context=webApplicationContext.getServletContext();
        context.setAttribute("whs","手动输入的数值");
    }
    /**
     * @desc: 查询所有专家信息
     *
     * */
    @GetMapping("getAllNatureList")
    public ResponseData getAllNatureList(){
        Object name=webApplicationContext.getServletContext().getAttribute("whs");
             System.out.println("从Servlet从获取上下文对象"+name);
        return new ResponseData(200,"请求成功",roomService.getAllNatureList());
    }


    @GetMapping("getFirstNatureId")
    public synchronized ResponseData getFirstNatureId() {
        Object name=webApplicationContext.getServletContext().getAttribute("whs");
        System.out.println("从Servlet从获取上下文对象"+name);
        return new ResponseData(200, "请求成功", roomService.getFirstNatureId());
    }


    /**
     * @desc:用户查询当前创建的房间数
     */
    @GetMapping(value = "getCreateRoomNumber")
    public synchronized ResponseData getCreateRoomNumber() {
        int count = roomService.judgeRoomHasCreate("select count(*) from room");
        Map map = new HashMap();
        map.put("count", count);
        return new ResponseData(200, "请求成功", map);
    }


    /**
     * @desc:用户查询当前创建的房间数
     */
    @GetMapping(value = "getWaitNaturePeople")
    public synchronized ResponseData getWaitNaturePeople(String natureId) {
        int count = roomService.getWaitNaturePeople(natureId);
        Map map = new HashMap();
        map.put("count", count);
        return new ResponseData(200, "请求成功", map);
    }



    /**
     * @desc:查询当前用户创建的房间号的最大数
     * */
    @RequestMapping("getRoomByNature")
    public synchronized ResponseData getRoomByNature(String natureId) {
        Room room = roomService.getRoomByNature(natureId);
        int id = room.getId();
        roomService.updateRoomFlag(id);
        return new ResponseData(200, "请求成功", room);
    }


    /**
     * @desc:用户创建一个房间 传递的参数有 :
     * 1、用户Id
     * 2、专家Id
     * 3、房间Id
     * 4、房间密码
     */
    @PostMapping("/userCreateRoom")
    public synchronized ResponseData userCreateRoom(String roomId, HttpServletRequest request, String natureId, String password) {
        //用户删除之前的房间
        Room room = new Room();
        room.setNatureId(natureId);
        room.setPassword(password);
        String token = request.getHeader("X-iEnvPro-Token");
        User user = (User) request.getServletContext().getAttribute(token);
        String userId = user.getUid();
        room.setUid(userId);
        room.setRoomId(roomId);
        room.setFlag(0);
        String delSql = "delete from room where natureId='" + natureId + "' and uid='" + userId + "'";
        roomService.delHistoryRoom(delSql);
        String sql = "select count(*) from room where   natureId='" + natureId + "'";
        int count = roomService.judgeRoomHasCreate(sql);
        int number = roomService.getRoomNumberByNatureId(natureId);
        //判断当前专家有几个用户，如果不超过3个创建
        if (number < 3) {
            roomService.userCreateRoom(room);

        }
        return new ResponseData(200, "请求成功");

    }

    /**
     * @desc:用户离开后销毁房间
     */
    @GetMapping(value = "userLeave")
    public synchronized ResponseData userLeave(HttpServletRequest request, String roomId) {
        String token = request.getHeader("X-iEnvPro-Token");
        User user = (User) request.getServletContext().getAttribute(token);
        //查询用户的收藏信息
        String userId = user.getUid();
        RoomUtil roomUtil = new RoomUtil();
        roomUtil.setUserId(userId);
        roomUtil.setRoomId(roomId);
        roomService.delRoomByUserId(roomUtil);
        return new ResponseData(200, "请求成功");
    }


    /**
     * @desc:专家前往下一个房间进行视屏
     */

    @GetMapping(value = "natureLeave")
    public synchronized ResponseData natureLeave(String natureId) {
        Map map = new HashMap();
        //查询当前有没有等待视频
        int count = roomService.getWaitNaturePeople(natureId);
        map.put("count", count);
        if (count > 0) {
            Room room = roomService.getRoomByNature(natureId);
            //修改下一个房间的ID为flg
            // roomService.updateRoomFlag(room.getId());
            map.put("room", room);

        }


        return new ResponseData(200, "请求成功", map);
    }


    //查询当前用户是否为专家
    @RequestMapping(value = "judgeIdentity")
    public synchronized ResponseData judgeIdentity(HttpServletRequest request) {
        String token = request.getHeader("X-iEnvPro-Token");
        User user = (User) request.getServletContext().getAttribute(token);
        //查询用户的收藏信息
        System.out.println("kkkk" + user);
        String userId = user.getUid();
        // System.out.println("当前用户Id"+userId);
        //String sql="select count(*) from nature where  uid='"+userId+"'";
        int count = userService.judgeIsNature(userId);
        System.out.println("是否为专家" + count);
        Map map = new ConcurrentHashMap();
        map.put("count", count);
        // map.put("natureId", userId);
        return new ResponseData(200, "请求成功", map);
    }

    @GetMapping(value = "getAllCreateRoomByNatureId")
    public synchronized ResponseData getAllCreateRoomByNatureId(String natureId) {
        List<Room> list = roomService.getAllRoomByNatureId(natureId);
        Map map = new ConcurrentHashMap();
        map.put("data", list);
        return new ResponseData(200, "请求成功", map);
    }


    @Autowired
    private RoomService roomService;
    @Autowired
    private UserService userService;
}
