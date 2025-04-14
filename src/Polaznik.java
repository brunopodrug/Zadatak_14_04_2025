import javax.print.DocFlavor;

public class Polaznik implements Comparable<Polaznik>{
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

    // Poboljšana implementacija equals metode kako bi HashSet mogao uspoređivati polaznike po emailu
    @Override
    public boolean equals(Object anObject) {
        if (this == anObject)
            return true;
        if (anObject == null || anObject.getClass() != getClass())
            return false;

        Polaznik polaznik = (Polaznik) anObject;
        return mail.equals(polaznik.mail);
    }

    // Poboljšana implementacija hashCode metode kako bi HashSet mogao ispravno pohraniti polaznike
    @Override
    public int hashCode() {
        return mail.hashCode();
    }

    @Override
    public int compareTo(Polaznik o) {
        return this.getMail().compareTo(o.getMail());
    }
}
