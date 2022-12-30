package CapitalistIsland.Locations.NormalLocations;

import CapitalistIsland.Game;
import CapitalistIsland.Locations.Location;

public abstract class NormalLocation extends Location {

    public NormalLocation(Game game, String name, int id) {
        super(game, name, id);
    }

    @Override
    public void LocationCase() {

    }
}
