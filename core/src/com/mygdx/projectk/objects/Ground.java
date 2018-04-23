package com.mygdx.projectk.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ground {
    private Texture ground;
    private Vector2 position;
    private static Rectangle hitbox;
    private float screenWidth;
    private float screenHeight;

    public Ground (int x, int y, String image, float screenWidth, float screenHeight) {
        ground = new Texture(image);
        ground.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        hitbox = new Rectangle(0, 0, screenWidth, screenHeight/15);
        position = new Vector2(x, y);

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

    }

    private void reposition(float leftCorner) {
        position.x = leftCorner + screenWidth;
    }

    public void update (float leftCorner) {
        hitbox.x = leftCorner;

        if (position.x <= leftCorner - screenWidth)
            reposition(leftCorner);

    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return ground;
    }

    public boolean collides (Rectangle object) {
        return object.overlaps(hitbox);
    }

    public void dispose () {
        ground.dispose();
    }
}
