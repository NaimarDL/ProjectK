package com.mygdx.projectk.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.projectk.objects.Ground;

public class PlayState extends State {
    private static final int SCREEN_WIDTH = 1920;
    private static final int SCREEN_HEIGHT = 1080;
    private Array<Ground> grounds;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, SCREEN_WIDTH/2, SCREEN_HEIGHT/2);

        grounds = new Array<Ground>();

        for (int i = 0; i < 2; i++)
            grounds.add(new Ground(i * (int)camera.viewportWidth, 0, "ground.jpg", SCREEN_WIDTH, SCREEN_HEIGHT));
    }

    @Override
    protected void handleInput() {

    }

    @Override
    protected void update(float deltaTime) {
        camera.position.set(SCREEN_WIDTH/4, SCREEN_HEIGHT/4, 0);

        for (Ground ground : grounds)
            ground.update(camera.position.x - camera.viewportWidth / 2);
    }

    @Override
    protected void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();

        for (Ground ground : grounds) {
            sb.draw(ground.getTexture(), ground.getPosition().x, 0, camera.viewportWidth, camera.viewportHeight/15);

        }

        sb.end();
    }

    @Override
    public void dispose() {
        for (Ground ground : grounds)
            ground.dispose();
    }
}
