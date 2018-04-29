package com.mygdx.projectk.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Dino {
    private int speedx; // 100 to start
    private boolean hasJumped = false;
    private float groundEdge;

    private static final byte GRAVITY = -25;
    private static final byte WIDTH = 50;
    private static final byte HEIGHT = 50;
    private static final byte[] dimensions = {WIDTH, HEIGHT};

    private Vector2 velocity;
    private Vector2 position;

    private Rectangle hitbox;

    private Texture dino;

    public Dino (int x, int y, float groundEdge) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);

        dino = new Texture("dino.png");
        dino.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        hitbox = new Rectangle(x, y, WIDTH, HEIGHT);

        speedx = 200;

        this.groundEdge = groundEdge;
    }

    public void update(float deltaTime, boolean collided) {
        if (position.y > groundEdge + 1 || hasJumped) {
            velocity.add(0, GRAVITY);
            velocity.scl(deltaTime);
            hasJumped = false;
        }
        else {
            velocity.y = 0;
            position.y = groundEdge;
        }

        if (!collided)
            position.add(speedx * deltaTime, velocity.y);

        velocity.scl(1 / deltaTime);


        hitbox.setPosition(position.x, position.y);
        System.out.println(position.y);

    }

    public void jump () {
        if (position.y <= groundEdge) {
            hasJumped = true;
            velocity.y = 600;
        }
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
