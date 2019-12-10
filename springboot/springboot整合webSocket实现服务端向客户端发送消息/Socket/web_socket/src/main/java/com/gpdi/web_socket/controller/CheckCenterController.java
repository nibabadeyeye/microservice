package com.gpdi.web_socket.controller;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {

	//页面请求
	@GetMapping("/socket/{cid}")
	public ModelAndView socket(@PathVariable String cid) {
		ModelAndView mav=new ModelAndView("/socket");
		mav.addObject("cid", cid);
		return mav;
	}
	//推送数据接口
	@ResponseBody
	@RequestMapping("/socket/push/{cid}")
	public ApiReturnObject pushToWeb(@PathVariable String cid,String message) {
		try {
			WebSocketServer.sendInfo(message,cid);
		} catch (IOException e) {
			e.printStackTrace();
			return ApiReturnUtil.error(cid+"#"+e.getMessage());
		}
		return ApiReturnUtil.success(cid);
	}
}
