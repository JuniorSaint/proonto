package br.com.proonto.services;

import br.com.proonto.configs.Utils;
import br.com.proonto.exceptions.BadRequestException;
import br.com.proonto.exceptions.ErrorUploadFileException;
import br.com.proonto.models.entities.Dictionary;
import br.com.proonto.repositories.DictionaryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FileHtmlService {
    @Autowired
    private DictionaryRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Utils utils;
    public static final String FILE_PATH = "/Volumes/Arquivo/SpringBoot/proonto/src/main/webapp/ReaderFile.ftlh";


    public List<String> recordDataToDb() throws IOException {
        String regex = "\\@\\_(.*?)\\_\\@";
        Pattern parttern = Pattern.compile(regex);
        File myObj = new File(FILE_PATH);
        List<String> result = new ArrayList<>();
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                Matcher l = parttern.matcher(line);
                while (l.find()) {
                    String rest = l.group();
                    String test = changeExpression(rest);
                    result.add(l.replaceAll(test));
                }
            }
        } catch (Exception e) {
            throw new BadRequestException(
                    "Could not store file. Please try again!, " + e);
        }
        return result;
    }

    private String changeExpression(String str) {
        Optional<Dictionary> result = repository.findByFromDic(str);
        if(result.isEmpty()){
           throw new BadRequestException("expression doesn't exist in dictionary: " + str);
        }
        return result.get().getToDic();
    }
}