package edu.zju.gis.njq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zju.gis.njq.entity.User;
import edu.zju.gis.njq.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping(value = "/showUser", method = RequestMethod.GET)
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}

	@RequestMapping("/list")
	public String toList(HttpServletRequest request, Model model) {
		return "list";
	}

	@RequestMapping("/userList")
	@ResponseBody
	public Object getAllUsers(HttpServletRequest request, Model model) {
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));

		int offset = (page == 0 ? 0 : (page - 1) * rows);

		List<User> list = this.userService.getAllUsers(offset, rows);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", this.userService.getCountUsers());
		map.put("rows", list);

		return map;
	}

}
