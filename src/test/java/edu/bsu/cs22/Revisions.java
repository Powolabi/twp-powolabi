package edu.bsu.cs22;

import edu.bsu.cs222.WikiConnection;
import edu.bsu.cs222.WikiParser;
import net.minidev.json.JSONArray;

import java.io.IOException;

public class Revisions {
    private final WikiConnection Connection = new WikiConnection();
    public String FormattedRevision1 = "";
    public String FormattedRevision2 = "";
    public String FormatRevisions(String articleTitle) throws IOException {
        WikiParser parser = new WikiParser();
        JSONArray TimeStamp = parser.timeStampParser(Connection.Connection(articleTitle));
        JSONArray Username = parser.editorParser(Connection.Connection(articleTitle));
        JSONArray redirects = parser.redirectParser(Connection.Connection(articleTitle));
        for(int i=0; i<TimeStamp.size(); i++)
        {
            FormattedRevision2 = FormattedRevision1;
            FormattedRevision1 = FormattedRevision1  + TimeStamp.get(i) + " " + Username.get(i) + "\n";
        }
        System.out.println(redirects.toString());
        if (redirects.toString().equals("[]")){
            return articleTitle + "\n" +
                    "Most Resent Revisions" +"\n" +
                    FormattedRevision1;
        } else {
            return articleTitle + " redirected to " + redirects + "\n" +
                    "Most Resent Revisions" + "\n" +
                    FormattedRevision1;
        }
    }

}
