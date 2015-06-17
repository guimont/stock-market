package controllers;

import models.parser.ParserGeneral;
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




    public Result fetchAll() {
        return ok("fetch all done");
    }

    public Result fetch() {
        ParserGeneral.loader();
        return ok("in progress");
    }



}