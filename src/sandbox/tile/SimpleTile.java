package sandbox.tile;

import engine.core.Tile.Tile;
import engine.core.Transform;
import engine.gfx.Sprite;

public class SimpleTile extends Tile {

    public SimpleTile(Sprite texture, String name) {
        super(new Transform(), name, texture);
    }

}