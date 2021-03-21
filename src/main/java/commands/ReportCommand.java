package commands;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import multimedia.Catalog;
import multimedia.InvalidCatalogException;

import java.io.FileWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand extends Command{
    public ReportCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void run() throws InvalidCatalogException {
        Configuration cfg = new Configuration(new Version("2.3.23"));
        cfg.setClassForTemplateLoading(ReportCommand.class, "templates");
        cfg.setDefaultEncoding("UTF-8");
        Template template = null;

        try {
            template = cfg.getTemplate("template.ftl");
        } catch (Exception e) {
            throw new InvalidCatalogException(e.getMessage());
        }

        Map<String, Object> templateData = new HashMap<>();
        templateData.put("name", catalog.getName());
        templateData.put("items", catalog.getItems());


        StringWriter out = new StringWriter();

        FileWriter outs = null;

        try {
            outs = new FileWriter("report/" + catalog.getName()+".html");
            template.process(templateData, out);
            outs.write(out.getBuffer().toString());
            outs.flush();
            out.flush();
        } catch (Exception e) {
            throw new InvalidCatalogException(e.getMessage());
        }
    }
}
