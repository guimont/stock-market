package models.parser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import play.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * Created by gmo on 17/06/2015.
 */
public class ParserGeneral {

    static String cac40 = "http://bourse.lesechos.fr/bourse/actions/cours_az.jsp?select_fMARCHE_COURS=ind_FR0003500008&col=&ord=&page=&lettre=A";
    static String refStcok = "<tr data-item=\"actionsParisTr\"";

    public static void loader() {

        try {
            String text= ParserCommon.loadUrl(new URL(cac40));

            String res[] = text.split(refStcok);
            Document doc = Jsoup.parse(text);


        } catch (IOException e) {
            Logger.error("cannot load url data",e);
        }

    }


}
