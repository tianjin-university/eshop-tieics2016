package cn.edu.tju.tiei.eshop.service;

import java.util.List;

import cn.edu.tju.tiei.eshop.model.Rank;

public interface IRankService {
	
    /**
     * Load all ranks
     * @return
     */
    List<Rank> findAll();

	Rank findById(byte id);

	void create(Rank rank);

	boolean isExist(Rank rank);

	void update(Rank rank);

	void deleteById(byte id);

	void deleteAll();
}
