import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FilmTahminReview {

    /*
     TASK :
      yukarıdaki film listinde bulunan filmlerden herhangi birisini kullanıcının film ismini  görmeden
      filmin index nosuna göre sectiriniz
      seçilen filmin  ismini filmin harf saysının 2 katı kadar hak tanıyarak tahmin etmesini
      sağlayan method create ediniz...
      Ahanda TRICK...
      kullanıcının sectiği filmin harf sayısını  console yazdırınız.
      kullanıcının sectiği film için tahmin hakkını  console yazdırınız.
      kullanıcının her tahmininde kalan hak sayısını console yazdırınız.
      kullanıcının her tahmininde doğru ve yanlış tahmin  sayısını console yazdırınız.
      kullanıcının kaybedip veya kazandığını ve tahmin etmesi gereken filmin ismini  console yazdırınız.

     */
    static Scanner scan = new Scanner(System.in);
    static List<String> filmler = new ArrayList<>(Arrays.asList("JOKER", "INCEPTION", "PIYANIST", "GREENMILE", "LEON", "GODFATHER", "JURASSICPARK", "TITANIC"));
    static int tahminAdedi = 0;
    static int tahminHakkı = 0;


    public static void main(String[] args) {


        baslangic1(filmler,tahminHakkı,tahminAdedi);

    }



    private static void baslangic1(List<String> filmler, int tahminHakkı, int tahminAdedi) {





            System.out.println("1-8 arası bir sayı girniz");
            int scm = scan.nextInt() - 1;


            String secilenFilm = filmler.get(scm);
            StringBuilder harfAdCizgi = new StringBuilder();


            for (int i = 0; i < secilenFilm.length(); i++) {
                harfAdCizgi.append("-");
            }
            tahminHakkı = secilenFilm.length() * 2;

            do {
                System.out.println(harfAdCizgi);
                System.out.println("harf giriniz");
                char harf = scan.next().toUpperCase().charAt(0);

                if (secilenFilm.contains(String.valueOf(harf))) {
                    for (int i = 0; i < secilenFilm.length(); i++) {
                        if (secilenFilm.substring(i, i + 1).equalsIgnoreCase(String.valueOf(harf))) {
                            harfAdCizgi.setCharAt(i, harf);
                        }
                    }
                }
                if (harfAdCizgi.toString().equalsIgnoreCase(secilenFilm)) {
                    System.out.println(secilenFilm);
                    System.out.println("BRAVO!!!!");
                    break;
                }

                tahminAdedi++;
                System.out.println("Tahmin sayacı = " + tahminAdedi + "/" + tahminHakkı);

            } while (tahminAdedi < tahminHakkı);


            if (tahminAdedi == tahminHakkı) {
                    String scm1="";
                do {
                    System.out.println("Baştan oynamak ister misiniz E/H");
                    scm1 = scan.next();
                    if (scm1.equalsIgnoreCase("e")) {
                        tahminAdedi=0;
                        tahminHakkı=0;

                        baslangic1(filmler,tahminHakkı,tahminAdedi);

                    }else if(scm1.equalsIgnoreCase("h")){
                        System.out.println("Allah razı olsun, yine bekleriz, harf verenlerin çok olsun");
                    }

                } while (!scm1.equalsIgnoreCase("e") && !scm1.equalsIgnoreCase("h"));

            }

        }




}
