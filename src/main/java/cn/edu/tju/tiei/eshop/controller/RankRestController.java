package cn.edu.tju.tiei.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import cn.edu.tju.tiei.eshop.model.Rank;
import cn.edu.tju.tiei.eshop.service.IRankService;

@RestController
public class RankRestController {

	@Autowired
	private IRankService rankService;
	
	/**
	 * Retrieve all ranks
	 * @return
	 */
    @RequestMapping(value = "/rank/", method = RequestMethod.GET)
    public ResponseEntity<List<Rank>> listAll(){
        List<Rank> ranks = rankService.findAll();
        if (ranks.isEmpty()) {
            return new ResponseEntity<List<Rank>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Rank>>(ranks, HttpStatus.OK);
    }
    
    /**
     * Retrieve a single rank
     * @param id
     * @return
     */
    @RequestMapping(value = "/rank/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rank> get(@PathVariable("id") byte id) {
    	Rank rank = rankService.findById(id);
        if (rank == null) {
            return new ResponseEntity<Rank>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Rank>(rank, HttpStatus.OK);
    }
    
    /**
     * Create a rank
     * @param rank
     * @param ucBuilder
     * @return
     */
    @RequestMapping(value = "/rank/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Rank rank, UriComponentsBuilder ucBuilder) {
        if (rankService.isExist(rank)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        rankService.create(rank);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rank/{id}").buildAndExpand(rank.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    /**
     * Update a rank
     * @param id
     * @param rank
     * @return
     */
    @RequestMapping(value = "/rank/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Rank> update(@PathVariable("id") byte id, @RequestBody Rank rank) {
        Rank oldRank = rankService.findById(id);
        if (oldRank==null) {
            return new ResponseEntity<Rank>(HttpStatus.NOT_FOUND);
        }
        oldRank.setName(rank.getName());
        oldRank.setScore(rank.getScore());
        oldRank.setDiscount(rank.getDiscount());
        rankService.update(oldRank);
        return new ResponseEntity<Rank>(oldRank, HttpStatus.OK);
    }
    
    /**
     * Delete a rank
     * @param id
     * @return
     */
    @RequestMapping(value = "/rank/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Rank> delete(@PathVariable("id") byte id) {
        Rank rank = rankService.findById(id);
        if (rank == null) {
             return new ResponseEntity<Rank>(HttpStatus.NOT_FOUND);
        }
        rankService.deleteById(id);
        return new ResponseEntity<Rank>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * Delete all ranks
     * @return
     */
    @RequestMapping(value = "/rank/", method = RequestMethod.DELETE)
    public ResponseEntity<Rank> deleteAll() {
        rankService.deleteAll();
        return new ResponseEntity<Rank>(HttpStatus.NO_CONTENT);
    }

}
