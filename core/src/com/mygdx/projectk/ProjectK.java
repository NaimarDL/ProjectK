package com.mygdx.projectk;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.projectk.states.GameStateManager;
import com.mygdx.projectk.states.PlayState;

public class ProjectK extends ApplicationAdapter {
    private GameStateManager gsm;
	private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();

        gsm.push(new PlayState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
