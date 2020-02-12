package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

@Service
@Transactional
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * @param price
	 * @return ホテル詳細情報
	 */
	public List<Hotel> searchByLessThanPrice(Integer price) {
		return hotelRepository.load(price);
	}
	
	/**
	 * ホテル詳細情報の全件検索(price=nullの場合)
	 * @return　ホテル詳細一覧
	 */
	public List<Hotel> searchAllHotel(){
		return hotelRepository.findAll();
	}
	
	
	
}
