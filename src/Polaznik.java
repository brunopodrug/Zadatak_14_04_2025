public class Polaznik {
    private String ime;
    private String prezime;
    private String mail;

    public Polaznik(String ime, String prezime, String mail) {
        this.ime = ime;
        this.prezime = prezime;
        this.mail = mail;
    }

    public String getIme() {
        return ime;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return "Ime: " + ime + ", prezime: " + prezime + ", e-mail: " + mail;
    }
}
