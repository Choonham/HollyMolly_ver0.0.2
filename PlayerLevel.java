package com.jun.hollymolly;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class PlayerLevel implements Listener {
	Player p;
	public PlayerLevel() {
	}
	@EventHandler
	public void onPlayerOnline(PlayerJoinEvent e) {
		this.p = e.getPlayer();
		ShowBoard();
	}
	public void ShowBoard() {
		
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard scoreboard = manager.getNewScoreboard();
		Objective objective =  scoreboard.registerNewObjective("test", "dummy", ChatColor.BLUE + "Scoreboard Title");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Score score = objective.getScore("Test");
		score.setScore(3);
		p.setScoreboard(scoreboard);
		
	}
	
}
