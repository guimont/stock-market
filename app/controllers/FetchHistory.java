package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by gmo on 16/06/2015.
 */
public class FetchHistory extends Controller {

    String cac40 = "http://bourse.lesechos.fr/bourse/actions/cours_az.jsp?select_fMARCHE_COURS=ind_FR0003500008&col=&ord=&page=&lettre=A";


    public Result fetchAll() {
        return ok("fetch all done");
    }

    public Result fetch() {
        try {
            return ok(loadUrl(new URL(cac40)));
        } catch (IOException e) {
            e.printStackTrace();
            return notFound("cannot load");
        }
    }


    public static String loadUrl(URL url) throws IOException {
        InputStream stream = null;
        try {
            stream = url.openStream();
            return loadStream(stream);
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * Charge le contenu d'un stream dans un string
     *
     * @param stream
     * @return
     * @throws IOException
     */
    public static String loadStream(InputStream stream) throws IOException {
        Reader reader = new InputStreamReader(stream, Charset.forName("UTF-8"));
        char[] buffer = new char[1024];
        int count;
        StringBuilder str = new StringBuilder();
        while ((count = reader.read(buffer)) != -1)
            str.append(buffer, 0, count);
        return str.toString();
    }
}