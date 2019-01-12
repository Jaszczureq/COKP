package sample;

interface Obserwowany {
    public void dodajObserwatora(Obserwator o);
    public void usunObserwatora(Obserwator o);
    public void powiadamiajObserwatorow();
}