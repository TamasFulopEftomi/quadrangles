package com.eftomi.quadrangles.processlogic;

//A program indulás után jelenítsen meg egy üdvözlő üzenetet!
//        Az üdvözlő üzenet alatt jelenítsen meg egy menüt, ahol a menüpontok 1-től sorfolytonosan vannak megszámozva!
//        Kérje be a program a felhasználótól a választott menüpont sorszámát!
//        Ha helytelen bemenetet ad meg a felhasználó, akkor kezeld le ezt a kivételes helyzetet és jeleníts meg egy
//        felhasználóbarát üzenetet majd kérd be a számot újra!
//
//        A következő menüpontok legyenek legalább elérhetők:
//        - négyzet
//        - téglalap
//        - parallelogramma
//        - rombusz
//        - deltoid
//
//        Ezeken kívül legyen még egy utolsó menüpont, a kilépés!
//        Ezt választva a program jelenítsen meg egy búcsú üzenetet és álljon le!
//        Ha a felhasználó az egyik alakzatot választja, akkor kérd be az ahhoz az alakzathoz tartozó bemeneti adatokat.
//        Például négyzet esetén az egyetlen oldalhosszúságot, téglalap esetén a két oldalhosszúságot!
//        Ezek a bemeneti adatok nem csak egy számértéket tartalmaznak, hanem egy mértékegységet is.
//        Például 3 cm vagy 4,5 dm, vagy 100 m.
//        A különböző bemeneti adatok különböző mértékegységekben lehetnek megadva.
//        Ezek után a program számolja ki az adott alakzathoz tartozó kerületet és területet.
//        Ezeknek az eredményeknek az értékét írja ki először SI mértékegységben, majd opcionálisan más mértékegységekben is!
//        A számítás és az eredmény megjelenítése után a program térjen vissza a menübe, azt újra írja ki,
//        majd a felhasználó újra választhasson egy alakzatot!
//
//        A megoldásod során törekedj alkalmazni minden olyan programozási eszközt, amiről eddig tanultunk!
//        Különösen ügyelj az OOP elvek követésére, alkalmazd az OOP-s elveket,
//        használd az ehhez tartozó nyelvi lehetőségeket. Figyelj oda a változók, típusok elnevezésére, tömör,
//        de beszédes angol azonosítókat válassz! Kövesd a Java elnevezési és formázási konvencióit! Alkalmazz kivételkezelést, ahol indokolt!

import com.eftomi.quadrangles.businesslogic.Quadrangle;
import com.eftomi.quadrangles.businesslogic.IQuadrangle;

import java.util.Scanner;

public class Process {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new Process().run(scanner);
        }


    }

    private void run(Scanner scanner) {
        UserInputReader uir = new UserInputReader(scanner);
        int select = uir.readUserInput();
        IQuadrangle IQuadrangle = Quadrangle.chooseQuadrangle(select);

        IQuadrangle.readQuadrangleData(scanner);

    }
}
