package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ball {

	private Texture texture;
	private Rectangle bounds;
	private Vector2 position;
	private float verticalVelocity,horizontalVelocity;
	private int[] directions = {-1,1};
	int lifes = 3;
	public Ball() {

		texture = new Texture("assets/kulka.png");
		position = new Vector2(MainClass.WIDTH / 2 - texture.getWidth() / 2, 15);
		bounds = new Rectangle(position.x, position.y, texture.getHeight(), texture.getWidth());
		verticalVelocity = 10;
		horizontalVelocity =  8*directions[MathUtils.random(0, 1)];
	}


	
	public void update() {
		this.position.y = this.position.y + verticalVelocity*Gdx.graphics.getDeltaTime()*30;
		if(position.x>=640)
		{
			horizontalVelocity = horizontalVelocity*-1;
		}
		if(position.x<=0)
		{
			horizontalVelocity = horizontalVelocity*-1;
		}
		if(position.y==480)
		{
			verticalVelocity = -10;
		}
		if(position.y==0)
		{
			verticalVelocity = -10;
		}
		this.position.x = this.position.x + horizontalVelocity*Gdx.graphics.getDeltaTime()*30;
		bounds.y = position.y;
		bounds.x = position.x;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////// GETTER && SETTERS///////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Vector2 getPositon() {
		return position;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setPosition(float x, float y) {
		this.position.x = x;
		this.position.y = y;
	}



	public float getVerticalVelocity() {
		return verticalVelocity;
	}

	public void setVerticalVelocity(float verticalVelocity) {
		this.verticalVelocity = verticalVelocity;
	}

	public float getHorizontalVelocity() {
		return horizontalVelocity;
	}

	public void setHorizontalVelocity(float horizontalVelocity) {
		this.horizontalVelocity = horizontalVelocity;
	}
	
	

}
