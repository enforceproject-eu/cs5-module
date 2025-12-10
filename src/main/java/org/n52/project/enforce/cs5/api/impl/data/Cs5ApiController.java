package org.n52.project.enforce.cs5.api.impl.data;

import java.util.Map;

import org.n52.project.enforce.cs5.api.Cs5Api;
import org.n52.project.enforce.cs5.model.Cs5DataRequest;
import org.n52.project.enforce.cs5.model.FeatureCollection;
import org.n52.project.enforce.cs5.utils.Cs5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-12-08T13:43:38.513185600+01:00[Europe/Berlin]", comments = "Generator version: 7.13.0")
@Controller
@RequestMapping("${openapi.eNFORCECS5DataAccess.base-path:}")
public class Cs5ApiController implements Cs5Api {

    Cs5Utils cs5Utils;

    @Autowired
    public Cs5ApiController(Cs5Utils cs5Utils) {
        this.cs5Utils = cs5Utils;
    }

    @Override
    public ResponseEntity<Void> addCs5DataAsBody(@Valid Map<String, Cs5DataRequest> requestBody) {
        cs5Utils.readMap(requestBody);
        return null;
    }

    @Override
    public ResponseEntity<FeatureCollection> getCs5Data() {
        // TODO Auto-generated method stub
        return null;
    }
}
