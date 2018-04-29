package com.mygdx.projectk.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.projectk.objects.Dino;
import com.mygdx.projectk.objects.Ground;

public class PlayState extends State {
    private static final int SCREEN_WIDTH = 1920;
    private static final int SCREEN_HEIGHT = 1080;
    private Array<Ground> grounds;

    private Dino dino;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);

        grounds = new Array<Ground>();

        for (int i = 0; i < 2; i++)
            grounds.add(new Ground(i * (int)camera.viewportWidth, 0, "ground.jpg", camera.viewportWidth, SCREEN_HEIGHT));

        dino = new Dino(50, (int)camera.viewportHeight/15, camera.viewportHeight/15);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            dino.jump();
        }
    }

    @Override
    protected void update(float deltaTime) {
        handleInput();

        dino.update(deltaTime, false);
        camera.position.set(dino.getPosition().x + 430, camera.viewportHeight/2, 0);

        for (Ground ground : grounds)
            ground.update(camera.position.x - camera.viewportWidth / 2);


        camera.update();
    }

    @Override
    protected void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();

        for (Ground ground : grounds) {
            sb.draw(ground.getTexture(), ground.getPosition().x, 0, camera.viewportWidth, camera.viewportHeight/15);

        sb.draw(dino.getTexture(), dino.getPosition().x, dino.getPosition().y, dino.getDimensions()[0], dino.getDimensions()[1]);

        }

        sb.end();
    }

    @Override
    public void dispose() {
        for (Ground ground : grounds)
            ground.dispose();

        dino.dispose();
    }
}
