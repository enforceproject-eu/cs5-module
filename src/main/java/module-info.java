
module org.n52.project.enforce.cs5 {
    requires spring.context;
    requires spring.beans;
    requires spring.web;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.webmvc;
    requires org.apache.commons.io;
    requires org.apache.commons.logging;
    requires io.swagger.v3.oas.annotations;
    requires jakarta.validation;
    requires jakarta.persistence;
    requires jakarta.annotation;
    requires org.locationtech.jts;
    requires spring.core;
    requires org.slf4j;
//    requires tools.jackson.core;
//    requires tools.jackson.databind;
    requires org.openapitools.jackson.nullable;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    opens org.n52.project.enforce.cs5.api.impl.data_types;
    opens org.n52.project.enforce.cs5.api.impl.types;
    opens org.n52.project.enforce.cs5.api.impl.data;
    opens org.n52.project.enforce.cs5.api.impl.types_names;
    opens org.n52.project.enforce.cs5.utils;
    opens db.migrations;
}