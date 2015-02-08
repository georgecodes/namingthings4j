package com.elevenware.nyaaas;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YamlLoader {

    public static void loadYaml(InputStream inputStream, TaggedWordBucket wordBucket, Tag...tags) {

        Yaml yaml = new Yaml();
        Map<String, Object> base = (Map<String, Object>) yaml.load(inputStream);

    }

}
