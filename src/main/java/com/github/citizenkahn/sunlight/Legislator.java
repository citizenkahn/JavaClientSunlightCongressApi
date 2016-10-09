package com.github.citizenkahn.sunlight;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

/**
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

    public Legislator() {}

    /**
     * Create Legislator instrance from file
     * @param jsonFile file containing json text
     * @return Legislator object
     * @throws IOException
     */
    public static Legislator createFromFile(File jsonFile) throws IOException {
        byte [] encoded = Files.readAllBytes(jsonFile.toPath());
        return Legislator.crateFromJson(new String(encoded, Charset.defaultCharset()));
    }

    /**
     * Create Legislator instance from json string
     * @param json json string
     * @return Legislator object
     */
    public static Legislator crateFromJson(String json) {
        Gson gson = new Gson();
        Legislator legislator = gson.fromJson(json, Legislator.class);
        return legislator;

    }

    public String getFirstName() {
        return first_name;
    }
}
