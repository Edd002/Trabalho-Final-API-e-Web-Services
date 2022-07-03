package com.spring.crud.demo.utils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.spring.crud.demo.model.Player;
import com.spring.crud.demo.model.Team;
import com.spring.crud.demo.model.Transfer;
import com.spring.crud.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class HelperUtil {

    @Autowired
    private TeamRepository teamRepository;

    private HelperUtil() {
    }

    public static List<Team> teamSupplier() {
        return Arrays.asList(
                Team.builder().name("Team Name 1").local("Team Local 1").build(),
                Team.builder().name("Team Name 2").local("Team Local 2").build(),
                Team.builder().name("Team Name 3").local("Team Local 3").build(),
                Team.builder().name("Team Name 4").local("Team Local 4").build(),
                Team.builder().name("Team Name 5").local("Team Local 5").build(),
                Team.builder().name("Team Name 6").local("Team Local 6").build(),
                Team.builder().name("Team Name 7").local("Team Local 7").build(),
                Team.builder().name("Team Name 8").local("Team Local 8").build(),
                Team.builder().name("Team Name 9").local("Team Local 9").build(),
                Team.builder().name("Team Name 10").local("Team Local 10").build());
    }

    public static List<Player> playerSupplier(List<Team> teams) {
        return Arrays.asList(
                Player.builder().name("Player Name 1").birthdate(new Date()).country("Player Country 1").team(teams.get(0)).build(),
                Player.builder().name("Player Name 2").birthdate(new Date()).country("Player Country 2").team(teams.get(1)).build(),
                Player.builder().name("Player Name 3").birthdate(new Date()).country("Player Country 3").team(teams.get(2)).build(),
                Player.builder().name("Player Name 4").birthdate(new Date()).country("Player Country 4").team(teams.get(3)).build(),
                Player.builder().name("Player Name 5").birthdate(new Date()).country("Player Country 5").team(teams.get(4)).build(),
                Player.builder().name("Player Name 6").birthdate(new Date()).country("Player Country 6").team(teams.get(5)).build(),
                Player.builder().name("Player Name 7").birthdate(new Date()).country("Player Country 7").team(teams.get(6)).build(),
                Player.builder().name("Player Name 8").birthdate(new Date()).country("Player Country 8").team(teams.get(7)).build(),
                Player.builder().name("Player Name 9").birthdate(new Date()).country("Player Country 9").team(teams.get(8)).build(),
                Player.builder().name("Player Name 10").birthdate(new Date()).country("Player Country 10").team(teams.get(9)).build());
    }

    public static List<Transfer> transferSupplier(List<Team> teams) {
        return Arrays.asList(
                Transfer.builder().country("Transfer Country 1").value(1.0).originTeam(teams.get(0)).destinyTeam(teams.get(9)).build(),
                Transfer.builder().country("Transfer Country 2").value(2.0).originTeam(teams.get(1)).destinyTeam(teams.get(8)).build(),
                Transfer.builder().country("Transfer Country 3").value(3.0).originTeam(teams.get(2)).destinyTeam(teams.get(7)).build(),
                Transfer.builder().country("Transfer Country 4").value(4.0).originTeam(teams.get(3)).destinyTeam(teams.get(6)).build(),
                Transfer.builder().country("Transfer Country 5").value(5.0).originTeam(teams.get(4)).destinyTeam(teams.get(5)).build(),
                Transfer.builder().country("Transfer Country 6").value(6.0).originTeam(teams.get(5)).destinyTeam(teams.get(4)).build(),
                Transfer.builder().country("Transfer Country 7").value(7.0).originTeam(teams.get(6)).destinyTeam(teams.get(3)).build(),
                Transfer.builder().country("Transfer Country 8").value(8.0).originTeam(teams.get(7)).destinyTeam(teams.get(2)).build(),
                Transfer.builder().country("Transfer Country 9").value(9.0).originTeam(teams.get(8)).destinyTeam(teams.get(1)).build(),
                Transfer.builder().country("Transfer Country 10").value(10.0).originTeam(teams.get(9)).destinyTeam(teams.get(0)).build());
    }
}