package AdventureGame.Locations.WarLocation;

import AdventureGame.Game;
import AdventureGame.Locations.Location;

public abstract class WarLocation extends Location {
    public WarLocation(Game game, String name, int id) {
        super(game, name, id);
    }

    @Override
    public abstract void LocationCase();
}
