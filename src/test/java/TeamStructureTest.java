import com.testVegrant.pojo.Player;
import com.testVegrant.utils.Utils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;

public class TeamStructureTest extends BaseTest{

    @Test(description = "Team have maximum 4 foreignerPlayer")
    public void validateNumberOfForeignerPlayerPlayers()
    {
        List<Player> foreignerPlayerList= Utils.getUtils().getForginerPlayerList(playerList);
        Assertions.assertThat(foreignerPlayerList).hasSizeLessThanOrEqualTo(4);
    }

    @Test(description = "Team have at least one wicketKeeper")
    public void validateTeamHaveWicketKeeper()
    {
        List<Player> wicketKeeperList= Utils.getUtils().getWicketKeeperList(playerList);
        Assertions.assertThat(wicketKeeperList).hasSizeGreaterThanOrEqualTo(1);
    }
}
