package entity.element.aliveElement;

import entity.Map;
import entity.element.Direction;
import entity.element.Position;
import entity.element.Sprite;
import entity.element.TraversableByAlive;
import entity.element.TraversableByFalling;

public class Mob extends AliveElement {
	
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
		default:
			break;
		}
		return lastMove;
	}
	
	public void moveMobs() {
		Direction direction;
		if(this.checkAlivePermeability(this.getLastMove())==TraversableByAlive.Traversable || this.checkAlivePermeability(this.getLastMove())==TraversableByAlive.Player) {
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
			this.setLastMove(direction);
			super.move(direction);
			break;
		case Player:
			this.getMap().getPlayer().die();
			break;
		default:
			break;
		}
	}
	
	@Override
	public void die() {
		super.die();
		this.blow();
		this.getMap().getMobs().remove(this);
	}
	
	public void blow() {
		this.replaceByDiamond();
		this.lookAtNextBlock(Direction.Up).replaceByDiamond();
		this.lookAtNextBlock(Direction.Left).replaceByDiamond();
		this.lookAtNextBlock(Direction.Down).replaceByDiamond();
		this.lookAtNextBlock(Direction.Right).replaceByDiamond();
		this.lookAtNextBlock(Direction.RightUp).replaceByDiamond();
		this.lookAtNextBlock(Direction.RightDown).replaceByDiamond();
		this.lookAtNextBlock(Direction.LeftDown).replaceByDiamond();
		this.lookAtNextBlock(Direction.LeftUp).replaceByDiamond();
	}

}
