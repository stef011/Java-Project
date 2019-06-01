package entity.element.aliveElement;

import entity.Map;
import entity.element.Direction;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

public class Mob extends AliveElement {
	
	private boolean aggro;
	private static final String spritePath = "/sprites/mobs/";
	private static final String imageName = "mob.gif";
	private static final char sprite_ref = 'M';
	private static final TraversableByAlive traversableByAlive = TraversableByAlive.Mob;
	private static final TraversableByFalling traversableByFalling = TraversableByFalling.Alive;
	
	private static final Sprite sprite = new Sprite(sprite_ref, spritePath, imageName);
	
	public Mob(Map map, Position position) {
		super(map, position);
		sprite.loadImage();
		this.setSprite(sprite);
		this.setAggro(false);		
		this.setTraversableByAlive(traversableByAlive);
		this.setTraversableByFalling(traversableByFalling);
	}
	
	public Mob() {
		
	}
	
	public Direction checkOnLeft(Direction lastMove) {
		switch(lastMove) {
		case Up:
			return Direction.Left;
		case Left:
			return Direction.Down;
		case Down:
			return Direction.Right;
		case Right:
			return Direction.Up;
		}
		return lastMove;
	}
	
	public void activate() {
		Direction direction;
		if(this.isAggro()) {
			direction = this.getMap().getPlayer().getLastMove();
		} else if(this.checkAlivePermeability(this.getLastMove())==TraversableByAlive.Traversable || this.checkAlivePermeability(this.getLastMove())==TraversableByAlive.Player) {
			direction = this.getLastMove();
		} else if(this.checkAlivePermeability(this.checkOnLeft(this.getLastMove()))==TraversableByAlive.Traversable || this.checkAlivePermeability(this.checkOnLeft(this.getLastMove()))==TraversableByAlive.Player) {
			direction = this.checkOnLeft(this.getLastMove());
		} else if(this.checkAlivePermeability(this.checkOnLeft(this.checkOnLeft(this.getLastMove())))==TraversableByAlive.Traversable || this.checkAlivePermeability(this.checkOnLeft(this.checkOnLeft(this.getLastMove())))==TraversableByAlive.Player) {
			direction = this.checkOnLeft(this.checkOnLeft(this.getLastMove()));
		} else {
			direction = this.checkOnLeft(this.checkOnLeft(this.checkOnLeft(this.getLastMove())));
		}
		this.move(direction);
	}
	
	@Override
	public void move(Direction direction) {
		switch(this.checkAlivePermeability(direction)) {
		case Traversable:
			super.move(direction);
			break;
		case Player:
			this.getMap().getPlayer().die();
			break;
		case Breakable:
		case Blocking:
		case Pushable:
		case Pickable:
		case Mob:
		default:
			this.doNothing();
			break;
		}
	}
	
	@Override
	public void die() {
		super.die();
		this.getMap().getMobs().remove(this);
		this.blow();
		
	}
	
	public void blow() {
		this.replaceByDiamond();
		this.lookAtNextBlock(Direction.Up).replaceByDiamond();
		this.lookAtNextBlock(Direction.Left).replaceByDiamond();
		this.lookAtNextBlock(Direction.Down).replaceByDiamond();
		this.lookAtNextBlock(Direction.Right).replaceByDiamond();
		this.lookAtNextBlock(Direction.Up).lookAtNextBlock(Direction.Left).replaceByDiamond();
		this.lookAtNextBlock(Direction.Up).lookAtNextBlock(Direction.Right).replaceByDiamond();
		this.lookAtNextBlock(Direction.Down).lookAtNextBlock(Direction.Left).replaceByDiamond();
		this.lookAtNextBlock(Direction.Down).lookAtNextBlock(Direction.Right).replaceByDiamond();
	}
	
	public void takeAggro() {
		
	}

	public boolean isAggro() {
		return this.aggro;
	}

	public void setAggro(boolean aggro) {
		this.aggro = aggro;
	}
	
}
