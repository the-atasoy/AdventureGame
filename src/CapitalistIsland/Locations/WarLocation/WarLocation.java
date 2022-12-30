package CapitalistIsland.Locations.WarLocation;

import CapitalistIsland.Game;
import CapitalistIsland.Locations.Location;

public abstract class WarLocation extends Location {
    public WarLocation(Game game, String name, int id) {
        super(game, name, id);
    }

    @Override
    public abstract void LocationCase();
}
