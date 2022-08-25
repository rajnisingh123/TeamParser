package com.testVegrant.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testVegrant.common.Constants;
import com.testVegrant.pojo.Player;
import com.testVegrant.pojo.TeamRCB;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private static Utils utils;
    public  ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper;
    }

    public  List<Player> getForginerPlayerList(List<Player> playersList)
    {
       return playersList.stream().
                filter(player -> !player.getCountry().equals(Constants.INDIA)).
                collect(Collectors.toList());
    }

    public  List<Player> getWicketKeeperList(List<Player> playersList)
    {
        return  playersList.stream().
                filter(player -> player.getRole().equalsIgnoreCase(Constants.WICKET_KEEPER)).
                collect(Collectors.toList());
    }

    public  List<Player> readJsonFile(String fileName)
    {
        ObjectMapper mapper= Utils.getUtils().getMapper();
        TeamRCB team= null;
        try {
            team = mapper.readValue(new File(Constants.SRC_MAIN_RESOURCES + fileName + Constants.JSON), TeamRCB.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  team.getPlayer();
    }

    public static Utils getUtils() {
        if (utils == null)
            utils = new Utils();
        return utils;
    }
}
