package com.servlet.test.controller;

import com.servlet.test.entity.Indexer;
import com.servlet.test.entity.Player;
import com.servlet.test.service.PlayerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/player")
public class PlayerController extends HttpServlet {
    private PlayerService playerService;

    @Override
    public void init() throws ServletException {
        super.init();
        playerService = new PlayerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null || action.isEmpty()) action = "list";
        switch (action) {
            case "list": getList(req, resp); break;
            case "edit": getEdit(req, resp); break;
            default: resp.sendError(HttpServletResponse.SC_NOT_FOUND); break;
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add": postAdd(req, resp); break;
            case "edit": postEdit(req, resp); break;
            case "delete": postDelete(req, resp); break;
            default: resp.sendError(HttpServletResponse.SC_NOT_FOUND); break;
        }
    }

    private void getList(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Player> plays = playerService.findAll();
        List<Indexer> indexers = playerService.getAllIndexers();
        req.setAttribute("players", plays);
        req.setAttribute("indexers", indexers);
        req.getRequestDispatcher("/player/list.jsp").forward(req, resp);
    }

    private void getEdit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        List<Indexer> indexers = playerService.getAllIndexers();
        req.setAttribute("indexers", indexers);
        req.getRequestDispatcher("/player/edit.jsp").forward(req, resp);

    }
    private void postAdd(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Long indexerId =Long.parseLong(req.getParameter("indexerId"));
            Indexer indexer = playerService.getIndexerById(indexerId);
            String indexValue = req.getParameter("value");
            Player player = new Player();
            player.setName(req.getParameter("name"));
            player.setFullName(req.getParameter("fullName"));
            player.setAge(req.getParameter("age"));
            player.setIndexers(indexer);
            playerService.save(player);
            getList(req, resp);
        }catch (Exception e){
            getList(req, resp);
        }


    }
    private void postEdit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        try {
            Long playerId =Long.parseLong(req.getParameter("id"));
            String indexValue = req.getParameter("value");
            Player player = playerService.findById(playerId);
            player.setName(req.getParameter("name"));
            player.setFullName(req.getParameter("fullName"));
            player.setAge(req.getParameter("age"));
            playerService.update(player);
            getList(req, resp);
        }catch (Exception e){
            getList(req, resp);
        }

    }
    private void postDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        Long id = Long.parseLong(req.getParameter("playerId"));
        try {
            playerService.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        getList(req, resp);

    }

}
