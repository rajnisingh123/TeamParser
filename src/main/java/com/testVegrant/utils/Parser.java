package com.testVegrant.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testVegrant.pojo.Player;
import com.testVegrant.pojo.TeamRCB;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static void main(String args[]) throws IOException {
        ObjectMapper mapper= Utils.getUtils().getMapper();
        TeamRCB team=mapper.readValue(new File("src/main/resources/TeamRCB.json"), TeamRCB.class);
        List<Player> ls=team.getPlayer();
        System.out.println(ls.size());
        List<Player> internationPlayers =
                ls.stream().
                        filter(p -> !p.getCountry().equals("India")).
                        collect(Collectors.toList());
        List<Player> wicketKeeper =
                ls.stream().
                        filter(p -> p.getRole().equalsIgnoreCase("Wicket-keeper")).
                        collect(Collectors.toList());
        System.out.println("International Player :"+internationPlayers);
        System.out.println("Wickekeeper Player :"+wicketKeeper);

    }
}
