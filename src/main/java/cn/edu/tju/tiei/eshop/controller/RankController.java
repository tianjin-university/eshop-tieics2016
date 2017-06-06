package cn.edu.tju.tiei.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.tju.tiei.eshop.model.Rank;
import cn.edu.tju.tiei.eshop.service.IRankService;

@Controller
@RequestMapping("/rankController")
public class RankController {

	private IRankService rankService;

	public IRankService getPersonService() {
		return rankService;
	}

	@Autowired
	public void setRankService(IRankService rankService) {
		this.rankService = rankService;
	}
	
    @RequestMapping("/showRank")
    public String showRanks(Model model){
        List<Rank> ranks = rankService.findAll();
        model.addAttribute("ranks", ranks);
        return "index";
    }
}
