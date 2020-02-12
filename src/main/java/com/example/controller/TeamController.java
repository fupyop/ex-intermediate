package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	
	
	/**
	 * showList()メソッドの呼び出し、野球チーム一覧(List)を取得する.
	 * @param model
	 * @return 野球チーム一覧のページ
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Team> teamList = teamService.showList();
		System.out.println(teamList.get(0).getId());
		model.addAttribute("teamList",teamList);
		return "ex1";
		
	}
	
	/**
	 * @param id
	 * @param model
	 * @return　野球チーム詳細のページ
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id,Model model) {
		Team team = teamService.showDetail(Integer.parseInt(id));
		model.addAttribute("team" ,team);
		return "ex1-result";
	}
	
	
	
	
	
	
	
}
