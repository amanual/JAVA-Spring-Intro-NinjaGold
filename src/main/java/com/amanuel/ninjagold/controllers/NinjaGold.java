package com.amanuel.ninjagold.controllers;
import java.util.Random;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGold {
	public int gold;
	public ArrayList<String> message = new ArrayList<>();
	
	
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold += gold;
	}
	public ArrayList getMessage() {
		return message;
	}
//	public void setMessage(ArrayList message) {
//		this.message = message;
//	}
	@RequestMapping("")
	public String index() {
		return "index";
	}
	@RequestMapping(path = "/golds", method = RequestMethod.POST)
	public String ninjaGolds(@RequestParam(value = "farm", required = false,defaultValue = "") String farm, @RequestParam(value = "cave", required = false, defaultValue = "") String cave,@RequestParam(value = "house", required = false,defaultValue = "") String house,@RequestParam(value = "casino", required = false,defaultValue = "") String casino, HttpSession session) {
		Random rand = new Random();
		int farmRandom =rand.nextInt(11) + 10;
		int caveRandom =rand.nextInt(6) + 5;
		int houseRandom =rand.nextInt(4) + 2;
		int casinoRandom =rand.nextInt(51 + 1 + 50) - 50;
		System.out.println("farmRandom: " + farmRandom);
		System.out.println("caveRandom: " + caveRandom);
		
		
		System.out.println("farmValue: " + farm);
		System.out.println("caveValue: " + cave);
		System.out.println("houseValue: " + house);
		System.out.println("casinoValue: " + casino);
		if(farm.equals("farmValue")) {
			System.out.println("helooo:");
			this.gold += farmRandom;
			this.message.add("you won: " + this.gold + " golds from the farm!");
			session.setAttribute("gold", getGold());
			
			session.setAttribute("message", getMessage());
			System.out.println("you won: " + this.gold + " golds from the farm!");
			
			return "redirect:/";
		}
		else if(cave.equals("caveValue")) {
			this.gold += caveRandom;
			this.message.add("you won :" + caveRandom + " golds from the cave!");
			session.setAttribute("gold", getGold());
			session.setAttribute("message", getMessage());
			System.out.println("you won: " + caveRandom + " golds from the cave!");
			return "redirect:/";
		}
		else if(house.equals("houseValue")) {
			
			this.gold += houseRandom;
			this.message.add("you won: " + houseRandom + " golds from the house!");
			session.setAttribute("gold", this.gold);
			session.setAttribute("message", getMessage());
			System.out.println("you won :" + houseRandom + " golds from the house!");
			return "redirect:/";
		}
		else if(casino.equals("casinoValue")) {
			if(casinoRandom < 0) {
				this.gold += casinoRandom;
				this.message.add("you lost: " + (-1 * casinoRandom) + " golds from casino" );
				session.setAttribute("gold", this.gold);
				session.setAttribute("message", getMessage());
				System.out.println("you lost :" + (-1 * casinoRandom) + " golds from casino" );
				return "redirect:/";
			}
			this.gold += casinoRandom;
			this.message.add("you won: " + casinoRandom + " golds from casino!");
			session.setAttribute("gold", this.gold);
			session.setAttribute("message", getMessage());
			System.out.println("you won: " + casinoRandom + " from casino!");
			return "redirect:/";
		}
		return "redirect:/";
	}
	@RequestMapping("/reset")
	public String reset( HttpSession session) {
		this.gold = 0;
		this.message.clear();
		session.invalidate();
		return "redirect:/";
	}
}
