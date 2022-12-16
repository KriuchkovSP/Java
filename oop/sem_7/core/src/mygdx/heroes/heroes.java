package mygdx.heroes;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

import mechanic.Mechanic;

public class heroes extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Map<String, MyAtlasAnim> animMap = new HashMap<>();
	TextureAtlas atlas;
	MyAtlasAnim anim1;
	static final float SCALE = 60;
	float time;
	Mechanic gameHero;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("CmBkCur.png");
		atlas = new TextureAtlas("atlas/unnamed.atlas");
		gameHero = new Mechanic();
		animMap.put("anim1_stand", new MyAtlasAnim(atlas, "stay", 12, Animation.PlayMode.LOOP));
		animMap.put("anim1_walk", new MyAtlasAnim(atlas, "scwalk", 12, Animation.PlayMode.LOOP));
		animMap.put("anim1_fire", new MyAtlasAnim(atlas, "shot", 12, Animation.PlayMode.LOOP));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		float mx = Gdx.input.getX();
		float my = Gdx.graphics.getHeight() - Gdx.input.getY();

		animMap.get("anim1_stand").setTime(Gdx.graphics.getDeltaTime());
		animMap.get("anim1_fire").setTime(Gdx.graphics.getDeltaTime());
		animMap.get("anim1_walk").setTime(Gdx.graphics.getDeltaTime());

		batch.begin();
		batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		
		for (int i = 0; i < Mechanic.darkside.size(); i++) {
			if (Mechanic.darkside.get(i).fire) batch.draw(animMap.get("anim1_fire").getFrame(), Mechanic.darkside.get(i).position.x*SCALE, Mechanic.darkside.get(i).position.y*SCALE);
			else if (Mechanic.darkside.get(i).move) batch.draw(animMap.get("anim1_walk").getFrame(), Mechanic.darkside.get(i).position.x*SCALE, Mechanic.darkside.get(i).position.y*SCALE);
			else batch.draw(animMap.get("anim1_stand").getFrame(), Mechanic.darkside.get(i).position.x*SCALE, Mechanic.darkside.get(i).position.y*SCALE);
		}

		for (int i = 0; i < Mechanic.lightside.size(); i++) {
			if (Mechanic.lightside.get(i).fire) batch.draw(animMap.get("anim1_fire").getFrame(), Mechanic.lightside.get(i).position.x*SCALE, Mechanic.lightside.get(i).position.y*SCALE);
			else if (Mechanic.lightside.get(i).move) batch.draw(animMap.get("anim1_walk").getFrame(), Mechanic.lightside.get(i).position.x*SCALE, Mechanic.lightside.get(i).position.y*SCALE);
			else batch.draw(animMap.get("anim1_stand").getFrame(), Mechanic.lightside.get(i).position.x*SCALE, Mechanic.lightside.get(i).position.y*SCALE);
		}

		
		batch.end();
		for (int i = 0; i < Mechanic.NUMHEROTOCREATE; i++) {
			Mechanic.darkside.get(i).time += Gdx.graphics.getDeltaTime();
			Mechanic.lightside.get(i).time += Gdx.graphics.getDeltaTime();
		}
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
