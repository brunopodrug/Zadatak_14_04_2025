import java.util.ArrayList;
import java.util.Scanner;

public class EvidencijaPolaznika {
    public static void main(String[] args) {
        ArrayList<Polaznik> listaPolaznika = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Unesite broj za izabranu akciju: ");
            System.out.println("1.) Unesite novog korisnika u listu.");
            System.out.println("2.) Ispisi sve polaznike.");
            System.out.println("3.) Pretraga korisnika po e-mail adresi.");
            System.out.println("4.) Unesite 4 ili ne ako zelite zatvoriti program");
            String input = sc.nextLine();

            if (input.equals("ne") || input.equals("NE") || input.equals("4"))
                break;

            switch (input) {
                case "1":
                    System.out.println("Unesite ime polaznika: ");
                    String ime = sc.nextLine();
                    System.out.println("Unesite prezime polaznika: ");
                    String prezime = sc.nextLine();
                    System.out.println("Unesite e-mail polaznika: ");
                    String email = sc.nextLine();
                    listaPolaznika.add(new Polaznik(ime, prezime, email));
                    break;
                case "2":
                    for (Polaznik polaznik : listaPolaznika) {
                        System.out.println("Polaznik: " + polaznik);
                    }
                    break;
                case "3":
                    System.out.println("Unesite mail po kojem zelite pretrazili je li postoji polaznik");
                    String mailInput = sc.nextLine();
                    boolean postojiKorisnik = false;
                    for (Polaznik p : listaPolaznika) {
                        if (p.getMail().equals(mailInput)) {
                            System.out.println("Polaznik se nalazi u listi: ");
                            System.out.println(p);
                            postojiKorisnik = true;
                            break;
                        }
                    }
                    if (!postojiKorisnik) {
                        System.out.println("Polaznik ne postoji u listi.");
                    }
                    break;
                default:
                    break;
            }
        } while (true);
        sc.close();
    }
}
