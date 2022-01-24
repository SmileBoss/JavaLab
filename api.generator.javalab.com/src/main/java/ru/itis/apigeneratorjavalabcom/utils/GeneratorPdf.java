package ru.itis.apigeneratorjavalabcom.utils;

import com.itextpdf.html2pdf.HtmlConverter;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.itis.apigeneratorjavalabcom.models.dao.Statements;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class GeneratorPdf {

    private final static Logger log = LoggerFactory.getLogger(GeneratorPdf.class);

    public byte[] generate(Statements statements) throws Exception {
        ByteArrayOutputStream htmlOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(htmlOutputStream);

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        FileTemplateLoader templateLoader = new FileTemplateLoader(
                new File("templates"));
        cfg.setTemplateLoader(templateLoader);

        Map<String, Object> data = new HashMap<>();

        data.put("name", statements.getFirstname());
        data.put("surname", statements.getLastname());
        data.put("patronymic", statements.getPatronymic());
        data.put("date", statements.getDate());
        log.warn(data.toString());
        Template template = cfg.getTemplate("statement.ftlh");
        template.process(data, outputStreamWriter);

        ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();

        HtmlConverter.convertToPdf(new ByteArrayInputStream(htmlOutputStream.toByteArray()),
                pdfOutputStream);

        return pdfOutputStream.toByteArray();
    }

}
