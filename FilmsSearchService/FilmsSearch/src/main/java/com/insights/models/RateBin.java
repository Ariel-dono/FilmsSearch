package com.insights.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.solr.core.query.result.FacetFieldEntry;

import java.util.Map;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(value = "rangeTranslation")
public class RateBin extends Bin{
    /*
     * Reshaping the data to provide semantic organization
    */
    public RateBin(FacetFieldEntry entry){
        super(Map.of("0.0", "All bellow", "2.0", "[2-4[", "4.0", "[4-6[", "6.0", "[6-8[", "8.0", "All above"), entry.getValue(), entry.getValueCount());
    }
}
