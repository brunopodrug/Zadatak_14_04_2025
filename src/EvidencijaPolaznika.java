import java.util.HashSet;
import java.util.Scanner;

public class EvidencijaPolaznika {
    public static void main(String[] args) {
        HashSet<Polaznik> listaPolaznika = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Unesite broj za izabranu akciju: ");
            System.out.println("1.) Unesite novog korisnika u listu.");
            System.out.println("2.) Ispisi sve polaznike.");
            System.out.println("3.) Pretraga korisnika po e-mail adresi.");
            System.out.println("4.) Unesite 4 ili ne ako zelite zatvoriti program");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("ne") || input.equals("4"))
                break;

            switch (input) {
                case "1" -> {
                    System.out.println("Unesite ime polaznika: ");
                    String ime = sc.nextLine();
                    System.out.println("Unesite prezime polaznika: ");
                    String prezime = sc.nextLine();
                    System.out.println("Unesite e-mail polaznika: ");
                    String email = sc.nextLine();
                    Polaznik temp = new Polaznik(ime, prezime, email);
                    boolean isitKorisnik = false;
                    // Dodaj novog korisnika ako je lista prazna
                    if (listaPolaznika.isEmpty())
                        listaPolaznika.add(temp);
                        // Ako lista nije prazna, provjeri je li novi korisnik ima isti mail kao netko iz liste
                    else {
                        for (Polaznik p : listaPolaznika) {
                            if (temp.getMail().equals(p.getMail())) {
                                System.out.println("Uneseni korisnik se vec nalazi u listi.");
                                System.out.println("Neuspjelo dodavanje polaznika.");
                                listaPolaznika.remove(temp);
                                isitKorisnik = true;
                                break;
                            }
                        }
                    }
                    // Ne postoji vec unesen polaznik, dodaj ga u listu
                    if (!isitKorisnik) {
                        System.out.println("Uspjesno dodavanje polaznika u evidenciju.");
                        listaPolaznika.add(temp);
                    }
                    System.out.println("----------------------------");
                }
                case "2" -> {
                    for (Polaznik polaznik : listaPolaznika) {
                        System.out.println(polaznik);
                    }
                    System.out.println("----------------------------");
                }
                case "3" -> {
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
                    System.out.println("----------------------------");
                }
                default -> {
                    System.out.println("Krivo unesena akcija, pokušajte ponovno.");
                    System.out.println("----------------------------");
                }
            }
        } while (true);
        sc.close();
    }
}
