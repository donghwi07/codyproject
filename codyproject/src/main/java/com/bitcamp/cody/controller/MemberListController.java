package com.bitcamp.cody.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.cody.dto.MemberDto;
import com.bitcamp.cody.service.MemberListService;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberListService service;

	// 회원리스트
	@RequestMapping("/member/memberList")
	public String memberList(Model model) {
		
		List<MemberDto> members = service.getMemberList();	
		
		model.addAttribute("members", members);	
		
		return "member/memberList";
	}
	
	// 상세보기
	@RequestMapping("/member/listView")
	public String listView(Model model, @RequestParam("member_idx") String idx) {
		
		MemberDto member = service.getlistView(idx);
		
		model.addAttribute("member", member);
		
		
		return "member/listView";
	}
	
	@RequestMapping("/member/memberListSearch")
	public String listSearch(Model model, @RequestParam("member_idx") int idx) {

		List<MemberDto> members = service.getListSearch(idx);
		System.out.println("검색: " + members.toString());
		model.addAttribute("members", members);

		return "member/memberListSearch";
	}
	
	@RequestMapping("/top/aside")
	public String memberlist2(Model model) {
		
		List<MemberDto> memberst = service.getMemberListt();		
		
		System.out.println(memberst.toString());
		model.addAttribute("memberst", memberst);
		
		return "top/aside";
	}
	
		
	
}
