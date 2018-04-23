package com.mygdx.projectk.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {
    protected OrthographicCamera camera;
    private GameStateManager gsm;

    public State(GameStateManager gsm) {
        this.gsm = gsm;
        camera = new OrthographicCamera();
    }

    protected abstract void handleInput ();
    protected abstract void update(float deltaTime);
    protected abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
