package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Costume;


/**
 * clothesテーブルを操作するリポジトリ.
 * @author fuka
 *
 */
@Repository
public class CostumeRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	private static RowMapper<Costume> COSTUME_ROW_MAPPER =(rs,i) -> {
		Costume costume = new Costume();
		costume.setId(rs.getInt("id"));
		costume.setCategory(rs.getString("category"));
		costume.setGenre(rs.getString("genre"));
		costume.setGender(rs.getInt("gender"));
		costume.setColor(rs.getString("color"));
		costume.setPrice(rs.getInt("price"));
		costume.setSize(rs.getString("size"));
		return costume;
	};
	
	public Costume 
	
	
	
	}

	

