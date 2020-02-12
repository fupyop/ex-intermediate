package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * hotelsテーブルを操作するリポジトリ.
 * @author fuka
 *
 */
@Repository
public class HotelRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	/**
	 * hotelオブジェクトを生成するローマッパー.
	 */
	private static RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs,i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
		
	};
	
	
	/**
	 * ホテル情報詳細を取得する.
	 * @param price　価格
	 * @return ホテル情報
	 */
	public List<Hotel> findByPrice(Integer price) {
		String sql ="select id, area_name, hotel_name, address, nearest_station,price,parking"
				+ " FROM hotels WHERE price <=:price ORDER BY price DESC" ;
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		
		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
		
		return hotelList;
	}
	
	/**
	 * ホテル一覧を価格の降順で取得する.
	 * @return ホテル情報一覧
	 */
	public List<Hotel> findAll(){
		String sql ="SELECT id, area_name, hotel_name, address, nearest_station,price,parking"
				+ " FROM hotels ORDER BY price DESC";
			List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
			return hotelList;
	}
	
	
	
	
}
