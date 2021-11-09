package com.insights.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.solr.core.query.result.FacetFieldEntry;

import java.util.Map;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(value = "rangeTranslation")
public class DurationBin extends Bin{
    /*
     * Reshaping the data to provide semantic organization
     */
    public DurationBin(FacetFieldEntry entry){
        super(Map.of("0", "0-60", "60", "60-120", "120", "120-180", "180", "180-240"), entry.getValue(), entry.getValueCount());
    }
}
