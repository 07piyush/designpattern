package structuralDesignPattern.composite;

public interface Shape {

	void draw();
	void move(int x, int y);
	void resize(int scale);
}
