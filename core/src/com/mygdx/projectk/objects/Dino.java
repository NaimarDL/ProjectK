package com.mygdx.projectk.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Dino {
    private int speedx; // 300 to start
    private static final byte GRAVITY = -49;
    private static final byte WIDTH = 50;
    private static final byte HEIGHT = 50;
    private static final byte[] dimensions = {WIDTH, HEIGHT};

    private Vector2 velocity;
    private Vector2 position;

    private Rectangle hitbox;

    private Texture dino;

    public Dino (int x, int y) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);

        dino = new Texture("square.png");
        dino.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        hitbox = new Rectangle(x, y, WIDTH, HEIGHT);

        speedx = 100;
    }

    public void update(float deltaTime, float groundEdge, boolean collided) {
        if (position.y > groundEdge) {
            velocity.add(0, GRAVITY);
            velocity.scl(deltaTime);
        }

        if (!collided)
            position.add(speedx * deltaTime, velocity.y);

        velocity.scl(1 / deltaTime);

        hitbox.setPosition(position.x, position.y);

//        System.out.println(deltaTime);
//        position.add(speedx * deltaTime, 0);
    }

    public void jump () {
        velocity.y = 100;
    }

    public Texture getTexture () {
        return dino;
    }

    public Vector2 getPosition () {
        return position;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public byte[] getDimensions() {
        return dimensions;
    }

    public void dispose () {
        dino.dispose();
    }
}
