package com.servlet.test.service;

import com.servlet.test.entity.Indexer;
import com.servlet.test.entity.Player;
import com.servlet.test.repository.IndexerRepository;
import com.servlet.test.repository.PlayerRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class PlayerService {
    private final PlayerRepository playerRepository;
    private final IndexerRepository indexerRepository;

    public PlayerService(){
        playerRepository = new PlayerRepository();
        indexerRepository = new IndexerRepository();
    }
    public List<Indexer> getAllIndexers(){
        return indexerRepository.findAll();
    }
    public Indexer getIndexerById(Long id) throws Exception {
        Indexer indexer = indexerRepository.findById(id);
        if(indexer == null){
            throw new Exception("Indexer not found");
        }
        return indexer;
    }

    public List<Player> findAll(){
        return playerRepository.findAll();
    }
    public Player findById(Long id) throws Exception {
        Player player = playerRepository.findById(id);
        if(player == null){
            throw  new Exception("Player not found");
        }
        return player;
    }
    public void save(Player player) throws Exception {
        if (player.getName().isEmpty() || player.getFullName().isEmpty()
                || player.getAge().isEmpty() || player.getIndexers().isEmpty()){
            throw new Exception("Name or fullname or age or indexer is empty");
        }

        playerRepository.save(player);
    }
    public void update(Player player) throws Exception {
        if (player.getName().isEmpty() || player.getFullName().isEmpty()
                || player.getAge().isEmpty() || player.getIndexers().isEmpty()){
            throw new Exception("Name or fullname or age or indexer is empty");
        }

        playerRepository.update(player);
    }
    public void deleteById(Long id) throws Exception {
        playerRepository.delete(id);
    }

}
