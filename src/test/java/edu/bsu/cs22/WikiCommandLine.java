package edu.bsu.cs22;

import java.io.IOException;

public class WikiCommandLine {
    public static void main(String[] args) throws IOException {
        getWikiTitle title = new getWikiTitle();
        Revisions Format = new Revisions();
        String articleTitle = title.getArticleTitle();
        String FormattedRevisions = Format.FormatRevisions(articleTitle);
        System.out.println(FormattedRevisions);
        System.exit(0);
    }
}
