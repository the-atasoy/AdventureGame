package AdventureGame.Locations.NormalLocations;

import AdventureGame.Game;
import AdventureGame.Inventory;
import AdventureGame.Locations.Location;

public abstract class NormalLocation extends Location {

    public NormalLocation(Game game, String name, int id) {
        super(game, name, id);
    }

    @Override
    public void LocationCase() {

    }
}
