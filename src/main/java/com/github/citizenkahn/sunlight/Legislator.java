package com.github.citizenkahn.sunlight;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Data Access Object for Legislator Sunglight Congress API v3
 * Created by pkahn on 10/9/2016.
 */
public class Legislator {
    private String bioguide_id;
    private String birthday;
    private String chamber;
    private String contact_form;
    private String district;
    private String facebook_id;
    private String first_name;
    private String gender;
    private String last_name;
    private String govtrack_id;
    private boolean in_office;
    private String name_suffix;

    public Legislator() {}

    /**
     * Create Legislator instrance from file
     * @param jsonFile file containing json text
     * @return Legislator object
     * @throws IOException on file access
     */
    public static Legislator createFromFile(File jsonFile) throws IOException {
        String content = new Scanner(jsonFile).useDelimiter("\\Z").next();
        return Legislator.crateFromJson(content);
    }

    /**
     * Create Legislator instance from json string
     * @param json json string
     * @return Legislator object
     */
    public static Legislator crateFromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Legislator.class);

    }

    public String getFirstName() {
        return first_name;
    }

    public boolean isInOffice() {
        return in_office;
    }
}
