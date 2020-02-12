package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;

/**
 * ホテル情報を操作するコントローラー.
 * 
 * @author fuka
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;

	/**
	 * 入力画面を表示させる操作.
	 * 
	 * @return
	 */
	@RequestMapping("/ex2")
	public String index() {
		return "ex2";
	}

	/**
	 * searchByLessThanPrice()メソッドの呼び出し.
	 * 
	 * @param price リクエストスコープ
	 * @param model
	 * @return ホテル一覧の表示
	 */
	@RequestMapping("/searchByLessThanPrice")
	public String searchByLessThanPrice(Integer price, Model model) {
		if (price == null) {
			List<Hotel> hotelList = hotelService.searchAllHotel();
			model.addAttribute("hotelList", hotelList);
		} else {
			List<Hotel> hotelList = hotelService.searchByLessThanPrice(price);
			model.addAttribute("hotelList", hotelList);
		}
		return "ex2";

	}

}
