package sample;

interface Subject {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(int stan);
}