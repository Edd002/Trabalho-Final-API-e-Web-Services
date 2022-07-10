package com.spring.crud.demo.utils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.spring.crud.demo.model.*;

public class HelperUtil {

    private HelperUtil() {
    }

    public static List<Event> eventSupplier(List<Match> matches) {
        return Arrays.asList(
                Event.builder().name("Event Name 1").match(matches.get(0)).build(),
                Event.builder().name("Event Name 2").match(matches.get(1)).build(),
                Event.builder().name("Event Name 3").match(matches.get(2)).build(),
                Event.builder().name("Event Name 4").match(matches.get(3)).build(),
                Event.builder().name("Event Name 5").match(matches.get(4)).build(),
                Event.builder().name("Event Name 6").match(matches.get(5)).build(),
                Event.builder().name("Event Name 7").match(matches.get(6)).build(),
                Event.builder().name("Event Name 8").match(matches.get(7)).build(),
                Event.builder().name("Event Name 9").match(matches.get(8)).build(),
                Event.builder().name("Event Name 10").match(matches.get(9)).build());
    }

    public static List<Match> matchSupplier(List<Tournament> tournaments) {
        return Arrays.asList(
                Match.builder().name("Match Name 1").tournament(tournaments.get(0)).build(),
                Match.builder().name("Match Name 2").tournament(tournaments.get(1)).build(),
                Match.builder().name("Match Name 3").tournament(tournaments.get(2)).build(),
                Match.builder().name("Match Name 4").tournament(tournaments.get(3)).build(),
                Match.builder().name("Match Name 5").tournament(tournaments.get(4)).build(),
                Match.builder().name("Match Name 6").tournament(tournaments.get(5)).build(),
                Match.builder().name("Match Name 7").tournament(tournaments.get(6)).build(),
                Match.builder().name("Match Name 8").tournament(tournaments.get(7)).build(),
                Match.builder().name("Match Name 9").tournament(tournaments.get(8)).build(),
                Match.builder().name("Match Name 10").tournament(tournaments.get(9)).build());
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

    public static List<Tournament> tournamentSupplier(List<Team> teams) {
        return Arrays.asList(
                Tournament.builder().name("Tournament Name 1").build(),
                Tournament.builder().name("Tournament Name 2").build(),
                Tournament.builder().name("Tournament Name 3").build(),
                Tournament.builder().name("Tournament Name 4").build(),
                Tournament.builder().name("Tournament Name 5").build(),
                Tournament.builder().name("Tournament Name 6").build(),
                Tournament.builder().name("Tournament Name 7").build(),
                Tournament.builder().name("Tournament Name 8").build(),
                Tournament.builder().name("Tournament Name 9").build(),
                Tournament.builder().name("Tournament Name 10").build());
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

    public static List<TeamTournament> teamTournamentSupplier(List<Team> teams, List<Tournament> tournaments) {
        return Arrays.asList(
                TeamTournament.builder().team(teams.get(0)).tournament(tournaments.get(0)).build(),
                TeamTournament.builder().team(teams.get(1)).tournament(tournaments.get(1)).build(),
                TeamTournament.builder().team(teams.get(2)).tournament(tournaments.get(2)).build(),
                TeamTournament.builder().team(teams.get(3)).tournament(tournaments.get(3)).build(),
                TeamTournament.builder().team(teams.get(4)).tournament(tournaments.get(4)).build(),
                TeamTournament.builder().team(teams.get(5)).tournament(tournaments.get(5)).build(),
                TeamTournament.builder().team(teams.get(6)).tournament(tournaments.get(6)).build(),
                TeamTournament.builder().team(teams.get(7)).tournament(tournaments.get(7)).build(),
                TeamTournament.builder().team(teams.get(8)).tournament(tournaments.get(8)).build(),
                TeamTournament.builder().team(teams.get(9)).tournament(tournaments.get(9)).build());
    }

    public static List<TeamMatch> teamMatchSupplier(List<Team> teams, List<Match> matches) {
        return Arrays.asList(
                TeamMatch.builder().team(teams.get(0)).match(matches.get(0)).build(),
                TeamMatch.builder().team(teams.get(1)).match(matches.get(1)).build(),
                TeamMatch.builder().team(teams.get(2)).match(matches.get(2)).build(),
                TeamMatch.builder().team(teams.get(3)).match(matches.get(3)).build(),
                TeamMatch.builder().team(teams.get(4)).match(matches.get(4)).build(),
                TeamMatch.builder().team(teams.get(5)).match(matches.get(5)).build(),
                TeamMatch.builder().team(teams.get(6)).match(matches.get(6)).build(),
                TeamMatch.builder().team(teams.get(7)).match(matches.get(7)).build(),
                TeamMatch.builder().team(teams.get(8)).match(matches.get(8)).build(),
                TeamMatch.builder().team(teams.get(9)).match(matches.get(9)).build()
        );
    }
}