package Structures;

public class Vector2 {
    public double x;
    public double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 add(Vector2 other) {
        return new Vector2 (this.x + other.x, this.y + other.y);
    }

    public Vector2 sub(Vector2 other) {
        return new Vector2 (this.x - other.x, this.y - other.y);
    }

    public Vector2 mult(Vector2 other) {
        return new Vector2 (this.x * other.x, this.y * other.y);
    }

    public Vector2 mult(double other) {
        return new Vector2 (this.x * other, this.y * other);
    }

    public Vector2 div(Vector2 other) {
        return new Vector2 (this.x / other.x, this.y / other.y);
    }

    public Vector2 div(double other) {
        return new Vector2 (this.x / other, this.y / other);
    }

    public double magnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector2 normalize() {
        double mag = this.magnitude();
        return new Vector2(this.x / mag, this.y / mag);
    }

    public double dot(Vector2 other) {
        return this.x * other.x + this.y * other.y;
    }

    public double distance(Vector2 other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    //i do not know
    //chec this https://discussions.unity.com/t/how-do-i-find-the-closest-point-on-a-line/588895/3
    public Vector2 nearestPointInLine(Vector2 linePoint, Vector2 lineDir, Vector2 point) {
        lineDir = lineDir.normalize();
        Vector2 v = point.sub(linePoint);
        var d = v.dot(lineDir);
        return linePoint.add(lineDir.mult(d));
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
