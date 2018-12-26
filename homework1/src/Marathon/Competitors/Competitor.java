package Marathon.Competitors;

public interface Competitor {

    void run(int distance);

    void swim(int distance);

    void jamp(int height);

    boolean isOnDistance();

    void info();
}
