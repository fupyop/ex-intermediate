package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;


/**
 *野球チーム情報を操作するサービス.
 * @author fuka
 *
 */
@Service
@Transactional
public class TeamService {
	@Autowired
	private TeamRepository teamRepository;
	
	
	/**
	 * 野球チーム一覧を全件取得する.
	 * @return 野球チーム一覧情報
	 */
	public List<Team> showList(){
		return teamRepository.findAll();
	}
	
	
	/**
	 * @param id ID
	 * @return　野球チーム詳細情報
	 */
	public Team showDetail (Integer id) {
		return teamRepository.load(id);
	}
	
	
}
