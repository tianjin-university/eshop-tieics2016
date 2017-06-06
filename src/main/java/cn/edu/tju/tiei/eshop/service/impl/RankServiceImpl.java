package cn.edu.tju.tiei.eshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.tiei.eshop.dao.RankMapper;
import cn.edu.tju.tiei.eshop.model.Rank;
import cn.edu.tju.tiei.eshop.service.IRankService;

@Service("rankService")
public class RankServiceImpl implements IRankService {

	@Resource
	private RankMapper rankMapper;

	public RankMapper getRankMapper() {
		return rankMapper;
	}

	@Autowired
	public void setPersonMapper(RankMapper rankMapper) {
		this.rankMapper = rankMapper;
	}

	public List<Rank> findAll() {
		return rankMapper.selectByExample(null);
	}

	@Override
	public Rank findById(byte id) {
		return rankMapper.selectByPrimaryKey(id);
	}

	@Override
	public void create(Rank rank) {
		rankMapper.insert(rank);
	}

	@Override
	public boolean isExist(Rank rank) {
		return rankMapper.selectByPrimaryKey(rank.getId()) != null;
	}

	@Override
	public void update(Rank rank) {
		rankMapper.updateByPrimaryKey(rank);
	}

	@Override
	public void deleteById(byte id) {
		rankMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteAll() {
		rankMapper.deleteByExample(null);
	}

}
