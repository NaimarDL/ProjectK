package com.mygdx.projectk.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayState extends State {
    private Texture image;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 960, 540);


        image = new Texture("badlogic.jpg");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    protected void update(float deltaTime) {

    }

    @Override
    protected void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(image, 100, 100);
        sb.end();
    }

    @Override
    public void dispose() {
        image.dispose();
    }
}
