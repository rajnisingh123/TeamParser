import com.testVegrant.pojo.Player;
import com.testVegrant.utils.Utils;
import org.testng.annotations.BeforeSuite;

import java.util.List;

public class BaseTest {

    protected List<Player> playerList;

    @BeforeSuite
    public void loadTestFile()
    {
        playerList=Utils.getUtils().readJsonFile("TeamRCB");
    }
}
